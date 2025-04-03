package org.example.dao;

import org.example.factory.Transport;

import java.io.*;

public class SerializedVehicleDAO implements TransportDAO {
    @Override
    public Transport load(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename))) {
            return (Transport) objectInputStream.readObject();
        }
    }

    @Override
    public void save(Transport vehicle, String filename) throws IOException {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            objectOutputStream.writeObject(vehicle);
        }
    }
}