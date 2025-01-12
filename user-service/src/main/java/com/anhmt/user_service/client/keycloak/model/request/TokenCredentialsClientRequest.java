package com.anhmt.user_service.client.keycloak.model.request;

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
public class TokenCredentialsClientRequest {
    private String grant_type;
    private String client_id;
    private String client_secret;
    private String scope;
}
