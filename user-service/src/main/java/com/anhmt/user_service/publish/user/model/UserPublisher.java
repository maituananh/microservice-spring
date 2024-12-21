package com.anhmt.user_service.publish.user.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserPublisher {
    private UUID id;
    private Long userId;
    private UserPublisherEnum event;
    private String data;
}
