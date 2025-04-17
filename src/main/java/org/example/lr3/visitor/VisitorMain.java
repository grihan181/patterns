package org.example.lr3.visitor;

import org.example.exception.DuplicateModelNameException;
import org.example.lr1.factory.Transport;
import org.example.lr1.factory.service.impl.Car;
import org.example.lr1.factory.service.impl.Motorcycle;

import static org.example.lr1.factory.util.TransportUtility.initModel;

public class VisitorMain {
    public static void main(String[] args) throws DuplicateModelNameException {
        Transport car = new Car("Lada", 3);
        initModel(car);
        Transport motorcycle = new Motorcycle("Yamaha", 3);
        initModel(motorcycle);

        Visitor printVisitor = new PrintVisitor();
        car.accept(printVisitor);
        motorcycle.accept(printVisitor);
    }
}
