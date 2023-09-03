package com.bank.examples;

import com.bank.examples.models.UserAccountProfile;

public class CreditCard extends BankCard {
    private String interestRate;

    public CreditCard(UserAccountProfile userAccountProfile) {
        super(userAccountProfile);
        this.interestRate = null;
    }
    public String getInterestRate(String userId){
        //implying DB call is done
        this.interestRate = "100";
        return interestRate;
    }

    public int requestDebt(String userId) {
        //Query DB for debt on userId
        int debt = 0;
        System.out.print("user debt = " + debt);
        return debt;
    }
}
