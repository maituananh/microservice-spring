package com.anhmt.user_service.command.aggregate;

import com.anhmt.user_service.command.command.UserCreationCommand;
import com.anhmt.user_service.command.command.UserDeletingCommand;
import com.anhmt.user_service.command.command.UserUpdatingCommand;
import com.anhmt.user_service.command.event.model.UserCreationEvent;
import com.anhmt.user_service.command.event.model.UserDeletingEvent;
import com.anhmt.user_service.command.event.model.UserUpdatingEvent;
import com.anhmt.user_service.command.event.mapper.UserEventMapper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateCreationPolicy;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.CreationPolicy;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;

@Getter
@Setter
@Aggregate
@NoArgsConstructor
public class UserAggregate {

    @AggregateIdentifier
    private UUID id;

    private String name;
    private String email;
    private String password;

    @CommandHandler
    @CreationPolicy(AggregateCreationPolicy.CREATE_IF_MISSING)
    public void handle(final UserCreationCommand userCreationCommand) {
        UserCreationEvent userCreationEvent = UserEventMapper.INSTANCE.toUserCreationEvent(userCreationCommand);
        AggregateLifecycle.apply(userCreationEvent);
    }

    @CommandHandler
    @CreationPolicy(AggregateCreationPolicy.CREATE_IF_MISSING)
    public void handle(final UserUpdatingCommand userUpdatingCommand) {
        UserUpdatingEvent userUpdatingEvent = UserEventMapper.INSTANCE.toUserUpdatingEvent(userUpdatingCommand);
        AggregateLifecycle.apply(userUpdatingEvent);
    }

    @CommandHandler
    @CreationPolicy(AggregateCreationPolicy.CREATE_IF_MISSING)
    public void handle(final UserDeletingCommand userDeletingCommand) {
        UserDeletingEvent userDeletingEvent = UserEventMapper.INSTANCE.toUserDeletingEvent(userDeletingCommand);
        AggregateLifecycle.apply(userDeletingEvent);
    }

    @EventSourcingHandler
    public void on(final UserCreationEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.email = event.getEmail();
        this.password = event.getPassword();
    }

    @EventSourcingHandler
    public void on(final UserUpdatingEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.email = event.getEmail();
    }

    @EventSourcingHandler
    public void on(final UserDeletingEvent event) {
        this.id = event.getId();
    }
}
