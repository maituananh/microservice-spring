package com.anhmt.bff_service.services;

import com.anhmt.bff_service.adapter.user.UserAdapter;
import com.anhmt.bff_service.api.user.input.TokenInput;
import com.anhmt.bff_service.api.user.mapper.UserMapper;
import com.anhmt.bff_service.api.user.output.TokenOutput;
import com.anhmt.bff_service.domain.Token;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserAdapter userAdapter;

    public TokenOutput login(final TokenInput tokenInput) {
        Token token = userAdapter.getToken(UserMapper.INSTANCE.toUser(tokenInput));
        return UserMapper.INSTANCE.toTokenOutput(token);
    }
}
