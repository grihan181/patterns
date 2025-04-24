package org.example.lr4.dao.dao;

import org.example.exception.DuplicateModelNameException;
import org.example.lr1.factory.Transport;
import org.example.lr1.factory.service.impl.Car;
import org.example.lr1.factory.service.impl.Motorcycle;

import java.io.*;

import static org.example.constant.PatternsConst.CAR_CLASS_NAME;

public class TextFileTransportDAO implements TransportDAO {

    @Override
    public Transport load(String path) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String type = bufferedReader.readLine();
            String brand = bufferedReader.readLine();
            int size = Integer.parseInt(bufferedReader.readLine());

            Transport transport;

            if (CAR_CLASS_NAME.equals(type)) {
                transport = new Car(brand, 0);
            } else {
                transport = new Motorcycle(brand, 0);
            }

            for (int i = 0; i < size; i++) {
                String modelName = bufferedReader.readLine();
                int modelPrice = Integer.parseInt(bufferedReader.readLine());
                transport.addModel(modelName, modelPrice);
            }

            return transport;
        } catch (NumberFormatException | IOException | DuplicateModelNameException e) {
            e.getCause();
            return null;
        }
    }

    @Override
    public void save(Transport transport, String file) {
        try (PrintWriter out = new PrintWriter(new FileWriter(file))) {
            out.println(transport.getClass().getName());
            out.println(transport.getBrand());
            out.println(transport.getSize());
            String[] modelNames = transport.getAllModelNames();
            int[] modelPrices = transport.getAllModelPrices();

            for (int i = 0; i < transport.getSize(); i++) {
                out.println(modelNames[i]);
                out.println(modelPrices[i]);
            }
        } catch (IOException e) {
            e.getCause();
        }
    }
}
