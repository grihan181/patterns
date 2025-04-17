package org.example.lr3.templatemethod;

import java.awt.*;

public class Star extends AbstractShape {

    public Star(ShapePanel panel) {
        super(panel);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.MAGENTA);
        int[] xPoints = {x + 15, x + 18, x + 30, x + 20, x + 23, x + 15, x + 7, x + 10, x, x + 12};
        int[] yPoints = {y, y + 10, y + 10, y + 18, y + 30, y + 23, y + 30, y + 18, y + 10, y + 10};
        g.fillPolygon(xPoints, yPoints, 10);
    }
}