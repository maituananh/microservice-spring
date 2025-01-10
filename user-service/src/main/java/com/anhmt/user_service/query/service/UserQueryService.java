package com.anhmt.user_service.query.service;

import com.anhmt.user_service.query.api.response.UserQueryResponse;
import com.anhmt.user_service.query.queries.UserAllQuery;
import com.anhmt.user_service.query.queries.UserQuery;
import lombok.RequiredArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserQueryService {

    private final QueryGateway queryGateway;

    public List<UserQueryResponse> getAll() {
        return queryGateway.query(new UserAllQuery(), ResponseTypes.multipleInstancesOf(UserQueryResponse.class))
                .join();
    }

    public UserQueryResponse getUserDetail(final UUID id) {
        return queryGateway.query(UserQuery.builder().id(id).build(), ResponseTypes.instanceOf(UserQueryResponse.class))
                .join();
    }
}
