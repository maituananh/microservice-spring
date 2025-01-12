package com.anhmt.user_service.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "client")
public class ClientProperties {

    private KeycloakProperties keycloakProperties;

    @Setter
    @Getter
    @Component
    @ConfigurationProperties(prefix = "client.keycloak-client")
    public static class KeycloakProperties {
        private String realmsName;
        private String url;
        private String issuerUri;
        private String clientId;
        private String clientSecret;
        private String scope;
        private String grantType;
    }
}
