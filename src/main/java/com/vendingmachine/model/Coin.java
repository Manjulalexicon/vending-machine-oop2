package com.vendingmachine.model;

import java.util.Arrays;

public enum Coin {
    ONE(1), TWO(2), FIVE(5), TEN(10), TWENTY(20), FIFTY(50);

    private final int value;

    Coin(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static boolean isValid(int value) {
        return Arrays.stream(values())
                .anyMatch(c -> c.value == value);
    }

    public static Coin fromValue(int value) {
        return Arrays.stream(values())
                .filter(c -> c.value == value)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid coin"));
    }
}
