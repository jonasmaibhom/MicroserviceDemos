package com.MicroserviceEventSourceCQRSDemo.MicroserviceDemo.services.queries;

import com.MicroserviceEventSourceCQRSDemo.MicroserviceDemo.entities.AccountQueryEntity;

import java.util.List;

public interface AccountQueryService {
    public List<Object> listEventsForAccount(String accountNumber);
    public AccountQueryEntity getAccount(String accountNumber);
}
