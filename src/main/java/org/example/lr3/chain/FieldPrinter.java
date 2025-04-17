package org.example.lr3.chain;

import org.example.lr1.factory.Transport;

import java.io.IOException;

public interface FieldPrinter {

    void setNextPrinter(FieldPrinter printer);
    void print(Transport transport, String fileName) throws IOException;
}
