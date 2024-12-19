package com.anhmt.user_service.service.user;

import com.anhmt.user_service.publish.user.UserPublish;
import com.anhmt.user_service.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserPublish userPublish;

    public void save() {

    }
}
