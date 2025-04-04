package org.example.chain;

import org.example.factory.Transport;

import java.io.IOException;

public interface FieldPrinter {

    void setNextPrinter(FieldPrinter printer);
    void print(Transport transport, String fileName) throws IOException;
}
