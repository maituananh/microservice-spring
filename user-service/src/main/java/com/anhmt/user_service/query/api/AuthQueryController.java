package com.anhmt.user_service.query.api;

import com.anhmt.user_service.query.api.request.UserLoginRequest;
import com.anhmt.user_service.query.api.response.UserLoginQueryResponse;
import com.anhmt.user_service.query.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/auth")
public class AuthQueryController {

    private final AuthService authService;

    @PostMapping
    public ResponseEntity<UserLoginQueryResponse> token(@RequestBody UserLoginRequest userLoginRequest) {
        return ResponseEntity.ok(authService.getToken(userLoginRequest));
    }
}
