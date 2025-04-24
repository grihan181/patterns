package org.example.lr4.mvc.controller;


import org.example.lr4.mvc.model.FunctionModel;
import org.example.lr4.mvc.view.FunctionView;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.TableModel;
import java.util.function.Function;

public class FunctionController {

    private final FunctionModel model;
    private final FunctionView view;

    public FunctionController(FunctionModel model, FunctionView view) {
        this.model = model;
        this.view = view;

        view.getAddButton().addActionListener(e -> {
            try {
                double x = Double.parseDouble(view.getInputX().getText());
                addPoint(x);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(view, "Введите корректное значение X");
            }
        });

        view.getRemoveButton().addActionListener(e -> {
            int row = view.getTable().getSelectedRow();
            if (row >= 0) {
                removePoint(row);
            }
        });

        view.getFunctionSelector().addActionListener(e -> {
            String selected = (String) view.getFunctionSelector().getSelectedItem();
            Function<Double, Double> func = switch (selected) {
                case "cos(x)" -> Math::cos;
                case "x^2" -> x -> x * x;
                case "exp(x)" -> Math::exp;
                case "log(x)" -> x -> x > 0 ? Math.log(x) : 0.0;
                default -> Math::sin;
            };
            model.setFunction(func);
            updateView();
        });

        view.getTable().getModel().addTableModelListener(e -> {
            if (e.getType() == TableModelEvent.UPDATE) {
                int row = e.getFirstRow();
                TableModel tm = view.getTable().getModel();
                double newX = Double.parseDouble((String) tm.getValueAt(row, 0));
                updatePoint(row, newX);
            }
        });

        updateView();
    }

    public void addPoint(double x) {
        model.addPoint(x);
        updateView();
    }

    public void updatePoint(int index, double x) {
        model.updatePoint(index, x);
        updateView();
    }

    public void removePoint(int index) {
        model.removePoint(index);
        updateView();
    }

    public void updateView() {
        view.updateTable(model.getXValues(), model.getYValues());
        view.updateGraph(model.getXValues(), model.getYValues());
    }
}