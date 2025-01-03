package com.anhmt.room_service.consumer.mapper;

import com.anhmt.room_service.consumer.model.RoomCreationConsumer;
import com.anhmt.room_service.presenter.entity.RoomEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoomConsumerMapper {

    RoomConsumerMapper INSTANCE = Mappers.getMapper(RoomConsumerMapper.class);

    @Mapping(target = "name", source = "roomCreationConsumer.roomName")
    @Mapping(target = "createdBy", source = "roomCreationConsumer.user.id")
    RoomEntity toRoomEntity(RoomCreationConsumer roomCreationConsumer);
}
