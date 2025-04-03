package org.example.decorator;


import org.example.factory.Transport;
import org.example.exception.DuplicateModelNameException;
import org.example.factory.service.impl.Car;
import org.example.factory.util.TransportUtility;

import static org.example.constant.PatternsConst.INIT_MODEL_COUNT;

public class Decorator {

    public static void main(String[] args) throws Exception {
        Car car = new Car("Brand", INIT_MODEL_COUNT);

        for (int i = 0; i < INIT_MODEL_COUNT; i++) {
            try {
                car.addModel("Car " + (i + 1), (i + 1) * 10);
            } catch (DuplicateModelNameException e) {
                System.out.println((e.getMessage()));
            }
        }

        Transport syncTransport = TransportUtility.synchronizedVehicle(car);
        System.out.println(("Sync brand: " + syncTransport.getBrand()));
    }
}
