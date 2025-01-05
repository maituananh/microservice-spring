package com.anhmt.bff_service.services;

import com.anhmt.bff_service.adapter.user.UserAdapter;
import com.anhmt.bff_service.api.user.input.UserUpdatingInput;
import com.anhmt.bff_service.api.user.mapper.UserMapper;
import com.anhmt.bff_service.api.user.input.UserCreationInput;
import com.anhmt.bff_service.api.user.output.UserCreationOutput;
import com.anhmt.bff_service.api.user.output.UserOutput;
import com.anhmt.bff_service.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserAdapter userAdapter;

    public User getUserById(final UUID id) {
        return userAdapter.getUserDetail(id);
    }

    public List<UserOutput> getAllUsers() {
        return UserMapper.INSTANCE.toUsersOutput(userAdapter.getAllUsers());
    }

    public UUID createNewUser(final UserCreationInput userCreationInput) {
        var user = userAdapter.createUser(UserMapper.INSTANCE.toUser(userCreationInput));
        return UserMapper.INSTANCE.toUserCreationOutput(user).getId();
    }

    public UUID updateUserById(final UserUpdatingInput userUpdatingInput) {
        return userAdapter.updateUserById(UserMapper.INSTANCE.toUser(userUpdatingInput));
    }

    public UUID deleteUserById(final UUID id) {
        return userAdapter.deleteUserById(id);
    }
}
