package com.MicroserviceEventSourceCQRSDemo.MicroserviceDemo.entities.repositories;

import com.MicroserviceEventSourceCQRSDemo.MicroserviceDemo.entities.UserQueryEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserQueryEntity, String> {
}
