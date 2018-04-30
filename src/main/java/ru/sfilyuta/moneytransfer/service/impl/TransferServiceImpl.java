package ru.sfilyuta.moneytransfer.service.impl;

import ru.sfilyuta.moneytransfer.model.Account;
import ru.sfilyuta.moneytransfer.service.TransferService;

public class TransferServiceImpl implements TransferService {

    @Override
    public boolean transfer(Account src, Account dst, int amount) {
        boolean withdraw = src.withdraw(amount);
        if (!withdraw) return false;
        dst.deposit(amount);
        return true;
    }
}
