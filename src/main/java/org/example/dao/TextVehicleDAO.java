package org.example.dao;

import org.example.factory.Car;
import org.example.factory.Motorcycle;
import org.example.factory.Transport;
import org.example.factory.exception.DuplicateModelNameException;

import java.io.*;

public class TextVehicleDAO implements TransportDAO {
    @Override
    public Transport load(String filename) throws IOException, DuplicateModelNameException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            String type = bufferedReader.readLine();
            String brand = bufferedReader.readLine();
            int size = Integer.parseInt(bufferedReader.readLine());

            Transport vehicle;

            if (type.equals("factory.Car")) {
                vehicle = new Car(brand, 0);
            } else {
                vehicle = new Motorcycle(brand, 0);
            }

            for (int i = 0; i < size; i++) {
                String modelName = bufferedReader.readLine();
                int modelPrice = Integer.parseInt(bufferedReader.readLine());
                vehicle.addModel(modelName, modelPrice);
            }

            return vehicle;
        } catch (NumberFormatException | IOException e) {
            throw new IOException("Error reading file", e);
        }
    }

    @Override
    public void save(Transport vehicle, String filename) throws IOException {
        try (PrintWriter out = new PrintWriter(new FileWriter(filename))) {
            out.println(vehicle.getClass().getName());
            out.println(vehicle.getBrand());
            out.println(vehicle.getSize());
            String[] modelNames = vehicle.getAllModelNames();
            int[] modelPrices = vehicle.getAllModelPrices();

            for (int i = 0; i < vehicle.getSize(); i++) {
                out.println(modelNames[i]);
                out.println(modelPrices[i]);
            }
        }
    }
}