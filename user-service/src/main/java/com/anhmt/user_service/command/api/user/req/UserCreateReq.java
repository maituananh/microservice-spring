package com.anhmt.user_service.command.api.user.req;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateReq {
    private String username;
    private String password;
}
