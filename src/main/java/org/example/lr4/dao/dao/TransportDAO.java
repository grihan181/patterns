package org.example.lr4.dao.dao;

import org.example.lr1.factory.Transport;

public interface TransportDAO {

    Transport load(String path);

    void save(Transport transport, String file);
}
