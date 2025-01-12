package com.anhmt.user_service.query.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginQueryResponse {
    private String accessToken;
    private Long expiresIn;
    private Long refreshExpiresIn;
    private String refreshToken;
    private String tokenType;
    private String idToken;
    private String scope;
}
