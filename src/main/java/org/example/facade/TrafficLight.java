package org.example.facade;

import lombok.Getter;
import org.example.exception.ImageNotFoundException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

@Getter
public class TrafficLight {

    private int x, y;
    private JPanel panel;
    private int currentSignal = 0;
    BufferedImage trafficLightImageRed;
    BufferedImage trafficLightImageYellow;
    BufferedImage trafficLightImageGreen;

    public TrafficLight(int x, int y, JPanel panel) throws ImageNotFoundException {
        this.x = x;
        this.y = y;
        this.panel = panel;
        try {
            trafficLightImageRed = ImageIO.read(getClass().getClassLoader().getResourceAsStream("facade/red.jpg"));
            trafficLightImageYellow = ImageIO.read(getClass().getClassLoader().getResourceAsStream("facade/yellow.jpg"));
            trafficLightImageGreen = ImageIO.read(getClass().getClassLoader().getResourceAsStream("facade/green.jpg"));
        } catch (Exception e) {
            throw new ImageNotFoundException();
        }
        
    }

    public void drawTrafficLight(Graphics g) {
        // 0: red 2: green, other: yellow
        switch (currentSignal) {
            case 0 -> g.drawImage(trafficLightImageRed, x, y, null);
            case 2 -> g.drawImage(trafficLightImageGreen, x, y, null);
            default -> g.drawImage(trafficLightImageYellow, x, y, null);
        }
    }

    public void changeSignal() {
        currentSignal++;
        if (currentSignal > 3) {
            currentSignal = 0;
        }
        panel.repaint();
    }
}
