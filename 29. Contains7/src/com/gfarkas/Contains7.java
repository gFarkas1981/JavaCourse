package com.gfarkas;

import java.util.Scanner;

/**
 *
 * @author Gabor Farkas <info@gfarkas.com>
 */
public class Contains7 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int positiveInteger = 0;
        boolean containsSeven = false;

        while (positiveInteger < 1) {

            try {

                scanner = new Scanner(System.in);
                System.out.println("");
                System.out.print("Please enter a positive integer number: ");
                positiveInteger = scanner.nextInt();

            } catch (Exception e) {

                System.out.println("That was not a positive integer number!");
                System.out.println("Exception: " + e);
                positiveInteger = 0;

            }

        }
        
        while (positiveInteger > 0) {

            if (positiveInteger % 10 == 7) {

                containsSeven = true;

            }

            positiveInteger /= 10;
            
        }
        
        System.out.println(
                containsSeven ?
                        "This number does contain the number '7'." :
                        "This number does not contain the number '7'.");

    }

}
