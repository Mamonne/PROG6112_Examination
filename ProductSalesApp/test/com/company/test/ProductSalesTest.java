/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
  package com.company.test;

/**
 *
 * @author PC
 */
public class ProductSalesTest {
    



    
    public void GetSalesOverLimit_ReturnsNumberOfSales() {
        // Arrange
        double[][] sales = {
            {300, 150, 700}, // Year 1
            {250, 200, 600}  // Year 2
        };
        double limit = 500;
        ProductSales ps = new ProductSales(sales, limit);

        // Act
        int result = ps.getSalesOverLimit();

        // Assert
        // 700 and 600 are over 500 → expected 2
        assertEquals(2, result, "Expected 2 sales over limit");
    }

    
    public void GetSalesUnderLimit_ReturnsNumberOfSales() {
        // Arrange
        double[][] sales = {
            {300, 150, 700}, // Year 1
            {250, 200, 600}  // Year 2
        };
        double limit = 500;
        ProductSales ps = new ProductSales(sales, limit);

        // Act
        int result = ps.getSalesUnderLimit();

        // Assert
        // 300,150,250,200 are under/equal → expected 4
        assertEquals(4, result, "Expected 4 sales under limit");
    }

    private void assertEquals(int i, int result, String expected_4_sales_under_limit) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}


