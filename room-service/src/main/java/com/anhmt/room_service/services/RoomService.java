package com.anhmt.room_service.services;

import com.anhmt.room_service.api.mapper.RoomMapper;
import com.anhmt.room_service.api.response.RoomRes;
import com.anhmt.room_service.presenter.RoomStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomStore roomStore;

    public RoomRes getById(final UUID roomId) {
        var optionalRoom = roomStore.getById(roomId);

        if (optionalRoom.isPresent()) {
            return RoomMapper.INSTANCE.toRoomRes(optionalRoom.get());
        }

        throw new RuntimeException("Room not found");
    }
}
