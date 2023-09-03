package com.bank.examples;

import com.bank.examples.models.UserAccountProfile;

public class BankCard extends BankProduct {

    public BankCard(UserAccountProfile userAccountProfile) {
        super(userAccountProfile.getProductName(),
                userAccountProfile.getBalance(),
                userAccountProfile.getCurrency());
    }

    public void withdrawBalance(String userId, int amount) {
        int balance = super.getBalance(userId);
        if (amount <= balance) {
            super.setBalance(balance - amount);
        } else {
            System.out.println("Not enough money on your balance");
        }
    }
}
