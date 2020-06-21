package com.MicroserviceEventSourceCQRSDemo.MicroserviceDemo.entities.handlers;

import com.MicroserviceEventSourceCQRSDemo.MicroserviceDemo.aggregates.UserAggregate;
import com.MicroserviceEventSourceCQRSDemo.MicroserviceDemo.entities.UserQueryEntity;
import com.MicroserviceEventSourceCQRSDemo.MicroserviceDemo.entities.repositories.UserRepository;
import com.MicroserviceEventSourceCQRSDemo.MicroserviceDemo.events.BaseEvent;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class UserQueryEntityManager {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    @Qualifier("userAggregateEventSourcingRepository")
    private EventSourcingRepository<UserAggregate> userAggregateEventSourcingRepository;

    @EventSourcingHandler
    void on(BaseEvent event){
        persistUser(buildQueryUser(getUserFromEvent(event)));
    }


    private UserAggregate getUserFromEvent(BaseEvent event){
        return userAggregateEventSourcingRepository.load(event.id.toString()).getWrappedAggregate().getAggregateRoot();
    }

    private UserQueryEntity findExistingOrCreateQueryUser(String id){
        return userRepository.findById(id).isPresent() ? userRepository.findById(id).get() : new UserQueryEntity();
    }

    private UserQueryEntity buildQueryUser(UserAggregate userAggregate){
        UserQueryEntity userQueryEntity = findExistingOrCreateQueryUser(userAggregate.getId());

        userQueryEntity.setId(userAggregate.getId());
        userQueryEntity.setAddress(userAggregate.getAddress());
        userQueryEntity.setName(userAggregate.getName());
        userQueryEntity.setStatus(userAggregate.getStatus());

        return userQueryEntity;
    }

    private void persistUser(UserQueryEntity userQueryEntity){
        userRepository.save(userQueryEntity);
    }
}
