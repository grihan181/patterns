package org.example.lr2.facade;

import org.example.exception.ImageNotFoundException;

import javax.swing.*;
import java.awt.*;

public class FacadeApp {

    private TrafficFacade trafficFacade;

    public static void main( String[] args ) {
        SwingUtilities.invokeLater(() -> {
            try {
                new FacadeApp().createAndShowGUI();
            } catch (ImageNotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    public void createAndShowGUI() throws ImageNotFoundException {

        JFrame frame = new JFrame("Car and Traffic Light");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(2560, 1600);

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

        Timer signalTimer = new Timer(2000, e -> trafficFacade.trafficLightChangeSignal());
        signalTimer.start();
        Timer carMovementTimer = new Timer(5, e -> trafficFacade.performCarMovement());
        carMovementTimer.start();
    }
}
