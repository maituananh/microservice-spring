package com.anhmt.notification_service.subscriber.user.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserSubscriberDTO {
    private UUID id;
    private Long userId;
    private UserSubscriberEnum event;
    private String data;
}
