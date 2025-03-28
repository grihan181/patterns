package org.example.factory.util;

import lombok.experimental.UtilityClass;
import org.example.factory.Transport;
import org.example.factory.TransportFactory;
import org.example.factory.exception.DuplicateModelNameException;
import org.example.factory.service.impl.CarFactory;

import static org.example.constant.ExceptionMessageException.EMPTY_NAME;

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
            System.out.println("Model: " + names[i] + " Price: " + prices[i]);
        }
    }

    public void printAllNames(Transport vehicle) {
        String[] names = vehicle.getAllModelNames();

        for (int i = 0; i < names.length; i++) {
            System.out.println("Model: " + names[i]);
        }
    }

    public void printAllPrices(Transport vehicle) {
        int[] prices = vehicle.getAllModelPrices();

        for (int i = 0; i < prices.length; i++) {
            System.out.println("Price: " + prices[i]);
        }
    }

    public void setTransportFactory(TransportFactory factory) {
        TransportUtility.factory = factory;
    }

    public Transport createInstance(String name, int size) throws DuplicateModelNameException {
        return TransportUtility.factory.createInstance(name, size);
    }

    public static void validateName(String modelName) {
        if (modelName == null || modelName.isEmpty()) {
            throw new RuntimeException(EMPTY_NAME);
        }
    }
}

