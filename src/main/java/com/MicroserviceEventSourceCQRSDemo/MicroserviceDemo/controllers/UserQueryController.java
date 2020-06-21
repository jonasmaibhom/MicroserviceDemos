package com.MicroserviceEventSourceCQRSDemo.MicroserviceDemo.controllers;


import com.MicroserviceEventSourceCQRSDemo.MicroserviceDemo.entities.UserQueryEntity;
import com.MicroserviceEventSourceCQRSDemo.MicroserviceDemo.services.queries.UserQueryService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
@Api(value = "User Queries", description = "User Query Events Endpoint", tags = "User Queries")
public class UserQueryController {

    private final UserQueryService userQueryService;

    public UserQueryController(UserQueryService userQueryService) {
        this.userQueryService = userQueryService;
    }

    @GetMapping("/{userNumber}")
    public UserQueryEntity getUser(@PathVariable(value = "userNumber") String userNumber){
        return userQueryService.getUser(userNumber);
    }

    @GetMapping("/{userNumber}/events")
    public List<Object> listEventsForUser(@PathVariable(value = "userNumber") String userNumber){
        return userQueryService.listEventsForUser(userNumber);
    }
}
