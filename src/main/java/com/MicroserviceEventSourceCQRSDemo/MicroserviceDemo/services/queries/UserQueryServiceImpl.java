package com.MicroserviceEventSourceCQRSDemo.MicroserviceDemo.services.queries;

import com.MicroserviceEventSourceCQRSDemo.MicroserviceDemo.entities.UserQueryEntity;
import com.MicroserviceEventSourceCQRSDemo.MicroserviceDemo.entities.repositories.UserRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserQueryServiceImpl implements UserQueryService {

    private final EventStore eventStore;

    private final UserRepository userRepository;

    public UserQueryServiceImpl(EventStore eventStore, UserRepository userRepository) {
        this.eventStore = eventStore;
        this.userRepository = userRepository;
    }

    @Override
    public List<Object> listEventsForUser(String userNumber) {
        return eventStore.readEvents(userNumber).asStream().map(s -> s.getPayload()).collect(Collectors.toList());
    }

    @Override
    public UserQueryEntity getUser(String userNumber) {
        return userRepository.findById(userNumber).get();
    }
}
