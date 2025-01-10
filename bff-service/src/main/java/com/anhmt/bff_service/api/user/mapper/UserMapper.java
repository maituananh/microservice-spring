package com.anhmt.bff_service.api.user.mapper;

import com.anhmt.bff_service.api.user.input.UserCreationInput;
import com.anhmt.bff_service.api.user.input.UserLoginInput;
import com.anhmt.bff_service.api.user.input.UserUpdatingInput;
import com.anhmt.bff_service.api.user.output.UserCreationOutput;
import com.anhmt.bff_service.api.user.output.UserOutput;
import com.anhmt.bff_service.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toUser(UserCreationInput userCreationInput);

    User toUser(UserUpdatingInput userUpdatingInput);

    UserCreationOutput toUserCreationOutput(User user);

    List<UserOutput> toUsersOutput(List<User> users);

    User toUser(UserLoginInput userLoginInput);
}
