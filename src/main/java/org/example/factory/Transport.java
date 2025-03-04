package org.example.factory;

import org.example.factory.exception.DuplicateModelNameException;
import org.example.factory.exception.ModelPriceOutOfBoundsException;
import org.example.factory.exception.NoSuchModelNameException;

public interface Transport {
    public void setBrand(String brand);
    public String getBrand();

    public int getSize();

    public String[] getAllModelNames();
    public int[] getAllModelPrices();

    public double getModelPriceByName(String modelName) throws NoSuchModelNameException;
    public void setModelPriceByName(String modelName, int newPrice) throws NoSuchModelNameException;
    public void setModelNameByOldName(String oldName, String newName) throws NoSuchModelNameException, DuplicateModelNameException;
    public void addModel(String name, int price) throws DuplicateModelNameException, ModelPriceOutOfBoundsException;
    public void deleteModel(String modelName) throws NoSuchModelNameException;
}