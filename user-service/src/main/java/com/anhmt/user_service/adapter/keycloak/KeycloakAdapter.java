package com.anhmt.user_service.adapter.keycloak;

import com.anhmt.user_service.adapter.keycloak.mapper.KeycloakMapper;
import com.anhmt.user_service.client.keycloak.KeycloakClient;
import com.anhmt.user_service.client.keycloak.model.request.TokenRequest;
import com.anhmt.user_service.domain.Token;
import com.anhmt.user_service.query.queries.UserLoginQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KeycloakAdapter {

    private final KeycloakClient keycloakClient;

    public Token getToken(final UserLoginQuery userLoginQuery) {
        var response = keycloakClient.getTokenByPasswordGrantType(TokenRequest.builder()
                .username(userLoginQuery.getUsername())
                .password(userLoginQuery.getPassword())
                .build());

        return KeycloakMapper.INSTANCE.toToken(response);
    }
}
