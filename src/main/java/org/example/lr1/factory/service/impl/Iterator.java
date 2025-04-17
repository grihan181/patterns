package org.example.lr1.factory.service.impl;

import static org.example.lr1.factory.util.TransportUtility.initModel;

public class Iterator {

    public static void main(String[] args) throws Exception {
        Car car = new Car("Lada", 3);
        initModel(car);

        for (Car.Model model : car) {
            System.out.println(model.toString());
        }
    }
}
