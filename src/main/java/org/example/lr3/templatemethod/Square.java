package org.example.lr3.templatemethod;

import java.awt.*;

public class Square extends AbstractShape {

    public Square(ShapePanel panel) {
        super(panel);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, 30, 30);
    }
}