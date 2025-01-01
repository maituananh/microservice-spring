package com.anhmt.room_service.consumer.model;

import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class RoomCreationConsumer {
    private String roomName;
    private UserRoom user;

    @Builder
    @Getter
    @Setter
    public static class UserRoom {
        private UUID id;
        private String username;
    }
}
