package org.example.lr3.command;

import org.example.lr1.factory.Transport;

import java.io.IOException;
import java.io.PrintWriter;

import static org.example.constant.PatternsConst.PRINT_ROW_PATTERN;

public class RowFieldPrinter implements FieldPrinter {

    @Override
    public void print(Transport transport, PrintWriter out) throws IOException {
        out.print(transport.getBrand() + ", size: " + transport.getSize() + " | ");

        String[] modelNames = transport.getAllModelNames();
        int[] modelPrices = transport.getAllModelPrices();

        for (int i = 0; i < transport.getSize(); i++) {
            out.print(String.format(PRINT_ROW_PATTERN, modelNames[i], modelPrices[i]));
        }
        out.flush();
    }
}
