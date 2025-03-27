package org.example.factory;

public class FactoryMethod {
    public static void main(String[] args) throws Exception {
        int initialModelsCount = 5;

        Car car = new Car("Бренд Бибика", initialModelsCount);
        TransportUtility.printAllModels(car);
        delimeter();
        for (int i = 0; i < initialModelsCount + 1; i++) {
            car.addModel("Car " + (i + 1), (i + 1) * 10);
        }

        System.out.println("Модели " + car.getBrand());
        TransportUtility.printAllModels(car);
        delimeter();

        System.out.println("Средний прайс " + TransportUtility.averagePrice(car));
        delimeter();

        car.deleteModel("Car 2");

        System.out.println("Одна из машинок потерялась");
        TransportUtility.printAllModels(car);
        delimeter();

        car.addModel("Car 2", 10);

        System.out.println("Возвращаем потерянную машинку");
        TransportUtility.printAllModels(car);
        delimeter();

        car.setModelNameByOldName("Car 2", "Car 7");

        System.out.println("После переименования Бибики");
        TransportUtility.printAllModels(car);
        delimeter();

        System.out.println("Тесты клонирования");
        Car cloneCar = car.clone();
        System.out.println("Модели из клонированной Бибики");
        TransportUtility.printAllModels(cloneCar);
        cloneCar.setModelNameByOldName("Car 7", "ИЗМЕНЕН");
        System.out.println("Модели из оригинальной машины");
        TransportUtility.printAllModels(car);
        delimeter();

        Motorcycle motorcycle = new Motorcycle("Бренд Вжух Вжуха", initialModelsCount);
        TransportUtility.printAllModels(motorcycle);
        delimeter();

        for (int i = 0; i < initialModelsCount + 2; i++) {
            motorcycle.addModel("Motorcycle " + (i + 1), (i + 1) * 10);
        }

        System.out.println("Модели " + motorcycle.getBrand());
        TransportUtility.printAllModels(motorcycle);
        delimeter();

        motorcycle.deleteModel("Motorcycle 2");
        System.out.println("Один из мотиков потерялся");
        TransportUtility.printAllModels(motorcycle);
        delimeter();

        motorcycle.addModel("Motorcycle 2", 10);
        System.out.println("Потерявшийся мотик нашелся");
        TransportUtility.printAllModels(motorcycle);
        delimeter();

        motorcycle.setModelNameByOldName("Motorcycle 2", "Motorcycle 8");
        System.out.println("После переименования Вжух Вжуха");
        TransportUtility.printAllModels(motorcycle);
        delimeter();

        System.out.println("Тест клонирования");
        Motorcycle cloneMotorcycle = motorcycle.clone();
        System.out.println("Модели из клонированного Вжух Вжуха");
        TransportUtility.printAllModels(cloneMotorcycle);
        cloneMotorcycle.setModelNameByOldName("Motorcycle 8", "ИЗМЕНЕН");
        System.out.println("Модели из оригинальной мотоцикл");
        TransportUtility.printAllModels(motorcycle);
        delimeter();
        
        System.out.println("Оригинальный лист");
        TransportUtility.printAllModels(motorcycle);
        delimeter();

        System.out.println("Тесты фабрики");

        CarFactory carFactory = CarFactory.getInstance();
        Car newCar = carFactory.createInstance("Машинка из фабрики", initialModelsCount);
        System.out.printf("%s с размером %s и %s", newCar.getBrand(), newCar.getSize(), newCar.getClass());

        MotorcycleFactory motorcycleFactory = MotorcycleFactory.getInstance();
        Motorcycle newMotorcycle = motorcycleFactory.createInstance("Мотоцикл из фабрики", initialModelsCount);
        System.out.printf("%s с размером %s и и %s \n", newMotorcycle.getBrand(), newMotorcycle.getSize(), newMotorcycle.getClass());
        TransportUtility.printAllModels(newMotorcycle);

        delimeter();
        System.out.println("Пробуем TransportUtility");

        TransportUtility.setTransportFactory(carFactory);
        Transport newTransport = TransportUtility.createInstance("Машинка из фабрики фабрик", initialModelsCount);
        System.out.printf("%s с размером %s и %s", newTransport.getBrand(), newTransport.getSize(), newTransport);

        TransportUtility.setTransportFactory(motorcycleFactory);
        Transport newTransport2 = TransportUtility.createInstance("Мотоцикл из фабрики фабрик", initialModelsCount);
        System.out.printf("%s с размером %s и \n", newTransport2.getBrand(), newTransport2.getSize());
        TransportUtility.printAllModels(newTransport2);
    }

    static void delimeter() {
        System.out.println("-------------------------------");
    }
}