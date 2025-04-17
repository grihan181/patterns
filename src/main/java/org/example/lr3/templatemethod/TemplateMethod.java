package org.example.lr3.templatemethod;

import javax.swing.SwingUtilities;

public class TemplateMethod {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }
}