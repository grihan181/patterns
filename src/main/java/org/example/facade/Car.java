package org.example.facade;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Car {
    private int x, y;
    private JPanel panel;
    private BufferedImage carImage;

    public Car(int x, int y, JPanel panel) {
        this.x = x;
        this.y = y;
        this.panel = panel;
        try {
            carImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("car.png"));
        } catch (Exception e) {
            carImage = new BufferedImage(0, 0, 0);
        }
    }

    public void drawCar(Graphics g) {
        g.drawImage(carImage, x, y, null);
    }

    public int getXPosition() {
        return this.x + carImage.getWidth();
    }

    public void changePosition(int boundary) {
        this.x += 10;
        if (this.x > boundary) {
            this.x = -this.carImage.getWidth();
        }
        panel.repaint();
    }
}
