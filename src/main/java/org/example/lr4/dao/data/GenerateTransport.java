package org.example.lr4.dao.data;


import org.example.exception.DuplicateModelNameException;
import org.example.lr1.factory.service.impl.Car;
import org.example.lr1.factory.service.impl.Motorcycle;
import org.example.lr4.dao.dao.SerializedTransportDAO;
import org.example.lr4.dao.dao.TextFileTransportDAO;
import org.example.lr4.dao.dao.TransportDAO;

import static org.example.constant.PatternsConst.COUNT_MODEL;
import static org.example.lr1.factory.util.TransportUtility.initModel;

public class GenerateTransport {

    private static final TransportDAO textFileTransportDAO = new TextFileTransportDAO();
    private static final TransportDAO serializedTransportDAO = new SerializedTransportDAO();

    public static void main(String[] args) throws DuplicateModelNameException {
        generateTextFileCar();
        generateTextFileMotorcycle();
        generateSerializedCar();
        generateSerializedMotorcycle();
    }

    private static void generateTextFileCar() throws DuplicateModelNameException {
        Car car = new Car("Lada", COUNT_MODEL);
        initModel(car);
        textFileTransportDAO.save(car, "car_text");
    }

    private static void generateTextFileMotorcycle() throws DuplicateModelNameException {
        Motorcycle motorcycle = new Motorcycle("Yamaha", COUNT_MODEL);
        initModel(motorcycle);
        textFileTransportDAO.save(motorcycle, "motorcycle_text");
    }

    private static void generateSerializedCar() throws DuplicateModelNameException {
        Car car = new Car("Lada", COUNT_MODEL);
        initModel(car);
        serializedTransportDAO.save(car, "car_serialize");
    }

    private static void generateSerializedMotorcycle() throws DuplicateModelNameException {
        Motorcycle motorcycle = new Motorcycle("Yamaha", COUNT_MODEL);
        initModel(motorcycle);
        serializedTransportDAO.save(motorcycle, "motorcycle_serialize");
    }
}
