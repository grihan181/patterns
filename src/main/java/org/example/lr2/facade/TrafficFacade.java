package org.example.lr2.facade;

import org.example.exception.ImageNotFoundException;

import javax.swing.*;
import java.awt.*;

public class TrafficFacade {

    private JPanel drawingPanel;
    private Car car;
    private TrafficLight trafficLight;

    public TrafficFacade(JPanel drawingPanel) throws ImageNotFoundException {
        this.drawingPanel = drawingPanel;
        this.car = new Car(0, 350, drawingPanel);
        this.trafficLight = new TrafficLight(1200, 250, drawingPanel);
    }

    public void drawObjects(Graphics g) {
        this.car.drawCar(g);
        this.trafficLight.drawTrafficLight(g);
    }

    public void performCarMovement() {
        if (isCanMove()) {
            this.car.changePosition(drawingPanel.getWidth());
        }
    }

    public void trafficLightChangeSignal() {
        this.trafficLight.changeSignal();
    }

    public boolean isCanMove() {
        int catX = this.car.getX();
        int trafficLightX = this.trafficLight.getX();
        return (catX < (trafficLightX - 50)
                || catX > (trafficLightX + 50)
                || this.trafficLight.getCurrentSignal() == 2);
    }
}
