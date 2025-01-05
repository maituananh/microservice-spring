package com.anhmt.user_service.command.api.user;

import com.anhmt.user_service.command.api.user.res.UserUpdatingResponse;
import com.anhmt.user_service.command.command.UserUpdatingCommand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "username", source = "name")
    UserUpdatingResponse toUserUpdatingResponse(UserUpdatingCommand userUpdatingCommand);
}
