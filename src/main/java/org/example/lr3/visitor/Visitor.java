package org.example.lr3.visitor;

import org.example.lr1.factory.service.impl.Car;
import org.example.lr1.factory.service.impl.Motorcycle;

public interface Visitor {

    void visit(Car car);
    void visit(Motorcycle motorcycle);
}
