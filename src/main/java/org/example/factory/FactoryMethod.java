package org.example.factory;

import org.example.factory.exception.DuplicateModelNameException;
import org.example.factory.exception.NoSuchModelNameException;
import org.example.factory.service.impl.Car;
import org.example.factory.service.impl.CarFactory;
import org.example.factory.service.impl.Motorcycle;
import org.example.factory.service.impl.MotorcycleFactory;
import org.example.factory.util.TransportUtility;

public class FactoryMethod {
    public static void main(String[] args) throws Exception {
        int initialModelsCount = 3;
        testCar(initialModelsCount);
        testMotorcycle(initialModelsCount);
        testFactory(initialModelsCount);
    }

    private static void testFactory(int initialModelsCount) throws DuplicateModelNameException {
        System.out.println("Factory: ");
        CarFactory carFactory = CarFactory.getInstance();
        Car newCar = carFactory.createInstance("Car", initialModelsCount);
        System.out.printf("%s size = %s\n", newCar.getBrand(), newCar.getSize());

        MotorcycleFactory motorcycleFactory = MotorcycleFactory.getInstance();
        Motorcycle newMotorcycle = motorcycleFactory.createInstance("Motorcycle", initialModelsCount);
        System.out.printf("%s size = %s\n", newMotorcycle.getBrand(), newMotorcycle.getSize());
        TransportUtility.printAllModels(newMotorcycle);

        System.out.println("TransportUtility: ");
        TransportUtility.setTransportFactory(carFactory);
        Transport newTransport = TransportUtility.createInstance("Car", initialModelsCount);
        System.out.printf("%s size = %s\n", newTransport.getBrand(), newTransport.getSize());

        TransportUtility.setTransportFactory(motorcycleFactory);
        Transport newTransport2 = TransportUtility.createInstance("Motorcycle", initialModelsCount);
        System.out.printf("%s size = %s\n", newTransport2.getBrand(), newTransport2.getSize());
        TransportUtility.printAllModels(newTransport2);
    }

    private static void testMotorcycle(int initialModelsCount) throws DuplicateModelNameException, NoSuchModelNameException, CloneNotSupportedException {
        Motorcycle motorcycle = new Motorcycle("Yamaha", initialModelsCount);

        for (int i = 0; i < initialModelsCount + 1; i++) {
            motorcycle.addModel("Motorcycle " + (i + 1), (i + 1) * 10);
        }

        System.out.println("Brand: " + motorcycle.getBrand());
        TransportUtility.printAllModels(motorcycle);

        motorcycle.deleteModel("Motorcycle 2");
        System.out.println("Delete 'Motorcycle 2'");
        TransportUtility.printAllModels(motorcycle);

        motorcycle.addModel("Motorcycle 2", 20);
        System.out.println("Add 'Motorcycle 2'");
        TransportUtility.printAllModels(motorcycle);

        motorcycle.setModelNameByOldName("Motorcycle 2", "Motorcycle 5");
        System.out.println("'Motorcycle 2' -> 'Motorcycle 5'");
        TransportUtility.printAllModels(motorcycle);

        System.out.println("Clone");
        Motorcycle cloneMotorcycle = motorcycle.clone();
        System.out.println("CLone model: ");
        TransportUtility.printAllModels(cloneMotorcycle);
        cloneMotorcycle.setModelNameByOldName("Motorcycle 5", "Motorcycle Motorcycle");
        System.out.println("Original model: ");
        TransportUtility.printAllModels(motorcycle);
    }

    private static void testCar(int initialModelsCount) throws DuplicateModelNameException, NoSuchModelNameException, CloneNotSupportedException {
        Car car = new Car("Lada", initialModelsCount);
        for (int i = 0; i < initialModelsCount + 1; i++) {
            car.addModel("Car " + (i + 1), (i + 1) * 10);
        }

        System.out.println("Brand:  " + car.getBrand());
        TransportUtility.printAllModels(car);

        System.out.println("Avg price: " + TransportUtility.averagePrice(car));

        car.deleteModel("Car 2");
        System.out.println("Delete 'Car 2'");
        TransportUtility.printAllModels(car);

        car.addModel("Car 2", 20);

        System.out.println("Add 'Car 2'");
        TransportUtility.printAllModels(car);

        car.setModelNameByOldName("Car 2", "Car 5");

        System.out.println("'Car 2' -> 'Car 5'");
        TransportUtility.printAllModels(car);

        System.out.println("Clone");
        Car cloneCar = car.clone();
        System.out.println("CLone model: ");
        TransportUtility.printAllModels(cloneCar);
        cloneCar.setModelNameByOldName("Car 5", "Car Car");
        System.out.println("Original model: ");
        TransportUtility.printAllModels(car);
    }

}