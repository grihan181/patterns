package org.example.lr4.dao;

import org.example.lr1.factory.Transport;
import org.example.lr1.factory.util.TransportUtility;
import org.example.lr4.dao.dao.SerializedTransportDAO;
import org.example.lr4.dao.dao.TextFileTransportDAO;

import static org.example.constant.PatternsConst.PRINT_TRANSPORT;

public class Dao {

    public static void main(String[] args) {
        TextFileTransportDAO textFileTransportDAO = new TextFileTransportDAO();
        SerializedTransportDAO serializedTransportDAO = new SerializedTransportDAO();

        Transport textLoadedCar = textFileTransportDAO.load("car_text");
        Transport serializedLoadedCar = serializedTransportDAO.load("car_serialize");

        System.out.println("Text file");
        System.out.println(String.format(PRINT_TRANSPORT, textLoadedCar.getBrand(), textLoadedCar.getSize()));
        TransportUtility.printAllModels(textLoadedCar);
        System.out.println("Serialize");
        System.out.println(String.format(PRINT_TRANSPORT, serializedLoadedCar.getBrand(), serializedLoadedCar.getSize()));
        TransportUtility.printAllModels(serializedLoadedCar);

        Transport textLoadedMotorcycle = textFileTransportDAO.load("motorcycle_text");
        Transport serializedLoadedMotorcycle = serializedTransportDAO.load("motorcycle_serialize");

        System.out.println("Text file");
        System.out.println(String.format(PRINT_TRANSPORT, textLoadedMotorcycle.getBrand(), textLoadedMotorcycle.getSize()));
        TransportUtility.printAllModels(textLoadedMotorcycle);
        System.out.println("Serialize");
        System.out.println(String.format(PRINT_TRANSPORT, serializedLoadedMotorcycle.getBrand(), serializedLoadedMotorcycle.getSize()));
        TransportUtility.printAllModels(serializedLoadedMotorcycle);

    }
}
