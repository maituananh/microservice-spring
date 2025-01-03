package com.anhmt.user_service.query.api.res;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserFetchingAllRes {
    private UUID id;
    private String username;
}
