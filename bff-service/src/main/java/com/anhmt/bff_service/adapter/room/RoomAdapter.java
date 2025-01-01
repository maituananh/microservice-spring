package com.anhmt.bff_service.adapter.room;

import com.anhmt.bff_service.adapter.room.mapper.RoomAdapterMapper;
import com.anhmt.bff_service.client.room.RoomClient;
import com.anhmt.bff_service.domain.Room;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class RoomAdapter {

    private final RoomClient roomClient;

    public List<Room> fetchAllRooms() {
        return RoomAdapterMapper.INSTANCE.toRooms(roomClient.fetchAllRooms());
    }

    public Room getRoomById(final UUID roomId) {
        return RoomAdapterMapper.INSTANCE.toRoom(roomClient.getRoomById(roomId));
    }
}
