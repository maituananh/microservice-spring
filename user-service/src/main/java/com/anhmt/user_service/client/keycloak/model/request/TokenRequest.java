package com.anhmt.user_service.client.keycloak.model.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TokenRequest {
    private String username;
    private String password;
}
