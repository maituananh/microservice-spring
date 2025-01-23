package com.anhmt.bff_service.api.user;

import com.anhmt.bff_service.api.user.input.TokenInput;
import com.anhmt.bff_service.api.user.output.TokenOutput;
import com.anhmt.bff_service.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @MutationMapping
    public TokenOutput token(@Argument final TokenInput tokenInput) {
        return authService.login(tokenInput);
    }
}
