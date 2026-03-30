package com.vendingmachine.model;

public class Snack extends Product {
    public Snack(int id, String name, int price, int quantity) {
        super(id, name, price, quantity);
    }

    @Override
    public String getDescription() {
        return "Snack: " + getName();
    }
}
