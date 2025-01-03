package com.anhmt.bff_service.api.room.model;

import jakarta.annotation.Nonnull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class RoomCreationReq {

    @Nonnull
    private UUID userId;

    @Nonnull
    private String roomName;
}
