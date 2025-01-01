package com.anhmt.bff_service.client.room.response;

import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RoomClientResponse {
    private UUID id;
    private String name;
}
