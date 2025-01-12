package com.anhmt.user_service.command.event.mapper;

import com.anhmt.user_service.command.command.UserCreationCommand;
import com.anhmt.user_service.command.command.UserDeletingCommand;
import com.anhmt.user_service.command.command.UserUpdatingCommand;
import com.anhmt.user_service.command.event.model.UserCreationEvent;
import com.anhmt.user_service.command.event.model.UserDeletingEvent;
import com.anhmt.user_service.command.event.model.UserUpdatingEvent;
import com.anhmt.user_service.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface UserEventMapper {
    UserEventMapper INSTANCE = Mappers.getMapper(UserEventMapper.class);

    UserCreationEvent toUserCreationEvent(UserCreationCommand userCreationCommand);

    UserUpdatingEvent toUserUpdatingEvent(UserUpdatingCommand userUpdatingCommand);

    UserDeletingEvent toUserDeletingEvent(UserDeletingCommand userDeletingCommand);

    @Mapping(target = "username", source = "name")
    User toUser(UserCreationEvent userCreationEvent);
}
