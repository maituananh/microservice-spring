package com.anhmt.bff_service.domain;

import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Room {
    private UUID id;
    private String name;
}
