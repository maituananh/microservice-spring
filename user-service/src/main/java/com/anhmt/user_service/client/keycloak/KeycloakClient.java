package com.anhmt.user_service.client.keycloak;

import com.anhmt.user_service.client.keycloak.configuration.FeignClientFormatConfiguration;
import com.anhmt.user_service.client.keycloak.model.request.TokenClientRequest;
import com.anhmt.user_service.client.keycloak.model.request.TokenCredentialsClientRequest;
import com.anhmt.user_service.client.keycloak.model.request.UserCreatingClientRequest;
import com.anhmt.user_service.client.keycloak.model.response.TokenClientResponse;
import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name = "${client.keycloak-client.name}", url = "${client.keycloak-client.url}", configuration = FeignClientFormatConfiguration.class)
public interface KeycloakClient {

    @PostMapping(value = "realms/${client.keycloak-client.realms-name}/protocol/openid-connect/token",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    TokenClientResponse getTokenByPasswordGrantType(@RequestBody TokenClientRequest tokenClientRequest);

    @PostMapping(value = "realms/${client.keycloak-client.realms-name}/protocol/openid-connect/token",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    TokenClientResponse getTokenByCredentials(@RequestBody TokenCredentialsClientRequest tokenCredentialsClientRequest);

    @PostMapping(value = "/admin/realms/${client.keycloak-client.realms-name}/users")
    Response createUser(@RequestHeader("Authorization") String bearerToken,
                        @RequestBody UserCreatingClientRequest userCreatingClientRequest);

    @GetMapping(value = "/admin/realms/${client.keycloak-client.realms-name}/users")
    List<String> getAllUser();
}
