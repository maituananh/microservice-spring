package com.anhmt.user_service.command.api.user.req;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateReq {
    private String email;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
}
