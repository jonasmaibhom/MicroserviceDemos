package com.MicroserviceEventSourceCQRSDemo.MicroserviceDemo.controllers;

import com.MicroserviceEventSourceCQRSDemo.MicroserviceDemo.dto.commands.UserCreateDTO;
import com.MicroserviceEventSourceCQRSDemo.MicroserviceDemo.services.commands.UserCommandService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/users")
@Api(value = "User Commands", description = "User Commands Related Endpoints", tags = "User Commands")
public class UserCommandController {

    private final UserCommandService userCommandService;

    public UserCommandController(UserCommandService userCommandService) {
        this.userCommandService = userCommandService;
    }

    @PostMapping
    public CompletableFuture<String> createUser(@RequestBody UserCreateDTO userCreateDTO){
        return userCommandService.createUser(userCreateDTO);
    }
}
