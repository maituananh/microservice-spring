package com.anhmt.user_service.api.user;

import com.anhmt.user_service.api.user.req.UserCreateReq;
import com.anhmt.user_service.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public void createUser(@RequestBody UserCreateReq user) {
        userService.save(user);
    }
}
