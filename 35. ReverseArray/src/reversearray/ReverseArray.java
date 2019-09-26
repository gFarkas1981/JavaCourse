package reversearray;

import java.util.Scanner;

/**
 *
 * @author Gabor Farkas <info@gfarkas.com>
 */
public class ReverseArray {

    public static void main(String[] args) {
        
        double sum = 0;
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Please enter the length of the array: ");
        int length = scanner.nextInt();
        
        double[] numbers = new double[length];
        
        for (int i = 0; i < length; i++) {
            
            numbers[i] = scanner.nextDouble();
            sum += numbers[i];
        }
        
        System.out.println("The sum of the numbers is " + sum);
        
        for (int i = length - 1; i >= 0 ; i--) {
            
            System.out.println(numbers[i]);
            
        }
        
    }
    
}
