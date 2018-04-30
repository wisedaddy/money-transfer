package ru.sfilyuta.moneytransfer.service;

import ru.sfilyuta.moneytransfer.model.Account;

public interface AccountService {
    boolean create(Account account);
    Account get(Integer accountNumber);
}
