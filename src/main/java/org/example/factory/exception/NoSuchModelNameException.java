package org.example.factory.exception;

public class NoSuchModelNameException extends RuntimeException {
    public NoSuchModelNameException(String name) {
        super("Модель с именем '" + name + "' не существует!");
    }
}
