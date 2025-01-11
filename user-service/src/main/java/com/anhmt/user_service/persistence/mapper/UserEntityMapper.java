package com.anhmt.user_service.persistence.mapper;

import com.anhmt.user_service.domain.User;
import com.anhmt.user_service.persistence.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {
    UserEntityMapper INSTANCE = Mappers.getMapper(UserEntityMapper.class);

    UserEntity toUserEntity(User user);

    User toUser(UserEntity userEntity);

    List<User> toUsers(List<UserEntity> usersEntity);
}
