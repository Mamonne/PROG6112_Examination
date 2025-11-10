/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.test;

import com.company.ProductSales;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author PC
 */
public class ProductSalesTest {
    
    public void CalculateTotalSales_ReturnsTotalSales() {
        // Arrange
        double[][] salesData = {
            {300, 150, 700}, // Year 1
            {250, 200, 600}  // Year 2
        };
        ProductSales productSales = new ProductSales(salesData);

        // Act
        double total = productSales.totalSales();

        // Assert
        // Expected: 300+150+700+250+200+600 = 2200
        assertEquals(2200.0, total, 0.001, "Total sales should equal 2200.0");
    }

    
    public void AverageSales_ReturnsAverageProductSales() {
        // Arrange
        double[][] salesData = {
            {300, 150, 700}, // Year 1
            {250, 200, 600}  // Year 2
        };
        ProductSales productSales = new ProductSales(salesData);

        // Act
        double avg = productSales.averageSales();

        // Assert
        // Expected average = 2200 / 6 = 366.67
        assertEquals(366.67, avg, 0.01, "Average sales should be approximately 366.67");
    }

    private void assertEquals(double d, double total, double d0, String total_sales_should_equal_22000) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

