package com.gfarkas;

import java.util.Scanner;

public class PerfectNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int possiblePerfect = 0;
        int sumOfDivisors = 0;

        while (possiblePerfect < 1) {

            try {

                scanner = new Scanner(System.in);
                System.out.println("");
                System.out.print("Please enter a positive integer number: ");
                possiblePerfect = scanner.nextInt();

            } catch (Exception e) {

                System.out.println("That was not a positive integer number!");
                System.out.println("Exception: " + e);
                possiblePerfect = 0;

            }

        }
        
        for (int i = 1; i <= possiblePerfect / 2; i++) {
            
            if (possiblePerfect % i == 0) {
                
                sumOfDivisors += i;
                
            }
            
            if (sumOfDivisors > possiblePerfect) break;
            
        }
        
        if (sumOfDivisors == possiblePerfect) {
            
            System.out.println(possiblePerfect + " is a perfect number!");
            
        } else {
            
            System.out.println(possiblePerfect + " is not a perfect number!");
            
        }           

    }

}
