package com.MicroserviceEventSourceCQRSDemo.MicroserviceDemo.aggregates;

import com.MicroserviceEventSourceCQRSDemo.MicroserviceDemo.commands.CreateUserCommand;
import com.MicroserviceEventSourceCQRSDemo.MicroserviceDemo.events.*;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class UserAggregate {

    @AggregateIdentifier
    private String id;

    private String address;

    private String name;

    private String status;

    public UserAggregate() {
    }

    @CommandHandler
    public UserAggregate(CreateUserCommand createUserCommand){
        AggregateLifecycle.apply(new UserCreatedEvent(createUserCommand.id, createUserCommand.address, createUserCommand.name));
    }

    @EventSourcingHandler
    protected void on(UserCreatedEvent userCreatedEvent){
        this.id = userCreatedEvent.id;
        this.address = userCreatedEvent.address;
        this.name = userCreatedEvent.name;
        this.status = String.valueOf(Status.CREATED);

        AggregateLifecycle.apply(new UserActivatedEvent(this.id, Status.ACTIVATED));
    }

    @EventSourcingHandler
    protected void on(UserActivatedEvent userActivatedEvent){
        this.status = String.valueOf(userActivatedEvent.status);
    }

    @EventSourcingHandler
    protected void on(UserChangedEvent userChangedEvent){

        this.address = userChangedEvent.address;
        this.name = userChangedEvent.name;
        this.status = String.valueOf(Status.CHANGED);

        AggregateLifecycle.apply(new UserUpdatedEvent(this.id, Status.UPDATED));
    }

    @EventSourcingHandler
    protected void on(UserUpdatedEvent userUpdatedEvent){
        this.status = String.valueOf(userUpdatedEvent.status);
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
