package org.example.lr3.visitor;

import org.example.lr1.factory.service.impl.Car;
import org.example.lr1.factory.service.impl.Motorcycle;

import static org.example.constant.PatternsConst.PRINT_ROW_PATTERN;

public class PrintVisitor implements Visitor {

    @Override
    public void visit(Car car) {
        System.out.print("Car: " + car.getBrand() + " | ");
        String[] modelNames = car.getAllModelNames();
        int[] modelPrices = car.getAllModelPrices();
        for (int i = 0; i < modelNames.length; i++) {
            System.out.printf(PRINT_ROW_PATTERN, modelNames[i], modelPrices[i]);
        }
        System.out.println();
    }

    @Override
    public void visit(Motorcycle motorcycle) {
        System.out.println("Motorcycle: " + motorcycle.getBrand());
        String[] modelNames = motorcycle.getAllModelNames();
        int[] modelPrices = motorcycle.getAllModelPrices();
        for (int i = 0; i < modelNames.length; i++) {
            System.out.printf((PRINT_ROW_PATTERN) + "%n", modelNames[i], modelPrices[i]);
        }
    }
}
