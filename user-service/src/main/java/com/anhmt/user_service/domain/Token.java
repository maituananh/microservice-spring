package com.anhmt.user_service.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Token {
    private String accessToken;
    private Long expiresIn;
    private Long refreshExpiresIn;
    private String refreshToken;
    private String tokenType;
    private String idToken;
    private String scope;
}
