package org.example.factory;

import org.example.factory.exception.DuplicateModelNameException;
import org.example.factory.exception.NoSuchModelNameException;

public class SynchronizedTransport  implements Transport {
    private Transport originalVehicle;

    public SynchronizedTransport(Transport vehicle) {
        this.originalVehicle = vehicle;
    }

    @Override
    public synchronized void setBrand(String brand) {
        this.originalVehicle.setBrand(brand);
    }

    @Override
    public synchronized String getBrand() {
        return this.originalVehicle.getBrand();
    }

    @Override
    public synchronized int getSize() {
        return this.originalVehicle.getSize();
    }

    @Override
    public synchronized String[] getAllModelNames() {
        return this.originalVehicle.getAllModelNames();
    }

    @Override
    public synchronized int[] getAllModelPrices() {
        return this.originalVehicle.getAllModelPrices();
    }

    @Override
    public synchronized double getModelPriceByName(String modelName) throws NoSuchModelNameException {
        return this.originalVehicle.getModelPriceByName(modelName);
    }

    @Override
    public synchronized void setModelPriceByName(String modelName, int newPrice) throws NoSuchModelNameException {
        this.originalVehicle.setModelPriceByName(modelName, newPrice);
    }

    @Override
    public synchronized void setModelNameByOldName(String oldName, String newName)
            throws NoSuchModelNameException, DuplicateModelNameException {
        this.originalVehicle.setModelNameByOldName(oldName, newName);
    }

    @Override
    public synchronized void addModel(String name, int price) throws DuplicateModelNameException {
        this.originalVehicle.addModel(name, price);
    }

    @Override
    public synchronized void deleteModel(String modelName) throws NoSuchModelNameException {
        this.originalVehicle.deleteModel(modelName);
    }
}
