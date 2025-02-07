package com.anhmt.bff_service.client.user.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserCreationClientRequest {
    private String username;
    private String password;
    private String email;
}
