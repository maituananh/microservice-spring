package com.anhmt.bff_service.api.room.mapper;

import com.anhmt.bff_service.api.room.model.FetchingAllRoomResponse;
import com.anhmt.bff_service.domain.Room;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoomMapper {

    RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);

    List<FetchingAllRoomResponse> toFetchingAllRoomResponse(List<Room> rooms);
}
