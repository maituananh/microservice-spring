package com.anhmt.bff_service.api.room.input;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoomCreationInput {
    private UUID userId;
    private String roomName;
}
