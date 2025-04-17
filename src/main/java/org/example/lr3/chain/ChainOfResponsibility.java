package org.example.lr3.chain;

import org.example.exception.DuplicateModelNameException;
import org.example.lr1.factory.service.impl.Car;

import java.io.IOException;

import static org.example.lr1.factory.util.TransportUtility.initModel;

public class ChainOfResponsibility {
    public static void main(String[] args) throws DuplicateModelNameException, IOException {
        FieldPrinter rowPrinter = new RowFieldPrinter();
        FieldPrinter columnPrinter = new ColumnFieldPrinter();
        rowPrinter.setNextPrinter(columnPrinter);

        Car carRow = new Car("Lada", 2);
        initModel(carRow);
        Car carColumn = new Car("Haval", 6);
        initModel(carColumn);

        rowPrinter.print(carRow, "row_chain");
        rowPrinter.print(carColumn, "col_chain");
    }
}
