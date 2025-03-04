package org.example.factory.exception;

public class ModelPriceOutOfBoundsException extends RuntimeException {
    public ModelPriceOutOfBoundsException(double price) {
        super("Цена '" + price + "' неверная!");
    }
}