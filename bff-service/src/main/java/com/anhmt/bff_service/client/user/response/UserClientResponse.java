package com.anhmt.bff_service.client.user.response;

import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserClientResponse {
    private UUID id;
    private String username;
    private String email;
}
