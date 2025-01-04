package com.anhmt.bff_service.adapter.user;

import com.anhmt.bff_service.adapter.user.mapper.UserAdapterMapper;
import com.anhmt.bff_service.client.user.UserClient;
import com.anhmt.bff_service.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserAdapter {

    private final UserClient userClient;

    public User getUserDetail(final UUID id) {
        return UserAdapterMapper.INSTANCE.toUser(userClient.getUserById(id));
    }

    public List<User> getAllUsers() {
        return UserAdapterMapper.INSTANCE.toUsers(userClient.getAllUsers());
    }
}
