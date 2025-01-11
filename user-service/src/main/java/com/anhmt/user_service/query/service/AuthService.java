package com.anhmt.user_service.query.service;

import com.anhmt.user_service.query.api.request.UserLoginRequest;
import com.anhmt.user_service.query.api.response.UserLoginQueryResponse;
import com.anhmt.user_service.query.queries.UserLoginQuery;
import lombok.RequiredArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final QueryGateway queryGateway;

    public UserLoginQueryResponse getToken(final UserLoginRequest userLoginRequest) {
        return queryGateway.query(UserLoginQuery.builder()
                        .username(userLoginRequest.getUsername())
                        .password(userLoginRequest.getPassword())
                        .build(),
                        ResponseTypes.instanceOf(UserLoginQueryResponse.class)).join();
    }
}
