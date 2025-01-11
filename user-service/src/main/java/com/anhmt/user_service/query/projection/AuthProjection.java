package com.anhmt.user_service.query.projection;

import com.anhmt.user_service.adapter.keycloak.KeycloakAdapter;
import com.anhmt.user_service.domain.Token;
import com.anhmt.user_service.query.api.response.UserLoginQueryResponse;
import com.anhmt.user_service.query.projection.mapper.AuthProjectionMapper;
import com.anhmt.user_service.query.queries.UserLoginQuery;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthProjection {

    private final KeycloakAdapter keyCloakAdapter;

    @QueryHandler
    public UserLoginQueryResponse handle(final UserLoginQuery userLoginQuery) {
        Token token = keyCloakAdapter.getToken(userLoginQuery);
        return AuthProjectionMapper.INSTANCE.toUserLoginQueryResponse(token);
    }
}
