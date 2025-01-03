package com.anhmt.room_service.api;

import com.anhmt.room_service.api.response.RoomRes;
import com.anhmt.room_service.services.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/room")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @GetMapping("/{roomId}")
    public ResponseEntity<RoomRes> getDetail(@PathVariable UUID roomId) {
        return ResponseEntity.ok(roomService.getById(roomId));
    }
}
