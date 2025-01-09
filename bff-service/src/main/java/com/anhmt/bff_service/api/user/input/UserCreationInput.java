package com.anhmt.bff_service.api.user.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCreationInput {
    private String username;
    private String password;
    private String email;
}
