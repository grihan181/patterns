package org.example.lr4.mvc.view;

import lombok.Getter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

@Getter
public class FunctionView extends JFrame {

    private final JTable table;
    private final JButton addButton, removeButton;
    private final JTextField inputX;
    private final JComboBox<String> functionSelector;
    private final GraphPanel graphPanel;

    public FunctionView() {
        setTitle("График функций");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1920, 1090);
        setLayout(new BorderLayout());

        inputX = new JTextField(10);
        addButton = new JButton("Добавить X");
        removeButton = new JButton("Удалить значение");
        functionSelector = new JComboBox<>(new String[]{"sin(x)", "cos(x)", "x^2", "exp(x)", "log(x)"});

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("X:"));
        topPanel.add(inputX);
        topPanel.add(addButton);
        topPanel.add(removeButton);
        topPanel.add(new JLabel("Функция:"));
        topPanel.add(functionSelector);

        table = new JTable();
        table.setModel(new DefaultTableModel(new Object[][]{}, new String[]{"X", "Y"}));
        table.setCellSelectionEnabled(true);

        add(new JScrollPane(table), BorderLayout.WEST);

        graphPanel = new GraphPanel();
        add(graphPanel, BorderLayout.CENTER);
        add(topPanel, BorderLayout.NORTH);
    }

    public void updateTable(List<Double> xValues, List<Double> yValues) {
        String[][] data = new String[xValues.size()][2];
        for (int i = 0; i < xValues.size(); i++) {
            data[i][0] = String.valueOf(xValues.get(i));
            data[i][1] = String.valueOf(yValues.get(i));
        }
        table.setModel(new DefaultTableModel(data, new String[]{"X", "Y"}));
    }

    public void updateGraph(List<Double> xValues, List<Double> yValues) {
        graphPanel.setPoints(xValues, yValues);
        graphPanel.repaint();
    }

    private static class GraphPanel extends JPanel {
        private List<Double> xValues, yValues;

        public void setPoints(List<Double> x, List<Double> y) {
            this.xValues = x;
            this.yValues = y;
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int w = getWidth(), h = getHeight();
            int centerX = w / 2, centerY = h / 2;

            g2.setColor(new Color(240, 240, 240));
            g2.fillRect(0, 0, w, h);

            g2.setColor(new Color(200, 200, 200));
            for (int i = 0; i < w; i += 50) g2.drawLine(i, 0, i, h);
            for (int j = 0; j < h; j += 50) g2.drawLine(0, j, w, j);

            g2.setColor(Color.BLACK);
            g2.setStroke(new BasicStroke(2));
            g2.drawLine(0, centerY, w, centerY);
            g2.drawLine(centerX, 0, centerX, h);

            g2.setFont(new Font("Arial", Font.PLAIN, 10));
            for (int i = -w / 2; i <= w / 2; i += 50) {
                int x = centerX + i;
                g2.drawString(String.valueOf(i / 50), x + 2, centerY + 12);
            }
            for (int j = -h / 2; j <= h / 2; j += 50) {
                int y = centerY - j;
                if (j != 0) g2.drawString(String.valueOf(j / 50), centerX + 5, y - 2);
            }

            if (xValues == null || yValues == null || xValues.size() < 2) return;

            g2.setColor(new Color(66, 135, 245));
            g2.setStroke(new BasicStroke(2));

            for (int i = 0; i < xValues.size() - 1; i++) {
                int x1 = (int) (xValues.get(i) * 50) + centerX;
                int y1 = centerY - (int) (yValues.get(i) * 50);
                int x2 = (int) (xValues.get(i + 1) * 50) + centerX;
                int y2 = centerY - (int) (yValues.get(i + 1) * 50);
                g2.drawLine(x1, y1, x2, y2);
            }
        }
    }
}