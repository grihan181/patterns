package org.example.facade;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class TrafficLight {
    private int x, y;
    private JPanel panel;
    private int currentSignal = 0; // 0: red, 1: yellow, 2: green
    BufferedImage trafficLightImageRed;
    BufferedImage trafficLightImageYellow;
    BufferedImage trafficLightImageGreen;

    public TrafficLight(int x, int y, JPanel panel) {
        this.x = x;
        this.y = y;
        this.panel = panel;
        try {
            trafficLightImageRed = ImageIO.read(getClass().getClassLoader().getResourceAsStream("traffic_light_red.png"));
            trafficLightImageYellow = ImageIO.read(getClass().getClassLoader().getResourceAsStream("traffic_light_yellow.png"));
            trafficLightImageGreen = ImageIO.read(getClass().getClassLoader().getResourceAsStream("traffic_light_green.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public int getXPosition() {
        return this.x;
    }

    public int getCurrentSignal() {
        return currentSignal;
    }

    public void drawTrafficLight(Graphics g) {
        switch (currentSignal) {
            case 0 -> g.drawImage(trafficLightImageRed, x, y, null);
            case 1 -> g.drawImage(trafficLightImageYellow, x, y, null);
            case 2 -> g.drawImage(trafficLightImageGreen, x, y, null);
        }
    }

    public void changeSignal() {
        currentSignal++;
        if (currentSignal > 2) {
            currentSignal = 0;
        }
        panel.repaint();
    }
}
