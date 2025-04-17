package org.example.lr3.chain;

import org.example.lr1.factory.Transport;

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
            return;
        }

        try (PrintWriter out = new PrintWriter(new FileWriter(fileName))) {
            out.print(transport.getBrand() + ", size: " + transport.getSize() + " | ");

            String[] modelNames = transport.getAllModelNames();
            int[] modelPrices = transport.getAllModelPrices();
            for (int i = 0; i < transport.getSize(); i++) {
                out.print(String.format(PRINT_ROW_PATTERN, modelNames[i], modelPrices[i]));
            }
        }
    }
}
