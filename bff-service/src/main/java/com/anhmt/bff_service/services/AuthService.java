package com.anhmt.bff_service.services;

import com.anhmt.bff_service.adapter.user.UserAdapter;
import com.anhmt.bff_service.api.user.input.UserLoginInput;
import com.anhmt.bff_service.api.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserAdapter userAdapter;

    public void login(final UserLoginInput userLoginInput) {
        userAdapter.login(UserMapper.INSTANCE.toUser(userLoginInput));
    }
}
