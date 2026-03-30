package com.vendingmachine;

import com.vendingmachine.model.Snack;
import com.vendingmachine.repository.ProductRepository;
import com.vendingmachine.service.*;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VendingMachineImplTest {

    private VendingMachineImpl machine;

    @BeforeEach
    void setup() {
        var repo = new ProductRepository(
                List.of(new Snack(1, "Chips", 20, 3))
        );
        var moneyService = new MoneyService();

        machine = new VendingMachineImpl(repo, moneyService);
    }

    @Test
    void insertValidCoin() {
        machine.insertCoin(10);
        assertEquals(10, machine.getBalance());
    }

    @Test
    void rejectInvalidCoin() {
        assertThrows(IllegalArgumentException.class,
                () -> machine.insertCoin(7));
    }

    @Test
    void purchaseSuccess() {
        machine.insertCoin(20);
        var product = machine.purchaseProduct(1);

        assertNotNull(product);
        assertEquals(0, machine.getBalance());
        assertEquals(2, machine.getProducts().get(0).getQuantity());
    }

    @Test
    void insufficientBalance() {
        machine.insertCoin(10);

        assertThrows(IllegalStateException.class,
                () -> machine.purchaseProduct(1));
    }

    @Test
    void outOfStock() {
        machine.getProducts().get(0).setQuantity(0);
        machine.insertCoin(20);

        assertThrows(IllegalStateException.class,
                () -> machine.purchaseProduct(1));
    }

    @Test
    void returnChange() {
        machine.insertCoin(50);
        int change = machine.returnChange();

        assertEquals(50, change);
        assertEquals(0, machine.getBalance());
    }
}