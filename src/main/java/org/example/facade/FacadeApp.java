package org.example.facade;

import javax.swing.*;
import java.awt.*;

public class FacadeApp {
    private TrafficFacade trafficFacade;

    public static void main( String[] args ) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FacadeApp().createAndShowGUI();
            }
        });
    }

    public void createAndShowGUI() {

        JFrame frame = new JFrame("Car and Traffic Light");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 250);

        JPanel drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                trafficFacade.drawObjects(g);
            }
        };

        trafficFacade = new TrafficFacade(drawingPanel);

        frame.add(drawingPanel, BorderLayout.CENTER);
        frame.setVisible(true);

        Timer signalTimer = new Timer(1000, e -> trafficFacade.trafficLightChangeSignal());
        signalTimer.start();
        Timer carMovementTimer = new Timer(10, e -> trafficFacade.performCarMovement());
        carMovementTimer.start();
    }
}
