package org.example.factory.exception;

public class DuplicateModelNameException extends Exception {
    public DuplicateModelNameException(String name) {
        super("Модель с именем " + name + " уже существует!");
    }
}