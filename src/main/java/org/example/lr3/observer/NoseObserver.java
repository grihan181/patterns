package org.example.lr3.observer;

import java.awt.*;

public class NoseObserver implements FaceObserver {
    private final FaceComponent face;

    public NoseObserver(FaceComponent face) {
        this.face = face;
    }

    @Override
    public void update(int x, int y) {
        if (face.noseArea.contains(x, y)) {
            face.noseColor = new Color((float) Math.random(), (float) Math.random(), (float) Math.random());
            face.repaint();
        }
    }
}