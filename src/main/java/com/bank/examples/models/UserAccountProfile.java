package com.bank.examples.models;

public class UserAccountProfile {

   private String currency;
   private String productName;
   private int balance;

    public String getCurrency() {
        return currency;
    }

    public String getProductName() {
        return productName;
    }

    public int getBalance() {
        return balance;
    }

    public UserAccountProfile(String userId) {
        //implying DB request is called for user to select bank product
        //DB.request(userId).parse.get.data...>>> set up in this method instead of below code
        this.currency="RUB"; //map from DB
        this.productName = "Wallet";
        this.balance = 250;
    }

    public UserAccountProfile(String userId, String currency) {
        //check DB for card product if selected currency exists for userId, otherwise throw error
        switch (currency) {
            case "RUB":
                this.currency="RUB";
                break;
            case "EUR":
                this.currency="EUR";
                break;
            case "USD":
                this.currency="USD";
                break;
            default: throw new IllegalArgumentException("There is no supported currency like this in bank");
        }
        //DB.request(userId).parse.get.data...>>> map in this method instead of below code
        this.productName = "Wallet";
        this.balance = 250;
    }
}
