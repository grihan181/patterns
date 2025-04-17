package org.example.lr3.observer;

public class EyeObserver implements FaceObserver {
    private final FaceComponent face;

    public EyeObserver(FaceComponent face) {
        this.face = face;
    }

    @Override
    public void update(int x, int y) {
        if (face.leftEyeArea.contains(x, y)) {
            face.leftEyeClosed = !face.leftEyeClosed;
            face.repaint();
        } else if (face.rightEyeArea.contains(x, y)) {
            face.rightEyeClosed = !face.rightEyeClosed;
            face.repaint();
        }
    }
}