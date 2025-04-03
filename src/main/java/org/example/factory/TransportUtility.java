package org.example.factory;

import lombok.Data;
import lombok.experimental.UtilityClass;
import org.example.factory.exception.DuplicateModelNameException;

@UtilityClass
public class TransportUtility {

    private TransportFactory factory = new CarFactory();

    public double averagePrice(Transport vehicle) {
        int[] prices = vehicle.getAllModelPrices();
        int sum = 0;
        if (prices.length == 0) {
            return 0;
        }
        for (int price : prices) {
            sum += price;
        }
        return sum * 1.0 / prices.length;
    }

    public void printAllModels(Transport vehicle) {
        int[] prices = vehicle.getAllModelPrices();
        String[] names = vehicle.getAllModelNames();

        for (int i = 0; i < names.length; i++) {
            System.out.println("Модель: " + names[i] + " Цена: " + prices[i]);
        }
    }

    public void printAllNames(Transport vehicle) {
        String[] names = vehicle.getAllModelNames();

        for (int i = 0; i < names.length; i++) {
            System.out.println("Модель: " + names[i]);
        }
    }

    public void printAllPrices(Transport vehicle) {
        int[] prices = vehicle.getAllModelPrices();

        for (int i = 0; i < prices.length; i++) {
            System.out.println("Цена: " + prices[i]);
        }
    }

    public void setTransportFactory(TransportFactory factory) {
        TransportUtility.factory = factory;
    }

    public Transport createInstance(String name, int size) throws DuplicateModelNameException {
        return TransportUtility.factory.createInstance(name, size);
    }

    public static Transport synchronizedVehicle(Transport transport) {
        return new SynchronizedTransport(transport);
    }
}

