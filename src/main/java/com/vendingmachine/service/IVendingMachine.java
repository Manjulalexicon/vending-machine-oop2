package com.vendingmachine.service;

import com.vendingmachine.model.Product;

import java.util.List;

public interface IVendingMachine {

    /**
     * Inserts a coin into the vending machine.
     * Only valid coin values are accepted.
     *
     * @param coinValue the value of the coin
     * @throws IllegalArgumentException if coin is invalid
     */
    void insertCoin(int coinValue);

    /**
     * Returns the current balance.
     *
     * @return current balance
     */
    int getBalance();

    /**
     * Attempts to purchase a product by ID.
     *
     * @param productId product identifier
     * @return purchased Product
     * @throws IllegalArgumentException if product not found
     * @throws IllegalStateException if insufficient balance or out of stock
     */
    Product purchaseProduct(int productId);

    /**
     * Returns remaining balance and resets it to zero.
     *
     * @return returned change
     */
    int returnChange();

    /**
     * Returns all available products.
     *
     * @return list of products
     */
    List<Product> getProducts();
}