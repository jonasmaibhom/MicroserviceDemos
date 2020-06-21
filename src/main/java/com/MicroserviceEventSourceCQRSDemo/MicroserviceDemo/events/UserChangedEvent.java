package com.MicroserviceEventSourceCQRSDemo.MicroserviceDemo.events;

public class UserChangedEvent extends BaseEvent<String> {

    public final String address;

    public final String name;

    public UserChangedEvent(String id, String address, String name) {
        super(id);
        this.address = address;
        this.name = name;
    }
}
