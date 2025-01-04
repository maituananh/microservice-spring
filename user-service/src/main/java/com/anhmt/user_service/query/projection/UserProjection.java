package com.anhmt.user_service.query.projection;

import com.anhmt.user_service.domain.User;
import com.anhmt.user_service.query.api.res.UserFetchingAllRes;
import com.anhmt.user_service.query.projection.mapper.UserProjectionMapper;
import com.anhmt.user_service.query.queries.UserFetchingAllQuery;
import com.anhmt.user_service.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserProjection {

    private final UserRepository userRepository;

    @QueryHandler
    public List<UserFetchingAllRes> handle(UserFetchingAllQuery userFetchingAllQuery) {
        List<User> users = userRepository.findAll();
        return UserProjectionMapper.INSTANCE.toUserFetchingAllResList(users);
    }
}
