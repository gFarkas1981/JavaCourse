package between2numbers;

import java.util.Scanner;

public class Between2Numbers {

    public static void main(String[] args) {
        
        int sum = 0;
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Please enter the first number: ");
        int firstNumber = scanner.nextInt();
        
        System.out.print("Please enter the second number: ");
        int secondNumber = scanner.nextInt();
        
        if (firstNumber < secondNumber) {
            
            for (int i = firstNumber + 1; i < secondNumber; i++) {
                
                System.out.println(i);
                sum += i;
                
            }
            
            System.out.println("Sum of the numbers between "+ firstNumber 
                    + " and " + secondNumber + " is " + sum + ".");
            
        } else {
            
            for (int i = secondNumber + 1; i < firstNumber; i++) {
                
                System.out.println(i);
                sum += i;
                
            }
        
            System.out.println("Sum of the numbers between "+ secondNumber 
                    + " and " + firstNumber + " is " + sum + ".");
            
        }     
        
    }
    
}
