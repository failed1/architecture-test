package com.bank.examples;

import com.bank.examples.models.UserAccountProfile;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankServicesTests {

    @Test
    public void testCreditCard() {
        String userId = "John Doe";
        UserAccountProfile userAccountProfile = new UserAccountProfile(userId);
        CreditCard creditCard = new CreditCard(userAccountProfile);
        assertEquals("100", creditCard.getInterestRate(userId));
        assertEquals("Wallet", creditCard.getName());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        int debt = creditCard.requestDebt(userId);
        assertEquals("user debt = " + debt, outContent.toString());
    }
    @Test
    public void testCardOperations() {
        String userId = "John Doe";
        UserAccountProfile userAccountProfile = new UserAccountProfile(userId);
        BankCard debitCard = new BankCard(userAccountProfile);
        assertEquals(250, debitCard.getBalance(userId));
        debitCard.withdrawBalance(userId,100);
        debitCard.increaseBalance(150, userId);
        assertEquals(300, debitCard.getBalance(userId));
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testDebitCard() {
        String userOne = "James Dobs";
        String userTwo = "John Doe";
        UserAccountProfile userOneAccountProfile = new UserAccountProfile(userTwo, "USD");
        BankCard foreignCard = new BankCard(userOneAccountProfile);
        UserAccountProfile userTwoAccountProfile = new UserAccountProfile(userOne);
        BankCard debitCard = new BankCard(userTwoAccountProfile);
        assertEquals("USD", foreignCard.getCurrency());
        assertEquals("RUB", debitCard.getCurrency());
    }

    @Test
    public void testDeposit() {
        String userId = "John Doe";
        UserAccountProfile userAccountProfile = new UserAccountProfile(userId);
        Deposit deposit = new Deposit(userAccountProfile);
        deposit.increaseBalance(100, userId);
        assertEquals(350, deposit.getBalance(userId));
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        deposit.closeDeposit(userId);
        assertEquals("Deposit closed for user", outContent.toString());
        outContent.reset();
        deposit.increaseBalance(100, userId);
        assertEquals("deposit is closed", outContent.toString());
        assertEquals(350, deposit.getBalance(userId));
    }
}
