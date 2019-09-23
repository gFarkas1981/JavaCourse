package divisors;

import java.util.Scanner;

public class Divisors {

    public static void main(String[] args) {
      
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Please enter an integer: ");
        int number = scanner.nextInt();
        int divisor = 2;
        int divisorCounter = 1;
        
        System.out.println("1. divisor of the number is: 1");
        
        for (int i = 2; i <= number / 2; i++) {
            
            if (number % i == 0) {
                
                divisor++;
                divisorCounter++;
                System.out.println(divisorCounter + ". divisor of the number is: " + i);
                
            }
            
        }
        
        System.out.println(++divisorCounter + ". divisor of the number is: " + number);
        
    }
    
}
