package com.anhmt.user_service.command.event.mapper;

import com.anhmt.user_service.command.command.UserCreationCommand;
import com.anhmt.user_service.command.command.UserDeletingCommand;
import com.anhmt.user_service.command.command.UserUpdatingCommand;
import com.anhmt.user_service.command.event.model.UserCreationEvent;
import com.anhmt.user_service.command.event.model.UserDeletingEvent;
import com.anhmt.user_service.command.event.model.UserUpdatingEvent;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserEventMapper {
    UserEventMapper INSTANCE = Mappers.getMapper(UserEventMapper.class);

    UserCreationEvent toUserCreationEvent(UserCreationCommand userCreationCommand);

    UserUpdatingEvent toUserUpdatingEvent(UserUpdatingCommand userUpdatingCommand);

    UserDeletingEvent toUserDeletingEvent(UserDeletingCommand userDeletingCommand);
}
