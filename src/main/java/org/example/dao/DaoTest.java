package org.example.dao;

import org.example.factory.*;
import org.example.factory.exception.DuplicateModelNameException;

public class DaoTest {
    public static void main(String[] args)  throws Exception{
        int initialModelsCount = 5;

        Car car = new Car("Test car brand", 4);
        for (int i = 0; i < initialModelsCount; i++) {
            try {
                car.addModel("Car " + (i + 1), (i + 1) * 10);
            } catch (DuplicateModelNameException e) {
                e.printStackTrace();
            }
        }

        TransportUtility.printAllModels(car);
        FactoryMethod.delimeter();

        TextVehicleDAO textVehicleDAO = new TextVehicleDAO();
        textVehicleDAO.save(car, "text_car");
        SerializedVehicleDAO serializedVehicleDAO = new SerializedVehicleDAO();
        serializedVehicleDAO.save(car, "ser_car");

        Transport serializedLoadedCar = serializedVehicleDAO.load("ser_car");
        Transport textLoadedCar = textVehicleDAO.load("text_car");

        TransportUtility.printAllModels(textLoadedCar);
        FactoryMethod.delimeter();
        TransportUtility.printAllModels(serializedLoadedCar);
        FactoryMethod.delimeter();
        System.out.println(car + " / " + textLoadedCar + " / " + serializedLoadedCar);
        FactoryMethod.delimeter();

        Motorcycle motorcycle = new Motorcycle("Test motor brand", initialModelsCount);
        for (int i = 0; i < initialModelsCount; i++) {
            try {
                motorcycle.addModel("Motorcycle " + (i + 1), (i + 1) * 10);
            } catch (DuplicateModelNameException e) {
                e.printStackTrace();
            }
        }

        TransportUtility.printAllModels(motorcycle);
        FactoryMethod.delimeter();

        textVehicleDAO.save(motorcycle, "text_motorcycle");
        serializedVehicleDAO.save(motorcycle, "ser_motorcycle");

        Transport serializedLoadedMotorcycle = serializedVehicleDAO.load("ser_motorcycle");
        Transport textLoadedMotorcycle = textVehicleDAO.load("text_motorcycle");

        TransportUtility.printAllModels(textLoadedMotorcycle);
        FactoryMethod.delimeter();
        TransportUtility.printAllModels(serializedLoadedMotorcycle);
        FactoryMethod.delimeter();
        System.out.println(motorcycle + " / " + textLoadedMotorcycle + " / " + serializedLoadedMotorcycle);
    }
}