package org.example.factory;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.factory.exception.DuplicateModelNameException;
import org.example.factory.exception.ModelPriceOutOfBoundsException;
import org.example.factory.exception.NoSuchModelNameException;

import java.io.Serializable;
import java.util.Arrays;
import java.util.stream.IntStream;

@Data
public class Car implements Transport, Serializable {
    private String brand;
    private Model[] models;

    public Car(String brand, int size) throws DuplicateModelNameException {
        if (size < 0) {
            throw new RuntimeException("Количество моделей не может быть меньше 0!");
        }
        this.brand = brand;
        this.models = new Model[size];

        for (int i = 0; i < size; i++) {
            addModel(null, 0);
        }
    }

    private boolean checkNull(Model model, String name) {
        return model == null || model.getName() == null || name == null;
    }

    public int getSize() {
        return models.length;
    }
    
    public Model getModelByName(String modelName) throws NoSuchModelNameException {
        return Arrays.stream(models)
                .filter(model -> !checkNull(model, modelName) && model.getName().equals(modelName))
                .findFirst().orElseThrow(() -> new NoSuchModelNameException(modelName));
    }

    public String[] getAllModelNames() {
        int size = getSize();
        if (size == 0) {
            return new String[0];
        }

        String[] modelNames = new String[size];
        for (int i = 0; i < size; i++) {
            modelNames[i] = models[i].getName();
        }

        return modelNames;
    }

    public int[] getAllModelPrices() {
        int size = getSize();
        if (size == 0) {
            return new int[0];
        }
        int[] modelPrices = new int[size];
        for (int i = 0; i < size; i++) {
            modelPrices[i] = models[i].getPrice();
        }
        return modelPrices;
    }

    public double getModelPriceByName(String modelName) throws NoSuchModelNameException {
        Model model = getModelByName(modelName);
        return model.getPrice();
    }

    public void setModelPriceByName(String modelName, int newPrice) throws NoSuchModelNameException {
        getModelByName(modelName).setPrice(newPrice);
    }

    public void addModel(String name, int price) throws DuplicateModelNameException {
        if (price < 0) {
            throw new ModelPriceOutOfBoundsException(price);
        }
        if (isContainModel(name)) {
            throw new DuplicateModelNameException(name);
        }

        int size = getSize();

        for (int i = 0; i < size; i++) {
            if (models[i] == null || models[i].getName() == null && name != null) {
                models[i] = new Model(name, price);
                return;
            }
        }

        models = Arrays.copyOf(models, size + 1);
        models[size] = new Model(name, price);
    }

    public void deleteModel(String modelName) throws NoSuchModelNameException {
        int size = getSize();
        for (int i = 0; i < size; i++) {
            if (models[i] != null && models[i].getName() != null && models[i].getName().equals(modelName)) {
                System.arraycopy(models, i + 1, models, i, size - 1 - i);
                models = Arrays.copyOf(models, size - 1);
                return;
            }
        }
        throw new NoSuchModelNameException(modelName);
    }

    public void setModelNameByOldName(String oldName, String newName)
            throws NoSuchModelNameException, DuplicateModelNameException {
        if(isContainModel(newName)) {
            throw new DuplicateModelNameException(newName);
        }

        Model newModel = null;
        for (int i = 0; i < getSize(); i++) {
            if (models[i].getName().equals(newName)) {
                throw new DuplicateModelNameException(newName);
            } else if(models[i].getName().equals(oldName)) {
                newModel = models[i];
            }
        }

        if (newModel == null) {
            throw new NoSuchModelNameException(oldName);
        } else {
            newModel.setName(newName);
        }
    }

    private boolean isContainModel(String modelName) {
        try{
            getModelByName(modelName);
        } catch (NoSuchModelNameException e) {
            return false;
        }
        return true;
    }

    @Override
    public Car clone() throws CloneNotSupportedException {
        int size = getSize();
        Car carClone = (Car) super.clone();
        carClone.brand = this.brand;
        carClone.models = new Model[size];
        for (int i = 0; i < size; i++) {
            carClone.models[i] = this.models[i].clone();
        }
        return carClone;
    }

    @Data
    @AllArgsConstructor
    public static class Model implements Cloneable, Serializable {
        private String name;
        private int price;

        public void setPrice(int price) throws ModelPriceOutOfBoundsException{
            if (price < 0) {
                throw new ModelPriceOutOfBoundsException(price);
            }
            this.price = price;
        }

        @Override
        public Model clone() throws CloneNotSupportedException {
            Model modelClone = (Model) super.clone();
            modelClone.setName(name);
            modelClone.setPrice(price);
            return modelClone;
        }
    }
}
