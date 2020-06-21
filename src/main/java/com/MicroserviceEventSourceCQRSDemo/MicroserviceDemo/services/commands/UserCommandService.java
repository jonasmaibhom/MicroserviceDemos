package com.MicroserviceEventSourceCQRSDemo.MicroserviceDemo.services.commands;

import com.MicroserviceEventSourceCQRSDemo.MicroserviceDemo.dto.commands.UserCreateDTO;

import java.util.concurrent.CompletableFuture;

public interface UserCommandService {

    public CompletableFuture<String> createUser(UserCreateDTO userCreateDTO);
}

