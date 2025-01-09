package com.anhmt.bff_service.api.user.output;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserOutput {
    private UUID id;
    private String username;
    private String email;
}
