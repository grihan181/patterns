package org.example.lr3.state;

import java.awt.*;

public class SleepingState implements HumanState {

    public void draw(Graphics2D g2, HumanComponent c) {
        g2.setColor(Color.LIGHT_GRAY);
        g2.fillOval(70, 50, 60, 60);
        g2.setColor(Color.BLACK);
        g2.drawString("Zzz...", 90, 45);
        g2.drawLine(85, 70, 90, 70);
        g2.drawLine(110, 70, 115, 70);
        g2.drawLine(85, 90, 115, 90);
    }
}