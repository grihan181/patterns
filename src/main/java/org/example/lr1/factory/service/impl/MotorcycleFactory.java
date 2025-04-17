package org.example.lr1.factory.service.impl;

import lombok.Getter;
import org.example.lr1.factory.TransportFactory;
import org.example.exception.DuplicateModelNameException;

public class MotorcycleFactory implements TransportFactory {

    @Getter
    private static final MotorcycleFactory instance = new MotorcycleFactory();

    public Motorcycle createInstance(String name, int size) throws DuplicateModelNameException {
        return new Motorcycle(name, size);
    }

}

