package org.example.chain;

import org.example.factory.Transport;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import static org.example.constant.PatternsConst.*;

public class RowFieldPrinter implements FieldPrinter {

    private FieldPrinter nextPrinter;

    @Override
    public void setNextPrinter(FieldPrinter printer) {
        this.nextPrinter = printer;
    }

    @Override
    public void print(Transport transport, String fileName) throws IOException {
        if (transport.getSize() > COUNT_MODEL) {
            nextPrinter.print(transport, fileName);
        }

        try (PrintWriter out = new PrintWriter(new FileWriter(fileName))) {
            out.print(transport.getBrand() + SPACE);
            out.print(transport.getSize() + SPACE);

            String[] modelNames = transport.getAllModelNames();
            int[] modelPrices = transport.getAllModelPrices();
            for (int i = 0; i < transport.getSize(); i++) {
                out.print(modelNames[i] + SPACE);
                out.print(modelPrices[i] + SPACE);
            }
        }
    }
}
