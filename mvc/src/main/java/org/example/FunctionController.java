package org.example;

import javax.swing.JOptionPane;
import java.util.function.Consumer;

public class FunctionController {
    private FunctionModel model;
    private FunctionView view;

    public FunctionController(FunctionModel model, FunctionView view) {
        this.model = model;
        this.view = view;
        initView();
    }

    private void initView() {
        view.setVisible(true);
        view.getAddButton().addActionListener(e -> {
            try {
                double x = Double.parseDouble(view.getXInputField().getText());
                addValue(x);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(view, "Неверное значение x. Введите число!");
            }
        });

        view.getRemoveButton().addActionListener(e -> {
            int selectedRow = view.getTable().getSelectedRow();
            if (selectedRow >= 0) {
                removeValue(selectedRow);
            } else {
                JOptionPane.showMessageDialog(view, "Выберите элемент!");
            }
        });

        view.getEditButton().addActionListener(e -> {
            int selectedRow = view.getTable().getSelectedRow();
            try {
                double x = Double.parseDouble(view.getXInputField().getText());
                if (selectedRow >= 0) {
                    updateValue(selectedRow, x);
                } else {
                    JOptionPane.showMessageDialog(view, "Выберите элемент!");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(view, "Неверное значение x. Введите число!");
            }
        });
    }

    public void addValue(double x) {
        model.addValue(x);
        view.updateView();
    }

    public void removeValue(int index) {
        model.removeValue(index);
        view.updateView();
    }

    public void updateValue(int index, double x) {
        model.updateValue(index, x);
        view.updateView();
    }
}