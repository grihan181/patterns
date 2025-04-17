package org.example.lr3.memento;

import org.example.lr1.factory.service.impl.Car;

import java.util.Arrays;

import static org.example.lr1.factory.util.TransportUtility.initModel;

public class Memento {
    public static void main(String[] args) throws Exception {
        Car car = new Car("Lada", 2);
        initModel(car);

        System.out.println("Original: " + car.getBrand() + ", Model: " + Arrays.toString(car.getAllModelNames()));

        Car.Memento savedState = car.createMemento();

        car.setBrand("New brand");
        car.setModelNameByOldName("Car 1", "New model");
        System.out.println("Changed: " + car.getBrand() + ", Model: " + Arrays.toString(car.getAllModelNames()));

        car.setMemento(savedState);
        System.out.println("Loaded: " + car.getBrand() + ", Model: " + Arrays.toString(car.getAllModelNames()));
    }
}