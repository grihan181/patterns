package org.example.factory;

import org.example.factory.exception.DuplicateModelNameException;

public interface TransportFactory {
    Transport createInstance(String name, int size) throws DuplicateModelNameException;
}