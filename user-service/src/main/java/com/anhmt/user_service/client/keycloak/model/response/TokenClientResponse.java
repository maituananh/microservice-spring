package com.anhmt.user_service.client.keycloak.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TokenClientResponse {
    private String access_token;
    private Long expires_in;
    private Long refresh_expires_in;
    private String refresh_token;
    private String token_type;
    private String id_token;
    private String scope;
}
