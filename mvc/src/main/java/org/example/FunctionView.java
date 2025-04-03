package org.example;

import lombok.Data;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.*;

@Data
public class FunctionView extends JFrame {
    private FunctionModel model;
    private JTable table;
    private ChartPanel chartPanel;
    private JTextField xInputField;
    private JButton addButton, removeButton, editButton;

    public FunctionView(FunctionModel model) {
        this.model = model;
        initializeUI();
    }

    private void initializeUI() {
        setTitle("MVC Pattern lab4");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        table = new JTable() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 0;
            }
        };
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.WEST);

        chartPanel = new ChartPanel(null);
        add(chartPanel, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        xInputField = new JTextField(10);
        addButton = new JButton("Добавить");
        removeButton = new JButton("Удалить Выбранный");
        editButton = new JButton("Изменить выбранный");

        controlPanel.add(new JLabel("x:"));
        controlPanel.add(xInputField);
        controlPanel.add(addButton);
        controlPanel.add(removeButton);
        controlPanel.add(editButton);

        add(controlPanel, BorderLayout.NORTH);

        updateView();
    }

    public TableModel getTableModel() {
        return table.getModel();
    }

    public void updateView() {
        DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"x", "y"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 0;
            }
        };

        for (int i = 0; i < model.getXValues().size(); i++) {
            double x = model.getXValues().get(i);
            double y = model.getYValues().get(i);
            tableModel.addRow(new Object[]{x, y});
        }
        table.setModel(tableModel);

        // Обновление графика
        XYSeries series = new XYSeries("y = f(x)");
        for (int i = 0; i < model.getXValues().size(); i++) {
            series.add(model.getXValues().get(i), model.getYValues().get(i));
        }
        XYSeriesCollection dataset = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory.createXYLineChart("y = f(x)", "x", "y", dataset);
        chartPanel.setChart(chart);

        table.getModel().addTableModelListener(e -> {
            int row = e.getFirstRow();
            int column = e.getColumn();
            if (column == 0) {
                try {
                    double x = Double.parseDouble(table.getModel().getValueAt(row, column).toString());
                    model.updateValue(row, x);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(table, "Неверное значение x.");
                }
                updateView();
            }
        });

        validate();
        repaint();
    }
}