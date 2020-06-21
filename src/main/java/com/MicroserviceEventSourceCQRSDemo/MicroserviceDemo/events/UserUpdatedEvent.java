package com.MicroserviceEventSourceCQRSDemo.MicroserviceDemo.events;

import com.MicroserviceEventSourceCQRSDemo.MicroserviceDemo.aggregates.Status;

public class UserUpdatedEvent extends BaseEvent<String> {

    public final Status status;

    public UserUpdatedEvent(String id, Status status) {
        super(id);
        this.status = status;
    }
}
