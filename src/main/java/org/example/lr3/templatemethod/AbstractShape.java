package org.example.lr3.templatemethod;

import java.awt.*;

public abstract class AbstractShape implements Runnable {

    protected int x, y;
    protected int dx = 2, dy = 2;
    protected ShapePanel panel;

    public AbstractShape(ShapePanel panel) {
        this.panel = panel;
        this.x = panel.getWidth() - 30;
        this.y = panel.getHeight() - 30;
    }

    public final void run() {
        while (!Thread.currentThread().isInterrupted()) {
            move();
            panel.repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    protected void move() {
        x += dx;
        y += dy;
        if (x < 0 || x > panel.getWidth() - 30) dx = -dx;
        if (y < 0 || y > panel.getHeight() - 30) dy = -dy;
    }

    public abstract void draw(Graphics g);
}