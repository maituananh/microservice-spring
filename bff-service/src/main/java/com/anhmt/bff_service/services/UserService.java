package com.anhmt.bff_service.services;

import com.anhmt.bff_service.adapter.user.UserAdapter;
import com.anhmt.bff_service.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserAdapter userAdapter;

    public User getUserById(final UUID id) {
        return userAdapter.getUserDetail(id);
    }
}
