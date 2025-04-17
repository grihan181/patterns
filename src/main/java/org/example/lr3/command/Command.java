package org.example.lr3.command;

import org.example.exception.DuplicateModelNameException;
import org.example.lr1.factory.service.impl.Car;

import java.io.IOException;
import java.io.PrintWriter;

import static org.example.lr1.factory.util.TransportUtility.initModel;

public class Command {
    public static void main(String[] args) throws DuplicateModelNameException, IOException {
        FieldPrinter rowPrinter = new RowFieldPrinter();
        FieldPrinter columnPrinter = new ColumnFieldPrinter();

        Car car = new Car("Lada", 2);
        initModel(car);

        PrintWriter out = new PrintWriter("row_command");

        car.setPrintCommand(rowPrinter);
        car.print(out);

        out = new PrintWriter("col_command");
        car.setPrintCommand(columnPrinter);
        car.print(out);
    }
}
