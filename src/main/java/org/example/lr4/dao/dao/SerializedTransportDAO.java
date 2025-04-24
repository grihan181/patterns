package org.example.lr4.dao.dao;

import org.example.lr1.factory.Transport;

import java.io.*;

public class SerializedTransportDAO implements TransportDAO {

    @Override
    public Transport load(String path) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            return (Transport) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.getCause();
            return null;
        }
    }

    @Override
    public void save(Transport transport, String file) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(transport);
        } catch (IOException e) {
            e.getCause();
        }
    }
}
