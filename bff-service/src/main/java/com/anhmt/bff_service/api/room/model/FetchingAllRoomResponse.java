package com.anhmt.bff_service.api.room.model;

import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class FetchingAllRoomResponse {

    private UUID id;
    private String name;
}
