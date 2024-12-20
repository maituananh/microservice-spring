package com.anhmt.user_service.client.keycloak;

import com.anhmt.user_service.client.keycloak.configuration.FeignClientFormatConfiguration;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "Keycloak-client", url = "${client.keycloak.base-url}", configuration = FeignClientFormatConfiguration.class)
public interface KeyCloakClient {

//    @PostMapping(value = "realms/${client.keycloak.realms}/protocol/openid-connect/token",
//            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//    GetTokenRes getTokenByPasswordGrantType(@RequestBody PasswordGrantTypeTokenParam param);
//
//    @GetMapping(value = "/admin/realms/${client.keycloak.realms}/users")
//    List<GetUserInfoRes> getAllUser();
}
