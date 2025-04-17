package org.example.lr3.observer;

import java.util.ArrayList;
import java.util.List;

public class FaceSubject {
    private final List<FaceObserver> observers = new ArrayList<>();

    public void addObserver(FaceObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers(int x, int y) {
        for (FaceObserver observer : observers) {
            observer.update(x, y);
        }
    }
}