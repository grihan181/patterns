package org.example.lr3.templatemethod;

import java.awt.*;

public class Ball extends AbstractShape {

    public Ball(ShapePanel panel) {
        super(panel);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x, y, 30, 30);
    }
}