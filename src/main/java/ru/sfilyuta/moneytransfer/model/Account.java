package ru.sfilyuta.moneytransfer.model;

public class Account {

    private Integer number;
    private int amount;

    public Account() {
    }

    public Account(Integer number, int amount) {
        this.number = number;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void deposit(int diff) {
        amount -= diff;
    }

    public boolean withdraw(int diff) {
        if (amount >= diff) {
            amount -= diff;
            return true;
        }
        return false;
    }
}
