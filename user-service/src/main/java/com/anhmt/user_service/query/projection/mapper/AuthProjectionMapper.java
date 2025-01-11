package com.anhmt.user_service.query.projection.mapper;

import com.anhmt.user_service.domain.Token;
import com.anhmt.user_service.domain.User;
import com.anhmt.user_service.query.api.response.UserLoginQueryResponse;
import com.anhmt.user_service.query.api.response.UserQueryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthProjectionMapper {

    AuthProjectionMapper INSTANCE = Mappers.getMapper(AuthProjectionMapper.class);

    UserLoginQueryResponse toUserLoginQueryResponse(Token token);
}
