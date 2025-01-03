package com.anhmt.user_service.presenter.user;

import com.anhmt.user_service.domain.User;
import com.anhmt.user_service.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserStore {

    private final UserRepository userRepository;

    public User get(final String username) {
        return userRepository.findByUsername(username);
    }

    public User save(final User user) {
        return userRepository.save(user);
    }
}
