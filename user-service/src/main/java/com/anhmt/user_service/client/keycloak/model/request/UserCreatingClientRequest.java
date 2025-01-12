package com.anhmt.user_service.client.keycloak.model.request;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCreatingClientRequest {
    private String username;
    private boolean emailVerified;
    private String email;
    private String firstName;
    private String lastName;
    private boolean enabled;
    private List<CredentialsClientRequest> credentials;

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CredentialsClientRequest {
        private String type;
        private String value;
        private boolean temporary;
    }
}
