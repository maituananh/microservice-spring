package com.anhmt.user_service.query.service;

import com.anhmt.user_service.query.api.res.UserDetailRes;
import com.anhmt.user_service.query.api.res.UserFetchingAllRes;
import com.anhmt.user_service.query.queries.UserDetailQuery;
import com.anhmt.user_service.query.queries.UserFetchingAllQuery;
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

    public List<UserFetchingAllRes> getAll() {
        UserFetchingAllQuery userFetchingAllQuery = new UserFetchingAllQuery();
        return queryGateway
                .query(userFetchingAllQuery, ResponseTypes.multipleInstancesOf(UserFetchingAllRes.class))
                .join();
    }

    public UserDetailRes getUserDetail(final UUID id) {
        UserDetailQuery userDetailQuery = new UserDetailQuery();
        return queryGateway
                .query(userDetailQuery, ResponseTypes.instanceOf(UserDetailRes.class))
                .join();
    }
}
