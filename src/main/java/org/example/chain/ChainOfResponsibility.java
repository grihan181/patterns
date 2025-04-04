package org.example.chain;

import org.example.exception.DuplicateModelNameException;
import org.example.factory.service.impl.Car;

import java.io.IOException;

import static org.example.factory.util.TransportUtility.initModel;

public class ChainOfResponsibility {
    public static void main(String[] args) throws DuplicateModelNameException, IOException {
        FieldPrinter rowPrinter = new RowFieldPrinter();
        FieldPrinter columnPrinter = new ColumnFieldPrinter();
        rowPrinter.setNextPrinter(columnPrinter);

        Car carROw = new Car("Lada", 2);
        initModel(carROw);
        Car carColumn = new Car("Haval", 6);
        initModel(carColumn);

        rowPrinter.print(carROw, "row");
        rowPrinter.print(carColumn, "column");
    }
}
