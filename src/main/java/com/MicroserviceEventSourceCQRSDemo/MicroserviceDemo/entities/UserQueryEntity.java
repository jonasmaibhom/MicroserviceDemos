package com.MicroserviceEventSourceCQRSDemo.MicroserviceDemo.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document
public class UserQueryEntity {

    @Id
    private String id;

    private String address;

    private String name;

    private String status;

    public UserQueryEntity() {
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

    @Override
    public String toString() {
        return "UserQueryEntity{" +
                "id='" + id + '\'' +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
