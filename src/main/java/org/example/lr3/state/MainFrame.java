package org.example.lr3.state;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        setTitle("Human State");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        HumanContext context = new HumanContext();
        HumanComponent human = new HumanComponent(context);

        JPanel buttonPanel = new JPanel();
        JButton semesterButton = new JButton("Семестр");
        JButton vacationButton = new JButton("Каникулы");
        JButton examButton = new JButton("Сессия");

        semesterButton.addActionListener(e -> {
            context.setState(new SleepingState());
            human.repaint();
        });

        vacationButton.addActionListener(e -> {
            context.setState(new HappyState());
            human.repaint();
        });

        examButton.addActionListener(e -> {
            context.setState(new SadState());
            human.repaint();
        });

        buttonPanel.add(semesterButton);
        buttonPanel.add(vacationButton);
        buttonPanel.add(examButton);

        add(human, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}