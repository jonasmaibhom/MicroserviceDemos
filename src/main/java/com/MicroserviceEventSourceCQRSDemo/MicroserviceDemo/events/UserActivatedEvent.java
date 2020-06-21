package com.MicroserviceEventSourceCQRSDemo.MicroserviceDemo.events;

import com.MicroserviceEventSourceCQRSDemo.MicroserviceDemo.aggregates.Status;

public class UserActivatedEvent extends BaseEvent<String> {

    public final Status status;

    public UserActivatedEvent(String id, Status status) {
        super(id);
        this.status = status;
    }
}
