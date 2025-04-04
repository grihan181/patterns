package org.example.chain;

import org.example.factory.Transport;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import static org.example.constant.PatternsConst.*;

public class ColumnFieldPrinter implements FieldPrinter {

    private FieldPrinter nextPrinter;

    @Override
    public void setNextPrinter(FieldPrinter printer) {
        this.nextPrinter = printer;
    }

    @Override
    public void print(Transport transport, String fileName) throws IOException {
        if (transport.getSize() <= COUNT_MODEL) {
            this.nextPrinter.print(transport, fileName);
        }

        try (PrintWriter out = new PrintWriter(new FileWriter(fileName))) {
            out.println(transport.getBrand());
            out.println(transport.getSize());

            String[] modelNames = transport.getAllModelNames();
            int[] modelPrices = transport.getAllModelPrices();
            for (int i = 0; i < transport.getSize(); i++) {
                out.println(modelNames[i]);
                out.println(modelPrices[i]);
            }
        }
    }
}
