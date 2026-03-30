package com.vendingmachine;

import com.vendingmachine.model.*;
import com.vendingmachine.repository.ProductRepository;
import com.vendingmachine.service.*;
import com.vendingmachine.ui.ConsoleUI;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        var products = List.of(
                new Snack(1, "Chips", 20, 5),
                new Beverage(2, "Cola", 15, 5),
                new Fruit(3, "Apple", 10, 5)
        );

        var repo = new ProductRepository(products);
        var moneyService = new MoneyService();

        IVendingMachine machine = new VendingMachineImpl(repo, moneyService);

        new ConsoleUI(machine).start();
    }
}