package ru.sfilyuta.moneytransfer.service;

import ru.sfilyuta.moneytransfer.model.Account;

public interface TransferService {
    boolean transfer(Account src, Account dst, int amount);
}
