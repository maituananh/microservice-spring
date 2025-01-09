package com.anhmt.user_service.query.queries;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserQuery {
    private UUID id;
    private String username;
}
