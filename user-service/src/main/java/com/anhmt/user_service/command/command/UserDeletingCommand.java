package com.anhmt.user_service.command.command;


import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDeletingCommand {

    @TargetAggregateIdentifier
    private UUID id;
}
