package org.example.factory;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.factory.exception.DuplicateModelNameException;
import org.example.factory.exception.ModelPriceOutOfBoundsException;
import org.example.factory.exception.NoSuchModelNameException;

public class Motorcycle implements Transport {
    private String brand;
    private Model head = new Model("Head", 0);
    {
        head.prev = head;
        head.next = head;
    }

    public Motorcycle(String brand, int size) throws DuplicateModelNameException {
        if (size < 0) {
            throw new RuntimeException("Количество моделей не может быть меньше 0!");
        }
        this.brand = brand;

        for (int i = 0; i < size; i++) {
            addModel(null, i * 10);
        }
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getSize() {
        int size = 0;
        Model cModel = head.next;
        while (!cModel.equals(head)) {
            size++;
            cModel = cModel.next;
        }
        return size;
    }

    public String[] getAllModelNames() {
        if (getSize() == 0) {
            return new String[0];
        }
        String[] allNames = new String[getSize()];
        Model cModel = head.next;
        int i = 0;
        while (!cModel.equals(head)) {
            allNames[i] = cModel.getName();
            cModel = cModel.next;
            i++;
        }
        return allNames;
    }

    public int[] getAllModelPrices() {
        int[] allPrices = new int[getSize()];
        Model cModel = head.next;
        int i = 0;
        while (!cModel.equals(head)) {
            allPrices[i] = cModel.getPrice();
            cModel = cModel.next;
            i++;
        }
        return allPrices;
    }

    public void setModelPriceByName(String name, int price) throws NoSuchModelNameException {
        getModelByName(name).setPrice(price);
    }

    public void setModelNameByOldName(String oldName, String newName)
            throws NoSuchModelNameException, DuplicateModelNameException {
        if (isContainModel(newName)) {
            throw new DuplicateModelNameException(newName);
        }
        getModelByName(oldName).setName(newName);
    }

    public double getModelPriceByName(String name) throws NoSuchModelNameException {
        Model model = getModelByName(name);
        return model.getPrice();
    }

    public void addModel(String name, int price) throws DuplicateModelNameException {
        if (price < 0) {
            throw new ModelPriceOutOfBoundsException(price);
        }
        if (isContainModel(name)) {
            throw new DuplicateModelNameException(name);
        }

        if (head.prev.name == null && name != null) {
            Model cModel = head.next;
            while (!cModel.equals(head)) {
                if (cModel.getName() == null) {
                    cModel.setName(name);
                    cModel.setPrice(price);
                    return;
                }
                cModel = cModel.next;
            }
        }

        Model newModel = new Model(name, price);
        try {
            Model lastModel = getLastModel();
            newModel.prev = lastModel;
            lastModel.next = newModel;
        } catch (NoSuchModelNameException e) {
            newModel.prev = head;
            head.next = newModel;
        }
        newModel.next = head;
        head.prev = newModel;
    }

    public Model getLastModel() throws NoSuchModelNameException {
        Model cModel = head.next;
        while (!cModel.equals(head)) {
            if (cModel.next.equals(head)) {
                return cModel;
            }
            cModel = cModel.next;
        }
        throw new NoSuchModelNameException("");
    }

    public void deleteModel(String name) throws NoSuchModelNameException {
        Model modelToDelete = getModelByName(name);
        Model nextModel = modelToDelete.next;
        Model prevModel = modelToDelete.prev;
        nextModel.prev = prevModel;
        prevModel.next = nextModel;
    }


    public Model getModelByName(String name) throws NoSuchModelNameException {
        Model cModel = head.next;
        while (!cModel.equals(head)) {
            if (cModel.getName().equals(name)) {
                return cModel;
            }
            cModel = cModel.next;
        }
        throw new NoSuchModelNameException(name);
    }

    private boolean isContainModel(String name) {
        for (String modelName : getAllModelNames()) {
            if (modelName != null && modelName.equals(name)) {
                return true;
            }
        }
        return false;
    }

    @Data
    @NoArgsConstructor
    public static class Model {
        private String name;
        private int price;
        public Model prev = null;
        public Model next = null;

        public Model(String name, int price) {
            if (price < 0) {
                throw new ModelPriceOutOfBoundsException(price);
            }
            this.name = name;
            this.price = price;
        }

        public void setPrice(int price) throws ModelPriceOutOfBoundsException{
            if (price < 0) {
                throw new ModelPriceOutOfBoundsException(price);
            }
            this.price = price;
        }
    }
}
