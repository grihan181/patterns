package org.example.lr4.mvc.model;

import lombok.Getter;

import java.util.*;
import java.util.function.Function;

@Getter
public class FunctionModel {

    private final List<Double> xValues = new ArrayList<>();
    private final List<Double> yValues = new ArrayList<>();

    private Function<Double, Double> currentFunction = Math::sin;

    public void setFunction(Function<Double, Double> func) {
        this.currentFunction = func;
        recalculateY();
    }

    public void addPoint(double x) {
        xValues.add(x);
        yValues.add(currentFunction.apply(x));
    }

    public void updatePoint(int index, double x) {
        xValues.set(index, x);
        yValues.set(index, currentFunction.apply(x));
    }

    public void removePoint(int index) {
        xValues.remove(index);
        yValues.remove(index);
    }

    private void recalculateY() {
        yValues.clear();
        for (double x : xValues) {
            yValues.add(currentFunction.apply(x));
        }
    }

    public double getX(int index) { return xValues.get(index); }

    public int getSize() { return xValues.size(); }
}