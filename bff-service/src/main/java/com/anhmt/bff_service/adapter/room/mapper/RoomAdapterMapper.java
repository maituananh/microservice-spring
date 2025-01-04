package com.anhmt.bff_service.adapter.room.mapper;

import com.anhmt.bff_service.client.room.response.RoomClientResponse;
import com.anhmt.bff_service.domain.Room;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoomAdapterMapper {

    RoomAdapterMapper INSTANCE = Mappers.getMapper(RoomAdapterMapper.class);

    List<Room> toRooms(List<RoomClientResponse> roomClientResponse);

    Room toRoom(RoomClientResponse roomClientResponse);
}
