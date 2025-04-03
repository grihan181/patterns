package org.example.factory.service.impl;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.factory.Transport;
import org.example.exception.DuplicateModelNameException;
import org.example.exception.ModelPriceOutOfBoundsException;
import org.example.exception.NoSuchModelNameException;

import static org.example.constant.ExceptionMessageConst.NEGATIVE_COUNT_MODEL;
import static org.example.factory.util.TransportUtility.validateName;

@Data
public class Motorcycle implements Transport {

    private static final String HEAD = "Head";

    private String brand;
    private int size;
    private Model head = new Model(HEAD, 0);
    {
        head.prev = head;
        head.next = head;
    }

    public Motorcycle(String brand, int size) throws DuplicateModelNameException {
        if (size < 0) {
            throw new RuntimeException(NEGATIVE_COUNT_MODEL);
        }

        this.brand = brand;
        this.size = 0;

        for (int i = 0; i < size; i++) {
            addModel(null, 0);
        }
    }

    public String[] getAllModelNames() {
        int size = getSize();
        if (size == 0) {
            return new String[0];
        }

        String[] modelNames = new String[size];
        Model cModel = head.next;
        int i = 0;
        while (!cModel.equals(head)) {
            modelNames[i] = cModel.getName();
            cModel = cModel.next;
            i++;
        }
        return modelNames;
    }

    public int[] getAllModelPrices() {
        int[] modelPrices = new int[getSize()];
        Model cModel = head.next;
        int i = 0;
        while (!cModel.equals(head)) {
            modelPrices[i] = cModel.getPrice();
            cModel = cModel.next;
            i++;
        }
        return modelPrices;
    }

    public double getModelPriceByName(String name) throws NoSuchModelNameException {
        Model model = getModelByName(name);
        return model.getPrice();
    }

    public void setModelPriceByName(String name, int price) throws NoSuchModelNameException {
        getModelByName(name).setPrice(price);
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
        ++size;
    }

    public void deleteModel(String name) throws NoSuchModelNameException {
        Model modelToDelete = getModelByName(name);
        Model nextModel = modelToDelete.next;
        Model prevModel = modelToDelete.prev;
        nextModel.prev = prevModel;
        prevModel.next = nextModel;
        --size;
    }

    public Model getModelByName(String name) throws NoSuchModelNameException {
        validateName(name);

        Model cModel = head.next;
        while (!cModel.equals(head)) {
            if (cModel.getName().equals(name)) {
                return cModel;
            }
            cModel = cModel.next;
        }
        throw new NoSuchModelNameException(name);
    }

    public void setModelNameByOldName(String oldName, String newName)
            throws NoSuchModelNameException, DuplicateModelNameException {

        Model newModel = null;
        Model cModel = head.next;
        while (!cModel.equals(head)) {
            if (cModel.getName().equals(newName)) {
                throw new DuplicateModelNameException(newName);
            } else if(cModel.getName().equals(oldName)) {
                newModel = cModel;
            }
            cModel = cModel.next;
        }

        if (newModel == null) {
            throw new NoSuchModelNameException(oldName);
        } else {
            newModel.setName(newName);
        }
    }

    private boolean isContainModel(String name) {
        for (String modelName : getAllModelNames()) {
            if (modelName != null && modelName.equals(name)) {
                return true;
            }
        }
        return false;
    }

    private Model getLastModel() throws NoSuchModelNameException {
        Model cModel = head.next;
        while (!cModel.equals(head)) {
            if (cModel.next.equals(head)) {
                return cModel;
            }
            cModel = cModel.next;
        }
        throw new NoSuchModelNameException("");
    }

    @Override
    public Motorcycle clone() throws CloneNotSupportedException {
        Motorcycle motorcycleClone = (Motorcycle) super.clone();
        motorcycleClone.head = new Model(HEAD, 0);
        Model cModel = this.head.next;
        Model cloned = motorcycleClone.head;

        while (!cModel.equals(this.head)) {
            cloned.next = cModel.clone();
            cloned.next.prev = cloned;
            cloned = cloned.next;
            cModel = cModel.next;
        }

        motorcycleClone.head.prev = cloned;
        cloned.next = motorcycleClone.head;

        return motorcycleClone;
    }

    @Data
    @NoArgsConstructor
    public static class Model implements Cloneable {

        private String name;
        private int price;
        private Model prev;
        private Model next;

        @Override
        public Model clone() throws CloneNotSupportedException {
            Model modelClone = (Model) super.clone();
            modelClone.setName(name);
            modelClone.setPrice(price);

            return modelClone;
        }

        public Model(String name, int price) {
            if (price < 0) {
                throw new ModelPriceOutOfBoundsException(price);
            }

            this.name = name;
            this.price = price;
            this.prev = null;
            this.next = null;
        }

        public void setPrice(int price) throws ModelPriceOutOfBoundsException{
            if (price < 0) {
                throw new ModelPriceOutOfBoundsException(price);
            }
            this.price = price;
        }
    }
}
