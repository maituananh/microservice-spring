package com.anhmt.bff_service.adapter.user.mapper;

import com.anhmt.bff_service.client.user.response.UserClientResponse;
import com.anhmt.bff_service.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserAdapterMapper {

    UserAdapterMapper INSTANCE = Mappers.getMapper(UserAdapterMapper.class);

    User toUser(UserClientResponse userClientResponse);

    List<User> toUsers(List<UserClientResponse> userClientResponseList);
}
