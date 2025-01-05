package com.anhmt.bff_service.client.user;

import com.anhmt.bff_service.client.user.request.UserCreationClientRequest;
import com.anhmt.bff_service.client.user.request.UserUpdatingClientRequest;
import com.anhmt.bff_service.client.user.response.UserClientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "${client.user-client.name}", url = "${client.user-client.url}")
public interface UserClient {

    @GetMapping("api/v1/users")
    List<UserClientResponse> getAllUsers();

    @GetMapping("/api/v1/users/{userId}")
    UserClientResponse getUserById(@PathVariable UUID userId);

    @PostMapping("/api/v1/users")
    UUID createNewUser(@RequestBody UserCreationClientRequest userCreationClientRequest);

    @PutMapping("/api/v1/users/{userId}")
    UUID updateUserById(@PathVariable UUID userId,
                        @RequestBody UserUpdatingClientRequest userUpdatingClientRequest);

    @DeleteMapping("/api/v1/users/{userId}")
    UUID deleteUserById(@PathVariable UUID userId);
}
