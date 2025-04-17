package org.example.lr1.factory;

import org.example.exception.DuplicateModelNameException;
import org.example.exception.NoSuchModelNameException;
import org.example.lr1.factory.service.impl.Car;
import org.example.lr1.factory.service.impl.CarFactory;
import org.example.lr1.factory.service.impl.Motorcycle;
import org.example.lr1.factory.service.impl.MotorcycleFactory;
import org.example.lr1.factory.util.TransportUtility;

import static org.example.constant.PatternsConst.INIT_MODEL_COUNT;

public class FactoryMethod {
    public static void main(String[] args) throws Exception {
        testCar();
        testMotorcycle();
        testFactory();
    }

    private static void testFactory() throws DuplicateModelNameException {
        System.out.println("Factory: ");
        CarFactory carFactory = CarFactory.getInstance();
        Car newCar = carFactory.createInstance("Car", INIT_MODEL_COUNT);
        System.out.printf("%s size = %s\n", newCar.getBrand(), newCar.getSize());

        MotorcycleFactory motorcycleFactory = MotorcycleFactory.getInstance();
        Motorcycle newMotorcycle = motorcycleFactory.createInstance("Motorcycle", INIT_MODEL_COUNT);
        System.out.printf("%s size = %s\n", newMotorcycle.getBrand(), newMotorcycle.getSize());
        TransportUtility.printAllModels(newMotorcycle);

        System.out.println("TransportUtility: ");
        TransportUtility.setTransportFactory(carFactory);
        Transport newTransport = TransportUtility.createInstance("Car", INIT_MODEL_COUNT);
        System.out.printf("%s size = %s\n", newTransport.getBrand(), newTransport.getSize());

        TransportUtility.setTransportFactory(motorcycleFactory);
        Transport newTransport2 = TransportUtility.createInstance("Motorcycle", INIT_MODEL_COUNT);
        System.out.printf("%s size = %s\n", newTransport2.getBrand(), newTransport2.getSize());
        TransportUtility.printAllModels(newTransport2);
    }

    private static void testMotorcycle() throws DuplicateModelNameException, NoSuchModelNameException, CloneNotSupportedException {
        Motorcycle motorcycle = new Motorcycle("Yamaha", INIT_MODEL_COUNT);

        for (int i = 0; i < INIT_MODEL_COUNT + 1; i++) {
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

    private static void testCar() throws DuplicateModelNameException, NoSuchModelNameException, CloneNotSupportedException {
        Car car = new Car("Lada", INIT_MODEL_COUNT);
        for (int i = 0; i < INIT_MODEL_COUNT + 1; i++) {
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