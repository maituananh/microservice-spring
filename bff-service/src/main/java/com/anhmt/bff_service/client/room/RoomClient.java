package com.anhmt.bff_service.client.room;

import com.anhmt.bff_service.client.configuration.FeignConfig;
import com.anhmt.bff_service.client.room.response.RoomClientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "${client.room-client.name}", url = "${client.room-client.url}", configuration = FeignConfig.class)
public interface RoomClient {

    @GetMapping("api/v1/rooms")
    List<RoomClientResponse> fetchAllRooms();

    @GetMapping("/api/v1/rooms/{roomId}")
    RoomClientResponse getRoomById(@PathVariable UUID roomId);
}
