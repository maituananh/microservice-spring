package com.anhmt.user_service.client.keycloak.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCreatingClientResponse {
    private String username;
    private boolean emailVerified;
    private String email;
    private String firstName;
    private String lastName;
    private boolean enable;
}
