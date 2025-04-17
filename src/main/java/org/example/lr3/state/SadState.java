package org.example.lr3.state;

import java.awt.*;

public class SadState implements HumanState {

    public void draw(Graphics2D g2, HumanComponent c) {
        g2.setColor(Color.CYAN);
        g2.fillOval(70, 50, 60, 60); // голова
        g2.setColor(Color.BLACK);
        g2.drawArc(85, 90, 30, 15, 0, 180); // грусть
        g2.fillOval(85, 70, 5, 5); // глаза
        g2.fillOval(110, 70, 5, 5);
    }
}