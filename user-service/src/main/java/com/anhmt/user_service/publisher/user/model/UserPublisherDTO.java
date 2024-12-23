package com.anhmt.user_service.publisher.user.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserPublisherDTO {
    private UUID id;
    private Long userId;
    private UserPublisherEnum event;
    private String data;
}
