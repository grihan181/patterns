package org.example.lr3.observer;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Рожица");
        setSize(220, 240);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        FaceComponent faceComponent = new FaceComponent();
        FaceSubject subject = new FaceSubject();

        subject.addObserver(new EyeObserver(faceComponent));
        subject.addObserver(new NoseObserver(faceComponent));
        subject.addObserver(new MouthObserver(faceComponent));

        add(faceComponent);

        faceComponent.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                subject.notifyObservers(e.getX(), e.getY());
            }
        });
    }
}