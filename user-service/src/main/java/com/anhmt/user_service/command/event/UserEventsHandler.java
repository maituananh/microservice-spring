package com.anhmt.user_service.command.event;

import com.anhmt.user_service.command.event.model.UserCreationEvent;
import com.anhmt.user_service.command.event.model.UserDeletingEvent;
import com.anhmt.user_service.command.event.model.UserUpdatingEvent;
import com.anhmt.user_service.domain.User;
import com.anhmt.user_service.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserEventsHandler {

    private final UserRepository userRepository;

    @EventHandler
    public void on(UserCreationEvent event) {
        User user = new User();
        user.setId(event.getId());
        user.setUsername(event.getName());

        userRepository.save(user);
    }

    @EventHandler
    public void on(UserUpdatingEvent event) {
        Optional<User> optionalUser = userRepository.findById(event.getId());

        if (optionalUser.isEmpty()) {
            return;
        }

        User user = optionalUser.get();
        user.setId(event.getId());
        user.setUsername(event.getName());

        userRepository.save(user);
    }

    @EventHandler
    public void on(UserDeletingEvent event) {
        userRepository.deleteById(event.getId());
    }
}