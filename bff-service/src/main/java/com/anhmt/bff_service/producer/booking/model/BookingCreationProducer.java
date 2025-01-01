package com.anhmt.bff_service.producer.booking.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingCreationProducer {
    private UUID userId;
    private UUID roomId;
}
