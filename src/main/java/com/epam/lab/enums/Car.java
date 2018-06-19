package com.epam.lab.enums;

public enum Car {

    VOLVO(1), MERCEDES(2), AUDI(3);

    private int value;

    Car(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
