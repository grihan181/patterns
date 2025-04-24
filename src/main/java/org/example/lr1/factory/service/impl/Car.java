package org.example.lr1.factory.service.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.lr3.command.FieldPrinter;
import org.example.lr1.factory.Transport;
import org.example.exception.DuplicateModelNameException;
import org.example.exception.ModelPriceOutOfBoundsException;
import org.example.exception.NoSuchModelNameException;
import org.example.lr3.visitor.Visitor;

import java.io.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.example.constant.ExceptionMessageConst.CAR_NOT_FOUND;
import static org.example.constant.ExceptionMessageConst.NEGATIVE_COUNT_MODEL;
import static org.example.lr1.factory.util.TransportUtility.validateName;

@Data
public class Car implements Transport, Iterable<Car.Model>, Serializable {

    private String brand;
    private Model[] models;
    private FieldPrinter printer;

    public Car(String brand, int size) throws DuplicateModelNameException {
        if (size < 0) {
            throw new RuntimeException(NEGATIVE_COUNT_MODEL);
        }

        this.brand = brand;
        this.models = new Model[size];

        for (int i = 0; i < size; i++) {
            addModel(null, 0);
        }
    }

    public int getSize() {
        return models.length;
    }
    
    public Model getModelByName(String modelName) throws NoSuchModelNameException {
        return Arrays.stream(models)
                .filter(model -> !checkNull(model) && model.getName().equals(modelName))
                .findAny().orElseThrow(() -> new NoSuchModelNameException(modelName));
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
        validateName(modelName);

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
        Model newModel = null;
        for (int i = 0; i < getSize(); i++) {
            if (models[i].getName().equals(newName)) {
                throw new DuplicateModelNameException(newName);
            } else if (models[i].getName().equals(oldName)) {
                newModel = models[i];
            }
        }

        if (newModel == null) {
            throw new NoSuchModelNameException(oldName);
        } else {
            newModel.setName(newName);
        }
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

    private boolean checkNull(Model model) {
        return model == null || model.getName() == null;
    }

    private boolean isContainModel(String modelName) {
        try{
            getModelByName(modelName);
        } catch (NoSuchModelNameException e) {
            return false;
        }
        return true;
    }

    public void setPrintCommand(FieldPrinter printer) {
        this.printer = printer;
    }

    public void print(PrintWriter out) throws IOException {
        this.printer.print(this, out);
    }

    public void serialize(String filename) throws IOException {
        try (PrintWriter out = new PrintWriter(new FileWriter(filename))) {
            out.println(brand);
            out.println(models.length);
            for (Model model : models) {
                out.println(model.getName());
                out.println(model.getPrice());
            }
        }
    }

    public static Car deserialize(String filename) throws IOException, DuplicateModelNameException {
        try (BufferedReader in = new BufferedReader(new FileReader(filename))) {
            String brand = in.readLine();
            int modelCount = Integer.parseInt(in.readLine());
            Car car = new Car(brand, modelCount);
            for (int i = 0; i < modelCount; i++) {
                String modelName = in.readLine();
                int modelPrice = Integer.parseInt(in.readLine());
                car.models[i] = car.new Model(modelName, modelPrice);
            }
            return car;
        }
    }

    @Override
    public Iterator<Model> iterator() {
        return new AutoIterator();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Data
    @AllArgsConstructor
    class Model implements Cloneable, Serializable {
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

        @Override
        public String toString() {
            return String.format("Model: name = %s, price = $%d |", name, price);
        }
    }

    private class AutoIterator implements Iterator<Model> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < models.length && models[currentIndex] != null;
        }

        @Override
        public Model next() {
            if (!hasNext()) {
                throw new NoSuchElementException(CAR_NOT_FOUND);
            }
            return models[currentIndex++];
        }
    }

    public static class Memento implements Serializable {
        private byte[] serializedData;

        private Memento(byte[] data)  {
            this.serializedData = data;
        }

        private byte[] getSerializedData() {
            return serializedData;
        }

        public static Memento setAuto(Car car) throws IOException {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
                oos.writeObject(car);
            }
            return new Memento(baos.toByteArray());
        }

        public Car getAuto() throws IOException, ClassNotFoundException {
            ByteArrayInputStream bais = new ByteArrayInputStream(this.getSerializedData());
            try (ObjectInputStream ois = new ObjectInputStream(bais)) {
                return (Car) ois.readObject();
            }
        }
    }

    public Memento createMemento() throws IOException {
        return Memento.setAuto(this);
    }

    public void setMemento(Memento memento) throws IOException, ClassNotFoundException {
        Car car = memento.getAuto();
        this.brand  = car.getBrand();
        this.models = car.getModels();
    }
}
