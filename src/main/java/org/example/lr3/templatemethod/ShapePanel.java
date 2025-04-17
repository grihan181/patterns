package org.example.lr3.templatemethod;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ShapePanel extends JPanel {

    private final List<AbstractShape> shapes = new CopyOnWriteArrayList<>();

    public void addShape(AbstractShape shape) {
        shapes.add(shape);
        new Thread(shape).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (AbstractShape shape : shapes) {
            shape.draw(g);
        }
    }
}