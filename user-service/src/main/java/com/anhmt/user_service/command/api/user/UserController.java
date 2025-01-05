package com.anhmt.user_service.command.api.user;

import com.anhmt.user_service.command.api.user.req.UserCreateReq;
import com.anhmt.user_service.command.api.user.req.UserUpdateReq;
import com.anhmt.user_service.command.api.user.res.UserCreateRes;
import com.anhmt.user_service.command.api.user.res.UserUpdatingResponse;
import com.anhmt.user_service.command.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UUID> create(@RequestBody UserCreateReq user) {
        var id = userService.create(user);
        log.info("Created user: {}", id);
        return ResponseEntity.ok(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserUpdatingResponse> update(@PathVariable UUID id, @RequestBody UserUpdateReq req) {
        var userUpdatedId = userService.update(id, req);
        log.info("Updated user: {}", userUpdatedId);
        return ResponseEntity.ok(userUpdatedId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UUID> delete(@PathVariable UUID id) {
        var userDeletedId = userService.delete(id);
        log.info("Deleted user: {}", userDeletedId);
        return ResponseEntity.ok(userDeletedId);
    }
}
