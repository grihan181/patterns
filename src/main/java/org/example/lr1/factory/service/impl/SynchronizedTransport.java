package org.example.lr1.factory.service.impl;

import org.example.lr1.factory.Transport;
import org.example.exception.DuplicateModelNameException;
import org.example.exception.NoSuchModelNameException;
import org.example.lr3.visitor.Visitor;

public class SynchronizedTransport implements Transport {

    private final Transport originalTransport;

    public SynchronizedTransport(Transport t) {
        this.originalTransport = t;
    }

    @Override
    public synchronized void setBrand(String brand) {
        this.originalTransport.setBrand(brand);
    }

    @Override
    public synchronized String getBrand() {
        return this.originalTransport.getBrand();
    }

    @Override
    public synchronized int getSize() {
        return this.originalTransport.getSize();
    }

    @Override
    public synchronized String[] getAllModelNames() {
        return this.originalTransport.getAllModelNames();
    }

    @Override
    public synchronized int[] getAllModelPrices() {
        return this.originalTransport.getAllModelPrices();
    }

    @Override
    public synchronized double getModelPriceByName(String modelName) throws NoSuchModelNameException {
        return this.originalTransport.getModelPriceByName(modelName);
    }

    @Override
    public synchronized void setModelPriceByName(String modelName, int newPrice) throws NoSuchModelNameException {
        this.originalTransport.setModelPriceByName(modelName, newPrice);
    }

    @Override
    public synchronized void setModelNameByOldName(String oldName, String newName)
            throws NoSuchModelNameException, DuplicateModelNameException {
        this.originalTransport.setModelNameByOldName(oldName, newName);
    }

    @Override
    public synchronized void addModel(String name, int price) throws DuplicateModelNameException {
        this.originalTransport.addModel(name, price);
    }

    @Override
    public synchronized void deleteModel(String modelName) throws NoSuchModelNameException {
        this.originalTransport.deleteModel(modelName);
    }

    @Override
    public synchronized void accept(Visitor visitor) {
        this.originalTransport.accept(visitor);
    }
}
