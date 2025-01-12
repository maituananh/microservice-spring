package com.anhmt.user_service.adapter.keycloak;

import com.anhmt.user_service.adapter.keycloak.mapper.KeycloakMapper;
import com.anhmt.user_service.client.keycloak.KeycloakClient;
import com.anhmt.user_service.client.keycloak.model.request.TokenClientRequest;
import com.anhmt.user_service.client.keycloak.model.request.TokenCredentialsClientRequest;
import com.anhmt.user_service.client.keycloak.model.request.UserCreatingClientRequest;
import com.anhmt.user_service.domain.Token;
import com.anhmt.user_service.domain.User;
import com.anhmt.user_service.properties.ClientProperties;
import com.anhmt.user_service.query.queries.UserLoginQuery;
import io.grpc.netty.shaded.io.netty.handler.codec.http.HttpResponseStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class KeycloakAdapter {

    private final KeycloakClient keycloakClient;
    private final ClientProperties.KeycloakProperties keycloakProperties;

    public Token getTokenByUsernameAndPassword(final UserLoginQuery userLoginQuery) {
        var response = keycloakClient.getTokenByPasswordGrantType(
                TokenClientRequest.builder()
                                  .username(userLoginQuery.getUsername())
                                  .password(userLoginQuery.getPassword())
                                  .client_id(keycloakProperties.getClientId())
                                  .client_secret(keycloakProperties.getClientSecret())
                                  .scope(keycloakProperties.getScope())
                                  .grant_type(keycloakProperties.getGrantType())
                                  .build());
        return KeycloakMapper.INSTANCE.toToken(response);
    }

    public boolean createUser(final User user) {
        Token token = getTokenByClientCredentials();

        var credential = List.of(UserCreatingClientRequest
                                         .CredentialsClientRequest
                                         .builder()
                                         .type("password")
                                         .value(user.getPassword())
                                         .temporary(false)
                                         .build());

        var response = keycloakClient.createUser(
                String.format("%s %s", token.getTokenType(), token.getAccessToken()),
                UserCreatingClientRequest.builder()
                                         .username(user.getUsername())
                                         .enabled(true)
                                         .lastName("")
                                         .firstName("")
                                         .emailVerified(false)
                                         .email(user.getEmail())
                                         .credentials(credential)
                                         .build());

        if (response.status() == HttpResponseStatus.CREATED.code()) {
            return true;
        }

        log.error("error: {} {}", response.reason(), response.request());
        return false;
    }

    private Token getTokenByClientCredentials() {
        var response = keycloakClient.getTokenByCredentials(
                TokenCredentialsClientRequest.builder()
                                             .client_id(keycloakProperties.getClientId())
                                             .client_secret(keycloakProperties.getClientSecret())
                                             .scope(keycloakProperties.getScope())
                                             .grant_type("client_credentials")
                                             .build());
        return KeycloakMapper.INSTANCE.toToken(response);
    }
}
