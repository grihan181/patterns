package org.example.factory;

import org.example.factory.exception.DuplicateModelNameException;

public class MotorcycleFactory implements TransportFactory {
    private static final MotorcycleFactory instance = new MotorcycleFactory();

    public Motorcycle createInstance(String name, int size) throws DuplicateModelNameException {
        return new Motorcycle(name, size);
    }

    public static MotorcycleFactory getInstance() {
        return instance;
    }
}

