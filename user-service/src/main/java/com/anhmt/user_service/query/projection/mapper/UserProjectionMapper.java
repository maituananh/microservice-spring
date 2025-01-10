package com.anhmt.user_service.query.projection.mapper;

import com.anhmt.user_service.domain.User;
import com.anhmt.user_service.query.api.response.UserQueryResponse;
import com.anhmt.user_service.query.queries.UserQuery;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserProjectionMapper {

    UserProjectionMapper INSTANCE = Mappers.getMapper(UserProjectionMapper.class);

    List<UserQueryResponse> toUserQueryResponseList(List<User> users);

    UserQueryResponse toUserQueryResponse(User user);
}
