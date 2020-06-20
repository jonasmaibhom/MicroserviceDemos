package com.MicroserviceEventSourceCQRSDemo.MicroserviceDemo.entities.repositories;

import com.MicroserviceEventSourceCQRSDemo.MicroserviceDemo.entities.AccountQueryEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends MongoRepository<AccountQueryEntity, String> {
}
