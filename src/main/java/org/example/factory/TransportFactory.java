package org.example.factory;

import org.example.factory.exception.DuplicateModelNameException;

public interface TransportFactory {
    public Transport createInstance(String name, int size);
}