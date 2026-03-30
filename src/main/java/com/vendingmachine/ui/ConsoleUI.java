package com.vendingmachine.ui;

import com.vendingmachine.service.IVendingMachine;

import java.util.Scanner;

public class ConsoleUI {

    private final IVendingMachine machine;
    private final Scanner scanner = new Scanner(System.in);

    public ConsoleUI(IVendingMachine machine) {
        this.machine = machine;
    }

    public void start() {
        while (true) {
            System.out.println("\n1. View Products");
            System.out.println("2. Insert Coin");
            System.out.println("3. Purchase Product");
            System.out.println("4. Return Change");
            System.out.println("5. Exit");

            try {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> machine.getProducts()
                            .forEach(p -> System.out.println(
                                    p.getId() + " - " + p.getDescription() +
                                            " | Price: " + p.getPrice() +
                                            " | Qty: " + p.getQuantity()));

                    case 2 -> {
                        System.out.print("Insert coin: ");
                        machine.insertCoin(scanner.nextInt());
                        System.out.println("Balance: " + machine.getBalance());
                    }

                    case 3 -> {
                        System.out.print("Product ID: ");
                        var product = machine.purchaseProduct(scanner.nextInt());
                        System.out.println("Purchased: " + product.getName());
                    }

                    case 4 -> System.out.println("Returned: " + machine.returnChange());

                    case 5 -> System.exit(0);
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
