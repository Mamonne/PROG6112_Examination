/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package productsalesdata;

/**
 *NAME:MAMONNE MOTAUNG
 * STUDENT NUMBER:ST10485613
 * 
 */
public class ProductSalesReport {

    /**
     * @param args the command line arguments
     */
    
        

    public static void main(String[] args) {
        // Sales data: Each row is a year, each column is a quarter
        double[][] sales = {
            {300, 150, 700}, // Year 1
            {250, 200, 600}  // Year 2
        };

        // Display sales data
        System.out.println("=== Product Sales Data (in units) ===");
        for (int i = 0; i < sales.length; i++) {
            System.out.print("Year " + (i + 1) + ": ");
            for (int j = 0; j < sales[i].length; j++) {
                System.out.print(sales[i][j] + (j < sales[i].length - 1 ? ", " : ""));
            }
            System.out.println();
        }

        // Arrays to hold yearly totals and averages
        double[] yearlyTotal = new double[sales.length];
        double[] yearlyAverage = new double[sales.length];

        // Calculate total and average for each year
        for (int i = 0; i < sales.length; i++) {
            double sum = 0;
            for (int j = 0; j < sales[i].length; j++) {
                sum += sales[i][j];
            }
            yearlyTotal[i] = sum;
            yearlyAverage[i] = sum / sales[i].length;
        }

        // Calculate overall total, average, max, and min
        double overallTotal = 0;
        double maxSales = sales[0][0];
        double minSales = sales[0][0];
        int count = 0;

        for (int i = 0; i < sales.length; i++) {
            for (int j = 0; j < sales[i].length; j++) {
                overallTotal += sales[i][j];
                count++;
                if (sales[i][j] > maxSales) maxSales = sales[i][j];
                if (sales[i][j] < minSales) minSales = sales[i][j];
            }
        }

        double overallAverage = overallTotal / count;

        // Display report
        System.out.println("\n=== Product Sales Report ===");
        for (int i = 0; i < sales.length; i++) {
            System.out.printf("Year %d Total Sales: %.2f\n", i + 1, yearlyTotal[i]);
            System.out.printf("Year %d Average Sales: %.2f\n\n", i + 1, yearlyAverage[i]);
        }

        System.out.printf("Overall Total Sales (2 years): %.2f\n", overallTotal);
        System.out.printf("Overall Average Sales: %.2f\n", overallAverage);
        System.out.printf("Maximum Quarterly Sales: %.2f\n", maxSales);
        System.out.printf("Minimum Quarterly Sales: %.2f\n", minSales);
    }
}

    
    

