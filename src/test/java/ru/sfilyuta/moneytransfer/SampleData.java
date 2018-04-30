package ru.sfilyuta.moneytransfer;

import ru.sfilyuta.moneytransfer.model.Account;

public class SampleData {
    public static Account sampleAccount() {
        return new Account(1, 500);
    }

    public static Account sampleAccount2() {
        return new Account(2, 3000);
    }
}
