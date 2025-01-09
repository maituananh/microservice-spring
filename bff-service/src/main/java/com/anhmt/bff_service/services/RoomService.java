package com.anhmt.bff_service.services;

import com.anhmt.bff_service.adapter.room.RoomAdapter;
import com.anhmt.bff_service.adapter.user.UserAdapter;
import com.anhmt.bff_service.api.room.mapper.RoomMapper;
import com.anhmt.bff_service.api.room.output.RoomOutput;
import com.anhmt.bff_service.api.room.input.RoomCreationInput;
import com.anhmt.bff_service.domain.User;
import com.anhmt.bff_service.producer.room.RoomProducer;
import com.anhmt.bff_service.producer.room.model.RoomCreationProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final UserAdapter userAdapter;
    private final RoomProducer roomProducer;
    private final RoomAdapter roomAdapter;

    public void createNewRoom(final RoomCreationInput req) {
        User user = userAdapter.getUserDetail(req.getUserId());

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        RoomCreationProducer producer = RoomCreationProducer.builder()
                .roomName(req.getRoomName())
                .user(RoomCreationProducer.UserRoom.builder()
                        .id(user.getId())
                        .username(user.getUsername())
                        .build())
                .build();

        roomProducer.createRoom(producer);
    }

    public List<RoomOutput> fetchAllRooms() {
        return RoomMapper.INSTANCE.toFetchingAllRoomResponse(roomAdapter.fetchAllRooms());
    }
}
