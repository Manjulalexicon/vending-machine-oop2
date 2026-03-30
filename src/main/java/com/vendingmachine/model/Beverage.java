package com.vendingmachine.model;

public class Beverage extends Product {

    public Beverage(int id, String name, int price, int quantity) {
        super(id, name, price, quantity);
    }

    @Override
    public String getDescription() {
        return "Beverage: " + getName();
    }
}
