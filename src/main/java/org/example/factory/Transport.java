package org.example.factory;

import org.example.factory.exception.DuplicateModelNameException;
import org.example.factory.exception.ModelPriceOutOfBoundsException;
import org.example.factory.exception.NoSuchModelNameException;

public interface Transport extends Cloneable {
    void setBrand(String brand);
    String getBrand();

    int getSize();

    String[] getAllModelNames();
    int[] getAllModelPrices();

    double getModelPriceByName(String modelName) throws NoSuchModelNameException;
    void setModelPriceByName(String modelName, int newPrice) throws NoSuchModelNameException;
    void setModelNameByOldName(String oldName, String newName) throws NoSuchModelNameException, DuplicateModelNameException;
    void addModel(String name, int price) throws DuplicateModelNameException;
    void deleteModel(String modelName) throws NoSuchModelNameException;
}