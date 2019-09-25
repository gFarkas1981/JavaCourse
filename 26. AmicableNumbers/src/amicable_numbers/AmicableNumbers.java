package amicable_numbers;

import java.util.Scanner;

public class AmicableNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int friend1yOne = 0;
        int friendlyTwo = 0;
        int sumOfDivisorsOne = 0;
        int sumOfDivisorsTwo = 0;

        while (friend1yOne < 1) {

            try {

                scanner = new Scanner(System.in);
                System.out.println("");
                System.out.print("Please enter the first positive integer number: ");
                friend1yOne = scanner.nextInt();

            } catch (Exception e) {

                System.out.println("That was not a positive integer number!");
                System.out.println("Exception: " + e);
                friend1yOne = 0;

            }

        }
        
        while (friendlyTwo < 2) {

            try {

                scanner = new Scanner(System.in);
                System.out.println("");
                System.out.print("Please enter the second positive integer number: ");
                friendlyTwo = scanner.nextInt();

            } catch (Exception e) {

                System.out.println("That was not a positive integer number!");
                System.out.println("Exception: " + e);
                friendlyTwo = 0;

            }

        }
        
        int biggerOne = friend1yOne;
        
        if (friend1yOne < friendlyTwo) {
            
            biggerOne = friendlyTwo;
            
        }
        
        for (int i = 1; i <= biggerOne / 2; i++) {
            
            if (friend1yOne % i == 0) {
                
                sumOfDivisorsOne += i;
                
            }
            
            if (friendlyTwo % i == 0) {
                
                sumOfDivisorsTwo += i;
                
            }
                
        }
        
        if (sumOfDivisorsOne == friendlyTwo && sumOfDivisorsTwo == friend1yOne) {
            
            System.out.println(friend1yOne + " and " + friendlyTwo + " are amicable numbers.");
            return;
        } 
        
            System.out.println(friend1yOne + " and " + friendlyTwo + " are not amicable numbers.");
       
    }

}

