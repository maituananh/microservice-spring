package com.anhmt.user_service.command.event;

import com.anhmt.user_service.command.event.model.UserCreationEvent;
import com.anhmt.user_service.command.event.model.UserDeletingEvent;
import com.anhmt.user_service.command.event.model.UserUpdatingEvent;
import com.anhmt.user_service.domain.User;
import com.anhmt.user_service.presenter.UserStore;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserEventsHandler {

    private final UserStore userStore;

    @EventHandler
    public void on(UserCreationEvent event) {
        User user = new User();
        user.setId(event.getId());
        user.setUsername(event.getName());

        userStore.save(user);
    }

    @EventHandler
    public void on(UserUpdatingEvent event) {
        Optional<User> optionalUser = userStore.getById(event.getId());

        if (optionalUser.isEmpty()) {
            return;
        }

        User user = optionalUser.get();
        user.setId(event.getId());
        user.setUsername(event.getName());

        userStore.save(user);
    }

    @EventHandler
    public void on(UserDeletingEvent event) {
        userStore.deleteById(event.getId());
    }
}