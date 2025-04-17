package org.example.lr3.observer;

import javax.swing.*;
import java.awt.*;

public class FaceComponent extends JComponent {
    public boolean leftEyeClosed = false;
    public boolean rightEyeClosed = false;
    public Color noseColor = Color.ORANGE;
    public boolean smiling = false;

    public Rectangle leftEyeArea = new Rectangle(50, 60, 30, 20);
    public Rectangle rightEyeArea = new Rectangle(120, 60, 30, 20);
    public Rectangle noseArea = new Rectangle(90, 100, 20, 30);
    public Rectangle mouthArea = new Rectangle(60, 130, 80, 20);

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.LIGHT_GRAY);
        g2.fillOval(20, 20, 160, 160);

        g2.setColor(Color.BLACK);
        if (leftEyeClosed) {
            g2.drawLine(leftEyeArea.x, leftEyeArea.y + leftEyeArea.height / 2,
                    leftEyeArea.x + leftEyeArea.width, leftEyeArea.y + leftEyeArea.height / 2);
        } else {
            g2.fillOval(leftEyeArea.x, leftEyeArea.y, leftEyeArea.width, leftEyeArea.height);
        }

        if (rightEyeClosed) {
            g2.drawLine(rightEyeArea.x, rightEyeArea.y + rightEyeArea.height / 2,
                    rightEyeArea.x + rightEyeArea.width, rightEyeArea.y + rightEyeArea.height / 2);
        } else {
            g2.fillOval(rightEyeArea.x, rightEyeArea.y, rightEyeArea.width, rightEyeArea.height);
        }

        g2.setColor(noseColor);
        g2.fillOval(noseArea.x, noseArea.y, noseArea.width, noseArea.height);

        g2.setColor(Color.RED);
        if (smiling) {
            g2.drawArc(mouthArea.x, mouthArea.y, mouthArea.width, mouthArea.height, 180, 180);
        } else {
            g2.drawLine(mouthArea.x, mouthArea.y + mouthArea.height / 2,
                    mouthArea.x + mouthArea.width, mouthArea.y + mouthArea.height / 2);
        }
    }
}