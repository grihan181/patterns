package org.example.facade;

import javax.swing.*;
import java.awt.*;

public class TrafficFacade {
    private JPanel drawingPanel;
    private Car car;
    private TrafficLight trafficLight;

    public TrafficFacade(JPanel drawingPanel) {
        this.drawingPanel = drawingPanel;
        this.car = new Car(0, 65, drawingPanel);
        this.trafficLight = new TrafficLight(310, 45, drawingPanel);
    }

    public void drawObjects(Graphics g) {
        this.car.drawCar(g);
        this.trafficLight.drawTrafficLight(g);
    }

    public void performCarMovement() {
        if (isCarCanMove()) {
            this.car.changePosition(drawingPanel.getWidth());
        }
    }

    public void trafficLightChangeSignal() {
        this.trafficLight.changeSignal();
    }

    public boolean isCarCanMove() {
        return (this.car.getXPosition() < (this.trafficLight.getXPosition() - 20)
                || this.car.getXPosition() > (this.trafficLight.getXPosition() + 20)
                || this.trafficLight.getCurrentSignal() == 2);
    }
}
