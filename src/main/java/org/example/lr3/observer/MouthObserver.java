package org.example.lr3.observer;

public class MouthObserver implements FaceObserver {
    private final FaceComponent face;

    public MouthObserver(FaceComponent face) {
        this.face = face;
    }

    @Override
    public void update(int x, int y) {
        if (face.mouthArea.contains(x, y)) {
            face.smiling = !face.smiling;
            face.repaint();
        }
    }
}