package com.anhmt.bff_service.producer.room.model;

import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class RoomCreationProducer {
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
