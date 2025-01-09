package com.anhmt.bff_service.api.user;

import com.anhmt.bff_service.api.user.input.UserCreationInput;
import com.anhmt.bff_service.api.user.input.UserUpdatingInput;
import com.anhmt.bff_service.api.user.output.UserOutput;
import com.anhmt.bff_service.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @MutationMapping
    public UUID createUser(@Argument UserCreationInput userCreationInput) {
        return userService.createNewUser(userCreationInput);
    }

    @MutationMapping
    public UUID updateUserById(@Argument UserUpdatingInput userUpdatingInput) {
        return userService.updateUserById(userUpdatingInput);
    }

    @MutationMapping
    public UUID deleteUserById(@Argument UUID id) {
        return userService.deleteUserById(id);
    }

    @QueryMapping
    public List<UserOutput> fetchAllUsers() {
        return userService.getAllUsers();
    }
}
