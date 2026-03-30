package com.vendingmachine.model;


public abstract class Product {
    private int id;
    private String name;
    private int price;
    private int quantity;

    public Product(int id, String name, int price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public abstract String getDescription();

    public int getId() { return id; }
    public String getName() { return name; }
    public int getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public void reduceQuantity() {
        if (quantity > 0) quantity--;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
