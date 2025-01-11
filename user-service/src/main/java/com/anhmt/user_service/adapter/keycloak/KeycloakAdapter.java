package com.anhmt.user_service.adapter.keycloak;

import com.anhmt.user_service.adapter.keycloak.mapper.KeycloakMapper;
import com.anhmt.user_service.client.keycloak.KeycloakClient;
import com.anhmt.user_service.client.keycloak.model.request.TokenRequest;
import com.anhmt.user_service.domain.Token;
import com.anhmt.user_service.properties.ClientProperties;
import com.anhmt.user_service.query.queries.UserLoginQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KeycloakAdapter {

    private final KeycloakClient keycloakClient;
    private final ClientProperties.KeycloakProperties keycloakProperties;

    public Token getToken(final UserLoginQuery userLoginQuery) {
        var response = keycloakClient.getTokenByPasswordGrantType(TokenRequest.builder()
                .username(userLoginQuery.getUsername())
                .password(userLoginQuery.getPassword())
                .client_id(keycloakProperties.getClientId())
                .client_secret(keycloakProperties.getClientSecret())
                .scope(keycloakProperties.getScope())
                .grant_type(keycloakProperties.getGrantType())
                .build());

        return KeycloakMapper.INSTANCE.toToken(response);
    }
}
