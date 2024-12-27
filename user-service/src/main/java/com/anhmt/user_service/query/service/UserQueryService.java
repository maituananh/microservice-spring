package com.anhmt.user_service.query.service;

import com.anhmt.user_service.query.api.res.UserFetchingAllRes;
import com.anhmt.user_service.query.queries.UserFetchingAllQuery;
import lombok.RequiredArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
