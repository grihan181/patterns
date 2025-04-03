package org.example.dao;

import org.example.factory.Transport;
import org.example.factory.exception.DuplicateModelNameException;

import java.io.IOException;

public interface TransportDAO {
    Transport load(String filename) throws IOException, DuplicateModelNameException, ClassNotFoundException;
    void save(Transport vehicle, String filename) throws IOException;
}