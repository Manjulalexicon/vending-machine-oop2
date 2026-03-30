package com.vendingmachine.repository;


import com.vendingmachine.model.Product;

import java.util.*;

public class ProductRepository {

    private final Map<Integer, Product> productMap = new HashMap<>();

    public ProductRepository(List<Product> products) {
        for (Product p : products) {
            productMap.put(p.getId(), p);
        }
    }

    public Optional<Product> findById(int id) {
        return Optional.ofNullable(productMap.get(id));
    }

    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }
}
