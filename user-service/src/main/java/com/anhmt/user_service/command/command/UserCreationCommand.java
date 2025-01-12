package com.anhmt.user_service.command.command;

import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCreationCommand {

    @TargetAggregateIdentifier
    private UUID id;

    private String name;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
}
