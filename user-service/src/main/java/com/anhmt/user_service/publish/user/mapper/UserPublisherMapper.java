package com.anhmt.user_service.publish.user.mapper;

import com.anhmt.user_service.api.user.req.UserCreateReq;
import com.anhmt.user_service.publish.user.model.UserPublisher;
import com.anhmt.user_service.publish.user.model.UserPublisherEnum;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserPublisherMapper {

    UserPublisherMapper INSTANCE = Mappers.getMapper(UserPublisherMapper.class);

    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID())")
    @Mapping(target = "event", source = "userPublisherEnum")
    @Mapping(target = "data", source = "userCreateReq.username")
    UserPublisher toUserPublisher(UserCreateReq userCreateReq, UserPublisherEnum userPublisherEnum);
}
