package com.anhmt.user_service.command.service.user;

import com.anhmt.user_service.command.api.user.req.UserCreateReq;
import com.anhmt.user_service.command.api.user.req.UserUpdateReq;
import com.anhmt.user_service.command.command.UserCreationCommand;
import com.anhmt.user_service.command.command.UserDeletingCommand;
import com.anhmt.user_service.command.command.UserUpdatingCommand;
import com.anhmt.user_service.command.command.mapper.UserCommandMapper;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final CommandGateway commandGateway;

    public void create(final UserCreateReq userCreateReq) {
        UserCreationCommand command = UserCommandMapper.INSTANCE.toUserCreationCommand(userCreateReq);
        commandGateway.send(command);
    }

    public void update(final UUID id, final UserUpdateReq req) {
        UserUpdatingCommand command = UserCommandMapper.INSTANCE.toUserUpdatingCommand(id, req);
        commandGateway.send(command);
    }

    public void delete(final UUID id) {
        UserDeletingCommand userDeletingCommand = UserCommandMapper.INSTANCE.toUserDeletingCommand(id);
        commandGateway.send(userDeletingCommand);
    }
}
