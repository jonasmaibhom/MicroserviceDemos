package com.MicroserviceEventSourceCQRSDemo.MicroserviceDemo.services.queries;

import com.MicroserviceEventSourceCQRSDemo.MicroserviceDemo.entities.UserQueryEntity;

import java.util.List;

public interface UserQueryService {
    public List<Object> listEventsForUser(String userNumber);
    public UserQueryEntity getUser(String userNumber);
}
