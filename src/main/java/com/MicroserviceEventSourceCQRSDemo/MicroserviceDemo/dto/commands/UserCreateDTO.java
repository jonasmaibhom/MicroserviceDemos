package com.MicroserviceEventSourceCQRSDemo.MicroserviceDemo.dto.commands;

public class UserCreateDTO {

    private String address;

    private String name;

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
}
