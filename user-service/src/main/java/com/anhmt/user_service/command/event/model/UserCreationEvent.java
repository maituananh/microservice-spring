package com.anhmt.user_service.command.event.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCreationEvent {
    private UUID id;
    private String name;
    private String email;
    private String password;
}
