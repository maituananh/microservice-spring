package com.anhmt.booking_service.consumer.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingRoomReply {
    private String error;
    private BookingRoomStatusEnum status;
    private Payload payload;

    @Setter
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Payload {
        private UUID roomId;
    }
}
