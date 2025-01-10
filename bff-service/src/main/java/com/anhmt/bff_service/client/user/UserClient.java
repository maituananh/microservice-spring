package com.anhmt.bff_service.client.user;

import com.anhmt.bff_service.client.configuration.FeignConfig;
import com.anhmt.bff_service.client.user.request.UserCreationClientRequest;
import com.anhmt.bff_service.client.user.request.UserLoginClientRequest;
import com.anhmt.bff_service.client.user.request.UserUpdatingClientRequest;
import com.anhmt.bff_service.client.user.response.UserClientResponse;
import org.mapstruct.ap.internal.util.Strings;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "${client.user-client.name}", url = "${client.user-client.url}", configuration = FeignConfig.class)
public interface UserClient {

    String USER_API = "api/v1/users";
    String USER_AUTH = "api/v1/auth";

    @GetMapping(USER_API)
    List<UserClientResponse> getAllUsers();

    @PostMapping(USER_API)
    UUID createNewUser(@RequestBody UserCreationClientRequest userCreationClientRequest);

    @GetMapping(USER_API + "/{userId}")
    UserClientResponse getUserById(@PathVariable UUID userId);

    @DeleteMapping(USER_API + "/{userId}")
    UUID deleteUserById(@PathVariable UUID userId);

    @PutMapping(USER_API + "/{userId}")
    UUID updateUserById(@PathVariable UUID userId,
                        @RequestBody UserUpdatingClientRequest userUpdatingClientRequest);

    @PostMapping(USER_AUTH + "/token")
    void login(@RequestBody UserLoginClientRequest userLoginClientRequest);
}
