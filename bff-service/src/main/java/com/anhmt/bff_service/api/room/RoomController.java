package com.anhmt.bff_service.api.room;

import com.anhmt.bff_service.api.room.input.RoomCreationInput;
import com.anhmt.bff_service.api.room.output.RoomOutput;
import com.anhmt.bff_service.services.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @QueryMapping
    public List<RoomOutput> fetchAllRooms() {
        return roomService.fetchAllRooms();
    }

    @MutationMapping
    public ResponseEntity<?> createRoom(@Argument RoomCreationInput roomCreationInput) {
        roomService.createNewRoom(roomCreationInput);
        return ResponseEntity.noContent().build();
    }
}
