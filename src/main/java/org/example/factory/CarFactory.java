package org.example.factory;

import org.example.factory.exception.DuplicateModelNameException;

public class CarFactory  implements TransportFactory {
    private static CarFactory instance;

    public Car createInstance(String name, int size) throws DuplicateModelNameException {
        return new Car(name, size);
    }

    public static CarFactory getInstance() {
        if (instance == null) {
            instance = new CarFactory();
        }
        return instance;
    }
}
