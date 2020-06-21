package com.MicroserviceEventSourceCQRSDemo.MicroserviceDemo.commands;

public class CreateUserCommand extends BaseCommand<String> {


    public final String address;

    public final String name;

    public CreateUserCommand(String id, String address, String name) {
        super(id);
        this.address = address;
        this.name = name;
    }
}
