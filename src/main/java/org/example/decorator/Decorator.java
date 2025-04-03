package org.example.decorator;

import org.example.factory.Car;
import org.example.factory.Transport;
import org.example.factory.TransportUtility;
import org.example.factory.exception.DuplicateModelNameException;

public class Decorator {
    public static void main(String[] args) throws Exception {
        int initialModelsCount = 5;

        Car car = new Car("Test car brand", 4);
        for (int i = 0; i < initialModelsCount; i++) {
            try {
                car.addModel("Car " + (i + 1), (i + 1) * 10);
            } catch (DuplicateModelNameException e) {
                System.out.println((e.getMessage()));
            }
        }

        Transport syncCarVehicle = TransportUtility.synchronizedVehicle(car);
        System.out.println(("Synced vehicle " + syncCarVehicle.getBrand()));
    }
}
