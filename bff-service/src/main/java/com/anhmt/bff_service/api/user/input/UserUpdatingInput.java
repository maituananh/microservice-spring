package com.anhmt.bff_service.api.user.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdatingInput {
    private UUID id;
    private String username;
    private String email;
}
