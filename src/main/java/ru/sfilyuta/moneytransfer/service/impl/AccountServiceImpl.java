package ru.sfilyuta.moneytransfer.service.impl;

import ru.sfilyuta.moneytransfer.model.Account;
import ru.sfilyuta.moneytransfer.service.AccountService;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AccountServiceImpl implements AccountService {

    private Map<Integer, Account> accountMap = new ConcurrentHashMap<>();

    public boolean create(Account account) {
        if (accountMap.containsKey(account.getNumber())) {
            return false;
        }
        accountMap.put(account.getNumber(), account);
        return true;
    }

    public Account get(Integer accountNumber) {
        return accountMap.get(accountNumber);
    }
}
