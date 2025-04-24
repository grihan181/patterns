package org.example.lr4.mvc;

import org.example.lr4.mvc.controller.FunctionController;
import org.example.lr4.mvc.model.FunctionModel;
import org.example.lr4.mvc.view.FunctionView;

public class Mvc {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            FunctionModel model = new FunctionModel();
            FunctionView view = new FunctionView();
            new FunctionController(model, view);
            view.setVisible(true);
        });
    }
}