package com.anhmt.user_service.adapter.keycloak.mapper;

import com.anhmt.user_service.client.keycloak.model.response.TokenResponse;
import com.anhmt.user_service.domain.Token;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface KeycloakMapper {
    KeycloakMapper INSTANCE = Mappers.getMapper(KeycloakMapper.class);

    Token toToken(TokenResponse tokenResponse);
}
