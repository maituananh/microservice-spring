package com.anhmt.user_service.api.user.req;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateReq {
    private String username;
    private String password;
}
