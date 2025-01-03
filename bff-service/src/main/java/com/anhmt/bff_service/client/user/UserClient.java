package com.anhmt.bff_service.client.user;

import com.anhmt.bff_service.client.user.response.UserClientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "${client.user-client.name}", url = "${client.user-client.url}")
public interface UserClient {

    @GetMapping("api/v1/users")
    List<UserClientResponse> getAllUsers();

    @GetMapping("/api/v1/users/{userId}")
    UserClientResponse getUserById(@PathVariable UUID userId);
}
