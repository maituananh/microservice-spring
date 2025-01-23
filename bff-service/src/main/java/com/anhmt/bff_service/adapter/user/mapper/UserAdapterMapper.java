package com.anhmt.bff_service.adapter.user.mapper;

import com.anhmt.bff_service.client.user.request.UserCreationClientRequest;
import com.anhmt.bff_service.client.user.request.UserLoginClientRequest;
import com.anhmt.bff_service.client.user.request.UserUpdatingClientRequest;
import com.anhmt.bff_service.client.user.response.TokenClientResponse;
import com.anhmt.bff_service.client.user.response.UserClientResponse;
import com.anhmt.bff_service.domain.Token;
import com.anhmt.bff_service.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserAdapterMapper {

    UserAdapterMapper INSTANCE = Mappers.getMapper(UserAdapterMapper.class);

    User toUser(UserClientResponse userClientResponse);

    User toUser(UUID id);

    List<User> toUsers(List<UserClientResponse> userClientResponseList);

    UserCreationClientRequest toUserCreationClientRequest(User user);

    UserUpdatingClientRequest toUserUpdatingClientRequest(User user);

    UserLoginClientRequest toUserLoginClientRequest(User user);

    Token toToken(TokenClientResponse tokenClientResponse);
}
