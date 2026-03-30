package com.vendingmachine.service;

import com.vendingmachine.model.Coin;

public class MoneyService {

    private int balance = 0;

    public void insertCoin(int coinValue) {
        if (!Coin.isValid(coinValue)) {
            throw new IllegalArgumentException("Invalid coin: " + coinValue);
        }
        balance += coinValue;
    }

    public int getBalance() {
        return balance;
    }

    public void deduct(int amount) {
        if (amount > balance) {
            throw new IllegalStateException("Insufficient balance");
        }
        balance -= amount;
    }

    public int returnChange() {
        int change = balance;
        balance = 0;
        return change;
    }
}
