package com.anhmt.user_service.command.api.user;

import com.anhmt.user_service.command.api.user.req.UserCreateReq;
import com.anhmt.user_service.command.api.user.req.UserUpdateReq;
import com.anhmt.user_service.command.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public void create(@RequestBody UserCreateReq user) {
        userService.create(user);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable UUID id, @RequestBody UserUpdateReq req) {
        userService.update(id, req);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        userService.delete(id);
    }
}
