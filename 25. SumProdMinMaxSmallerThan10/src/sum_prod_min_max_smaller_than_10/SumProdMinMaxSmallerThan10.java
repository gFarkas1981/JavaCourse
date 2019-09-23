package sum_prod_min_max_smaller_than_10;

import java.util.Scanner;

/**
 *
 * @author Gabor Farkas <info@gfarkas.com>
 */
public class SumProdMinMaxSmallerThan10 {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        double sum = 0;
        double product = 1;
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        int smallerThanTen = 0;

        while (n < 1) {

            try {

                scanner = new Scanner(System.in);
                System.out.println("");
                System.out.print("Please enter a positive integer number: ");
                n = scanner.nextInt();

            } catch (Exception e) {

                System.out.println("That was not a positive integer number!");
                System.out.println("Exception: " + e);
                n = 0;

            }

        }
        
        double values[] = new double[n];
        
        for (int i = 0; i < n; i++) {
            
            try {

                scanner = new Scanner(System.in);
                System.out.println("");
                System.out.print("Please enter a double: ");
                values[i] = scanner.nextDouble();

            } catch (Exception e) {

                System.out.println("That was not a duoble!");
                System.out.println("Exception: " + e);
               
            }

        }
        
        for (double value : values) {
            
            sum += value;
            product *= value;
            
            if (value < min) {
                
                min = value;
                
            }
            
            if (value > max) {
                
                max = value;
                
            }
            
            if (value < 10.0) {
                
                smallerThanTen++;
                
            }
            
        }
        
        System.out.println("");
        System.out.println("--------------------------------");
        System.out.println("Sum of values: " + sum);
        System.out.println("Product of values: " + product);
        System.out.println("Smallest value: " + min);
        System.out.println("Greatest value: " + max);
        
        if (smallerThanTen == 0) {
            
            System.out.println("There was no value which was smaller than 10.");
        
        } else if (smallerThanTen == 1) {
            
            System.out.println("There was only one value which was smaller than 10.");
            
        } else {
            
            System.out.println("There were " + smallerThanTen + " values which were smaller than 10.");
            
        }
        
    }
    
}
