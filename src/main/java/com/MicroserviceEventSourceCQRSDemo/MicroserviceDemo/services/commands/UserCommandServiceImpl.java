package com.MicroserviceEventSourceCQRSDemo.MicroserviceDemo.services.commands;

import com.MicroserviceEventSourceCQRSDemo.MicroserviceDemo.commands.CreateUserCommand;
import com.MicroserviceEventSourceCQRSDemo.MicroserviceDemo.dto.commands.UserCreateDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class UserCommandServiceImpl implements UserCommandService {

    private final CommandGateway commandGateway;

    public UserCommandServiceImpl(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @Override
    public CompletableFuture<String> createUser(UserCreateDTO userCreateDTO) {
        return commandGateway.send(new CreateUserCommand(UUID.randomUUID().toString(), userCreateDTO.getAddress(), userCreateDTO.getName()));
    }
}
