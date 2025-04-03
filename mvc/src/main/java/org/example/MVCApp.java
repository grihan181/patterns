package org.example;

public class MVCApp {
    public static void main(String[] args) {
        FunctionModel model = new FunctionModel();
        FunctionView view = new FunctionView(model);
        FunctionController controller = new FunctionController(model, view);
    }
}