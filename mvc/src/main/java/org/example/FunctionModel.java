package org.example;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FunctionModel {
    private List<Double> xValues = new ArrayList<>();
    private List<Double> yValues = new ArrayList<>();

    public void addValue(double x) {
        xValues.add(x);
        yValues.add(calculateY(x));
    }

    public void removeValue(int index) {
        if (index >= 0 && index < xValues.size()) {
            xValues.remove(index);
            yValues.remove(index);
        }
    }

    public void updateValue(int index, double x) {
        if (index >= 0 && index < xValues.size()) {
            xValues.set(index, x);
            yValues.set(index, calculateY(x));
        }
    }

    private double calculateY(double x) {
        return Math.pow(x, 2);
    }
}