package com.anhmt.bff_service.client.booking.response;

import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BookingClientResponse {
    private UUID id;
    private String name;
}
