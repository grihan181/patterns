package org.example.factory.exception;

public class NoSuchModelNameException extends Exception {
    public NoSuchModelNameException(String name) {
        super("Модель с именем '" + name + "' не существует!");
    }
}
