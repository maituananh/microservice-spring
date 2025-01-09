package com.anhmt.user_service.command.command.mapper;

import com.anhmt.user_service.command.api.user.req.UserCreateReq;
import com.anhmt.user_service.command.api.user.req.UserUpdateReq;
import com.anhmt.user_service.command.command.UserCreationCommand;
import com.anhmt.user_service.command.command.UserDeletingCommand;
import com.anhmt.user_service.command.command.UserUpdatingCommand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserCommandMapper {
    UserCommandMapper INSTANCE = Mappers.getMapper(UserCommandMapper.class);

    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID())")
    @Mapping(target = "name", source = "username")
    UserCreationCommand toUserCreationCommand(UserCreateReq userCreateReq);

    @Mapping(target = "name", source = "userUpdateReq.username")
    UserUpdatingCommand toUserUpdatingCommand(UUID id, UserUpdateReq userUpdateReq);

    UserDeletingCommand toUserDeletingCommand(UUID id);
}
