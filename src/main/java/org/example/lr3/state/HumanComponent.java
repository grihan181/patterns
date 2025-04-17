package org.example.lr3.state;

import javax.swing.*;
import java.awt.*;

public class HumanComponent extends JComponent {

    private HumanContext context;

    public HumanComponent(HumanContext context) {
        this.context = context;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if (context.getState() != null) {
            context.getState().draw(g2, this);
        }
    }
}