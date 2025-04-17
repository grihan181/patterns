package org.example.lr3.templatemethod;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private final ShapePanel panel = new ShapePanel();

    public MainFrame() {
        setTitle("Template Method Animation");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        add(panel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton startBallBtn = new JButton("Пуск: Мяч");
        JButton startSquareBtn = new JButton("Пуск: Квадрат");
        JButton startStarBtn = new JButton("Пуск: Звезда");
        JButton exitBtn = new JButton("Закрыть");

        buttonPanel.add(startBallBtn);
        buttonPanel.add(startSquareBtn);
        buttonPanel.add(startStarBtn);
        buttonPanel.add(exitBtn);

        add(buttonPanel, BorderLayout.SOUTH);

        startBallBtn.addActionListener(e -> panel.addShape(new Ball(panel)));
        startSquareBtn.addActionListener(e -> panel.addShape(new Square(panel)));
        startStarBtn.addActionListener(e -> panel.addShape(new Star(panel)));
        exitBtn.addActionListener(e -> System.exit(0));
    }
}