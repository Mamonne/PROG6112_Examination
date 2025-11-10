/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package productsalesapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
/**
 *NAME:MAMONNE MOTAUNG
 * ST10485613
 * @author PC
 */
 public class ProductSalesGUI extends JFrame {

    /**
     * @param args the command line arguments
     */
   
       
    private JTextArea textArea;
    private JLabel yearsLabel;
    private final double SALES_LIMIT = 500.0;

    // Product Sales Data (Year, Product, Sales)
    private final String[][] products = {
        {"Microphone", "Speakers", "Mixing Desk"},
        {"Microphone", "Speakers", "Mixing Desk"}
    };

    private final double[][] sales = {
        {300, 150, 700}, // Year 1
        {250, 200, 600}  // Year 2
    };

    public ProductSalesGUI() {
        super("Product Sales Data - Sound Equipment Retailer");
        setLayout(new BorderLayout());
        setSize(500, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // --- Menu Bar ---
        JMenuBar menuBar = new JMenuBar();

        // File Menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);

        // Tools Menu
        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem loadItem = new JMenuItem("Load Product Data");
        JMenuItem saveItem = new JMenuItem("Save Product Data");
        JMenuItem clearItem = new JMenuItem("Clear");

        loadItem.addActionListener(e -> loadProductData());
        saveItem.addActionListener(e -> saveProductData());
        clearItem.addActionListener(e -> clearData());

        toolsMenu.add(loadItem);
        toolsMenu.add(saveItem);
        toolsMenu.add(clearItem);
        menuBar.add(toolsMenu);

        setJMenuBar(menuBar);

        // --- Text Area ---
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        // --- Bottom Panel ---
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton loadButton = new JButton("Load Product Data");
        JButton saveButton = new JButton("Save Product Data");
        yearsLabel = new JLabel("Years Processed: ");

        loadButton.addActionListener(e -> loadProductData());
        saveButton.addActionListener(e -> saveProductData());

        bottomPanel.add(loadButton);
        bottomPanel.add(saveButton);
        bottomPanel.add(new JLabel(" | "));
        bottomPanel.add(yearsLabel);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void loadProductData() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Product Sales Data ===\n");

        double grandTotal = 0;
        double max = sales[0][0];
        double min = sales[0][0];
        int overLimitCount = 0;
        int underLimitCount = 0;
        int years = sales.length;

        for (int year = 0; year < sales.length; year++) {
            sb.append("\nYear ").append(year + 1).append(":\n");
            double yearlyTotal = 0;

            for (int prod = 0; prod < sales[year].length; prod++) {
                double value = sales[year][prod];
                yearlyTotal += value;
                grandTotal += value;

                if (value > max) max = value;
                if (value < min) min = value;

                if (value > SALES_LIMIT) overLimitCount++;
                else underLimitCount++;

                sb.append(String.format("  %-12s : %.2f\n", products[year][prod], value));
            }

            double avg = yearlyTotal / sales[year].length;
            sb.append(String.format("  Year %d Total : %.2f\n", year + 1, yearlyTotal));
            sb.append(String.format("  Year %d Average : %.2f\n", year + 1, avg));
        }

        double overallAverage = grandTotal / (sales.length * sales[0].length);

        sb.append("\n=== Summary ===\n");
        sb.append(String.format("Overall Total Sales : %.2f\n", grandTotal));
        sb.append(String.format("Overall Average Sales : %.2f\n", overallAverage));
        sb.append(String.format("Maximum Sale : %.2f\n", max));
        sb.append(String.format("Minimum Sale : %.2f\n", min));
        sb.append(String.format("Sales Over Limit (%.2f) : %d\n", SALES_LIMIT, overLimitCount));
        sb.append(String.format("Sales Under Limit (%.2f) : %d\n", SALES_LIMIT, underLimitCount));

        textArea.setText(sb.toString());
        yearsLabel.setText("Years Processed: " + years);
    }

    private void saveProductData() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt"))) {
            writer.write(textArea.getText());
            JOptionPane.showMessageDialog(this, "Data saved successfully to data.txt");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving data: " + e.getMessage());
        }
    }

    private void clearData() {
        textArea.setText("");
        yearsLabel.setText("Years Processed: ");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ProductSalesGUI app = new ProductSalesGUI();
            app.setVisible(true);
        });
    }
}
    
    

