package com.bank.examples;

public class BankProduct {
    private String name;
    private int balance;
    private String currency;

    public BankProduct() {
        currency = "";
        name = "";
        balance = 0;
    }

    public BankProduct(String name, int balance, String currency) {
        this.currency = currency;
        this.balance = balance;
        this.name = name;
    }
    public String getCurrency() {
        return currency;
    }

    public String getName() {
        return name;
    }

    public void setBalance(int balance) {
        this.balance = balance;
        //write to DB
    }

    public void increaseBalance(int balance, String userId) {
        this.balance = getBalance(userId) + balance;
        //write to DB
    }

    public int getBalance(String userId) {
        return balance;
    }
}
