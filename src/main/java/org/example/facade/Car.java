package org.example.facade;

import org.example.exception.ImageNotFoundException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Car {

    private int x, y;
    private JPanel panel;
    private BufferedImage carImage;

    public Car(int x, int y, JPanel panel) throws ImageNotFoundException {
        this.x = x;
        this.y = y;
        this.panel = panel;
        try {
            carImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("facade/car.png"));
        } catch (Exception e) {
            throw new ImageNotFoundException();
        }
    }

    public void drawCar(Graphics g) {
        g.drawImage(carImage, x, y, null);
    }

    public int getX() {
        return this.x + carImage.getWidth();
    }

    public void changePosition(int screenWidth) {
        this.x += 10;
        if (this.x > screenWidth) {
            this.x = -this.carImage.getWidth();
        }
        panel.repaint();
    }
}
