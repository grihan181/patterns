package org.example.lr3.command;

import org.example.lr1.factory.Transport;

import java.io.IOException;
import java.io.PrintWriter;

public interface FieldPrinter {

    void print(Transport transport, PrintWriter out) throws IOException;
}
