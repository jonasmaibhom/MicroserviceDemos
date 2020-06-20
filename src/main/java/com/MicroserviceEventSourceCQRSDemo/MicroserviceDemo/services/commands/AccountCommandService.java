package com.MicroserviceEventSourceCQRSDemo.MicroserviceDemo.services.commands;

import com.MicroserviceEventSourceCQRSDemo.MicroserviceDemo.dto.commands.AccountCreateDTO;
import com.MicroserviceEventSourceCQRSDemo.MicroserviceDemo.dto.commands.MoneyCreditDTO;
import com.MicroserviceEventSourceCQRSDemo.MicroserviceDemo.dto.commands.MoneyDebitDTO;

import java.util.concurrent.CompletableFuture;

public interface AccountCommandService {

    public CompletableFuture<String> createAccount(AccountCreateDTO accountCreateDTO);
    public CompletableFuture<String> creditMoneyToAccount(String accountNumber, MoneyCreditDTO moneyCreditDTO);
    public CompletableFuture<String> debitMoneyFromAccount(String accountNumber, MoneyDebitDTO moneyDebitDTO);
}

