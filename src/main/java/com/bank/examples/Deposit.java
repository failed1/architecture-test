package com.bank.examples;

import com.bank.examples.models.UserAccountProfile;

public class Deposit extends BankProduct {
    private boolean isClosed;
    public Deposit(UserAccountProfile userAccountProfile) {
        super(userAccountProfile.getProductName(),
                userAccountProfile.getBalance(),
                userAccountProfile.getCurrency());
        this.isClosed = false;
    }
    public void closeDeposit(String userId) {
        //DB event
        this.isClosed = true;
        System.out.print("Deposit closed for user");
    }

    @Override
    public void increaseBalance(int balance, String userId){
        if (this.isClosed) {
            System.out.print("deposit is closed");
        }
        else {
            int newBalance = getBalance(userId) + balance;
            setBalance(newBalance);
        }
        //write to DB
    }
}
