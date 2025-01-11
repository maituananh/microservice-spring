package com.anhmt.user_service.adapter.keycloak.mapper;

import com.anhmt.user_service.client.keycloak.model.response.TokenResponse;
import com.anhmt.user_service.domain.Token;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface KeycloakMapper {
    KeycloakMapper INSTANCE = Mappers.getMapper(KeycloakMapper.class);

    @Mapping(target = "accessToken", source = "access_token")
    @Mapping(target = "expiresIn", source = "expires_in")
    @Mapping(target = "refreshExpiresIn", source = "refresh_expires_in")
    @Mapping(target = "refreshToken", source = "refresh_token")
    @Mapping(target = "tokenType", source = "token_type")
    @Mapping(target = "idToken", source = "id_token")
    Token toToken(TokenResponse tokenResponse);
}
