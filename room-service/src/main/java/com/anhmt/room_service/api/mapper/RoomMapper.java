package com.anhmt.room_service.api.mapper;

import com.anhmt.room_service.api.response.RoomRes;
import com.anhmt.room_service.presenter.entity.RoomEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RoomMapper {

    RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);

    RoomRes toRoomRes(RoomEntity roomEntity);
}
