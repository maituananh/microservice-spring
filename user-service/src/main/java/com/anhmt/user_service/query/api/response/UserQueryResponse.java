package com.anhmt.user_service.query.api.response;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserQueryResponse {
    private UUID id;
    private String username;
}
