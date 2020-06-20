package com.MicroserviceEventSourceCQRSDemo.MicroserviceDemo.events;

import com.MicroserviceEventSourceCQRSDemo.MicroserviceDemo.aggregates.Status;

public class AccountHeldEvent extends BaseEvent<String> {

    public final Status status;

    public AccountHeldEvent(String id, Status status) {
        super(id);
        this.status = status;
    }
}
