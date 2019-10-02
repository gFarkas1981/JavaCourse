package com.gfarkas;

import java.util.Scanner;

public class FibonacciChristmasTree {

    public static void main(String[] args) {

        int precedingTwo = 0;
        int precedingOne = 1;
        int fibonacci = 1;
        // A Fibonacci number is simply the sum of the two preceding numbers
        int treeLevel = 0;
        // The first level of the tree is    *
        //                                  * *
        
        Scanner scanner = new Scanner(System.in);
        
        while (treeLevel < 1 || treeLevel > 9) {
        // We don't have enough space on console to print out more than 9 level
        
            try {
                //  trying to get an integer number between 1 and 9
                System.out.println("Please enter the levels of the tree: (1-9)");
                treeLevel = scanner.nextInt();
            
            } catch (Exception e) {
                
                System.out.println("That was not an integer number, I presume!");
                System.out.println("Exception: " + e);
                System.out.println("Setting levels of the tree to default... (5)");
                treeLevel = 5;
            }
            
        }
        
        // Iterating through the levels of the tree (Fibonacci numbers from 2)
        for (int m = 1; m <= treeLevel; m++) {

            precedingTwo = precedingOne;
            precedingOne = fibonacci;
            fibonacci = precedingTwo + precedingOne;
            // finding out the new Fibonacci number

            for (int i = 1; i <= fibonacci; i++) {

                // depending on treeLevel and the number of the star(s)
                // we need to add space before the star(s)
                for (int space = 10 * treeLevel - i; space > 0; space--) {

                    System.out.print(" ");

                }
                
                // adding the stars to the actual row
                for (int j = 0; j < i; j++) {

                    System.out.print(" *");

                }
                // jump to the next row
                System.out.println("");

            }

        }
    }

}
