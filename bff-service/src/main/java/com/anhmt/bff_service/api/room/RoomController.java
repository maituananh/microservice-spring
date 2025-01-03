package com.anhmt.bff_service.api.room;

import com.anhmt.bff_service.api.booking.response.BookingCreationResponse;
import com.anhmt.bff_service.api.room.model.FetchingAllRoomResponse;
import com.anhmt.bff_service.api.room.model.RoomCreationReq;
import com.anhmt.bff_service.services.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/rooms")
public class RoomController {

    private final RoomService roomService;

    @PostMapping
    public ResponseEntity<BookingCreationResponse> createRoom(@RequestBody RoomCreationReq roomCreationReq) {
        roomService.createNewRoom(roomCreationReq);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<FetchingAllRoomResponse>> fetchAllRooms() {
        return ResponseEntity.ok(roomService.fetchAllRoom());
    }
}
