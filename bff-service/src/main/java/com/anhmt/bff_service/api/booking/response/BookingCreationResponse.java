package com.anhmt.bff_service.api.booking.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class BookingCreationResponse {

    private UUID userId;
    private UUID roomId;
}
