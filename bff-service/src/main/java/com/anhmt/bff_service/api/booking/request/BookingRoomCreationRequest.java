package com.anhmt.bff_service.api.booking.request;

import jakarta.annotation.Nonnull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class BookingRoomCreationRequest {

    @Nonnull
    private UUID userId;

    @Nonnull
    private UUID roomId;
}
