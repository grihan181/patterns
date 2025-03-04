package org.example.factory;

public interface TransportFactory {
    Transport createInstance(String name, int size);
}