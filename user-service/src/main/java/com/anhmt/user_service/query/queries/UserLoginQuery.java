package com.anhmt.user_service.query.queries;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginQuery {
    private String username;
    private String password;
}
