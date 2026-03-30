package com.vendingmachine.service;

import com.vendingmachine.model.Product;
import com.vendingmachine.repository.ProductRepository;

import java.util.List;

public class VendingMachineImpl implements IVendingMachine {

    private final ProductRepository repository;
    private final MoneyService moneyService;

    public VendingMachineImpl(ProductRepository repository, MoneyService moneyService) {
        this.repository = repository;
        this.moneyService = moneyService;
    }

    @Override
    public void insertCoin(int coin) {
        moneyService.insertCoin(coin);
    }

    @Override
    public int getBalance() {
        return moneyService.getBalance();
    }

    @Override
    public Product purchaseProduct(int productId) {
        Product product = repository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));

        if (product.getQuantity() <= 0) {
            throw new IllegalStateException("Out of stock");
        }

        moneyService.deduct(product.getPrice());
        product.reduceQuantity();

        return product;
    }

    @Override
    public int returnChange() {
        return moneyService.returnChange();
    }

    @Override
    public List<Product> getProducts() {
        return repository.findAll();
    }
}
