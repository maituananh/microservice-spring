package com.anhmt.user_service.query.projection;

import com.anhmt.user_service.domain.User;
import com.anhmt.user_service.query.api.response.UserQueryResponse;
import com.anhmt.user_service.query.projection.mapper.UserProjectionMapper;
import com.anhmt.user_service.query.queries.UserAllQuery;
import com.anhmt.user_service.query.queries.UserQuery;
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
    public UserQueryResponse handle(UserQuery userQuery) {
        User user = userRepository.findById(userQuery.getId()).orElse(null);
        return UserProjectionMapper.INSTANCE.toUserQueryResponse(user);
    }

    @QueryHandler
    public List<UserQueryResponse> handle(UserAllQuery userAllQuery) {
        List<User> users = userRepository.findAll();
        return UserProjectionMapper.INSTANCE.toUserQueryResponseList(users);
    }
}
