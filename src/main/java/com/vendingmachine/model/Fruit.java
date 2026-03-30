package com.vendingmachine.model;

public class Fruit extends Product {
    public Fruit(int id, String name, int price, int quantity) {
        super(id, name, price, quantity);
    }

    @Override
    public String getDescription() {
        return "Fruit: " + getName();
    }
}
