//Calculate the average temperature, and give how many days are above the average temperature
//  1. Take an input from the user (eg 5)
//  2. Prompt the user to enter all the 5 numbers (temperature values)
//  3. Calculate the average temperature
//  4. Given the average temperature, how many of the numbers in the line 2 are above the average temperature?
package Arrays;

import java.util.Scanner;

public class TempAssignment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking User Input //
        System.out.print("Enter How Many Days Are You Tracking: ");
        int numDays = scanner.nextInt();

        // Storing Temperatures Locally //
        double[] temperatures = new double[numDays];

        // Taking Users Temperate Values //
        System.out.println("Enter the temperatures for " + numDays + " days:");
        for (int i = 0; i < numDays; i++) {
            System.out.print("Day " + (i + 1) + ": ");
            temperatures[i] = scanner.nextDouble();
        }

        // Calculating The Average Temperature //
        double sum = 0;
        for (double temp : temperatures) {
            sum += temp;
        }
        double average = sum / numDays;
        System.out.printf("The Average Temperature is %.2f%n", average);

        // Determining How Many Days Are Above Temperature //
        int aboveAverageCount = 0;
        for (double temp : temperatures) {
            if (temp > average) {
                aboveAverageCount++;
            }
        }
        System.out.println("Number Of Days Above Temperature: " + aboveAverageCount);
        scanner.close();
    }
}
