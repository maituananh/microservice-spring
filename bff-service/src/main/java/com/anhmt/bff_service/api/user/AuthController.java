package com.anhmt.bff_service.api.user;

import com.anhmt.bff_service.api.user.input.UserLoginInput;
import com.anhmt.bff_service.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    public void token(@Argument final UserLoginInput userLoginInput) {
        authService.login(userLoginInput);
    }
}
