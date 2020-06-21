package com.MicroserviceEventSourceCQRSDemo.MicroserviceDemo.config;

import com.MicroserviceEventSourceCQRSDemo.MicroserviceDemo.aggregates.UserAggregate;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AxonConfig {

    @Bean
    EventSourcingRepository<UserAggregate> userAggregateEventSourcingRepository(EventStore eventStore){
        EventSourcingRepository<UserAggregate> repository = EventSourcingRepository.builder(UserAggregate.class).eventStore(eventStore).build();
        return repository;
    }
}
