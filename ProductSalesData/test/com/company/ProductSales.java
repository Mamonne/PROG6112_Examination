/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
 package com.company;
/**
 *
 * @author PC
 */
public class ProductSales {
    


    private final double[][] sales;

    public ProductSales(double[][] sales) {
        this.sales = sales;
    }

    /**
     * Calculates the total sales for all years and all products.
     */
    public double totalSales() {
        double total = 0;
        for (double[] yearSales : sales) {
            for (double value : yearSales) {
                total += value;
            }
        }
        return total;
    }

    /**
     * Calculates the average sales value for all years and all products.
     */
    public double averageSales() {
        double total = 0;
        int count = 0;
        for (double[] yearSales : sales) {
            for (double value : yearSales) {
                total += value;
                count++;
            }
        }
        return count == 0 ? 0 : total / count;
    }
}


