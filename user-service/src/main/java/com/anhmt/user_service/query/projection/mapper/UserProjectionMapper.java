package com.anhmt.user_service.query.projection.mapper;

import com.anhmt.user_service.domain.User;
import com.anhmt.user_service.query.api.res.UserFetchingAllRes;
import com.anhmt.user_service.query.queries.UserFetchingAllQuery;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserProjectionMapper {

    UserProjectionMapper INSTANCE = Mappers.getMapper(UserProjectionMapper.class);

    List<UserFetchingAllQuery> toUserFetchingAllQueryList(List<User> users);

    List<UserFetchingAllRes> toUserFetchingAllResList(List<User> users);

}
