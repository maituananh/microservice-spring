package com.anhmt.user_service.command.service.user;

import com.anhmt.user_service.command.api.user.UserMapper;
import com.anhmt.user_service.command.api.user.req.UserCreateReq;
import com.anhmt.user_service.command.api.user.req.UserUpdateReq;
import com.anhmt.user_service.command.api.user.res.UserUpdatingResponse;
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

    public UUID create(final UserCreateReq userCreateReq) {
        UserCreationCommand command = UserCommandMapper.INSTANCE.toUserCreationCommand(userCreateReq);
        return commandGateway.sendAndWait(command);
    }

    public UserUpdatingResponse update(final UUID id, final UserUpdateReq req) {
        UserUpdatingCommand command = UserCommandMapper.INSTANCE.toUserUpdatingCommand(id, req);
        commandGateway.sendAndWait(command);
        return UserMapper.INSTANCE.toUserUpdatingResponse(command);
    }

    public UUID delete(final UUID id) {
        UserDeletingCommand command = UserCommandMapper.INSTANCE.toUserDeletingCommand(id);
        commandGateway.sendAndWait(command);
        return command.getId();
    }
}
