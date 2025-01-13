package com.anhmt.bff_service.adapter.user;

import com.anhmt.bff_service.adapter.user.mapper.UserAdapterMapper;
import com.anhmt.bff_service.client.user.UserClient;
import com.anhmt.bff_service.client.user.response.TokenClientResponse;
import com.anhmt.bff_service.domain.Token;
import com.anhmt.bff_service.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserAdapter {

    private final UserClient userClient;

    @Cacheable(value = "users", key = "#id", condition = "#id != null")
    public User getUserDetail(final UUID id) {
        return UserAdapterMapper.INSTANCE.toUser(userClient.getUserById(id));
    }

    public List<User> getAllUsers() {
        return UserAdapterMapper.INSTANCE.toUsers(userClient.getAllUsers());
    }

    public User createUser(final User user) {
        var id = userClient.createNewUser(UserAdapterMapper.INSTANCE.toUserCreationClientRequest(user));
        return UserAdapterMapper.INSTANCE.toUser(id);
    }

    public UUID updateUserById(final User user) {
        return userClient.updateUserById(user.getId(),
                UserAdapterMapper.INSTANCE.toUserUpdatingClientRequest(user));
    }

    @CacheEvict(value = "users", key = "#id", condition = "#id != null")
    public UUID deleteUserById(final UUID id) {
        return userClient.deleteUserById(id);
    }

    public Token getToken(final User user) {
        TokenClientResponse tokenClientResponse =
                userClient.tokenByUsernameAndPassword(UserAdapterMapper.INSTANCE.toUserLoginClientRequest(user));

        return UserAdapterMapper.INSTANCE.toToken(tokenClientResponse);
    }
}
