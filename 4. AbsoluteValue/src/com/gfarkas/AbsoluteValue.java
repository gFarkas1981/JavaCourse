package com.gfarkas;

import java.util.Scanner;

public class AbsoluteValue {

   public static void main(String[] args) {
     
       Scanner sc = new Scanner(System.in);
       double number;
       
       System.out.println("Please enter a number: ");
       number = sc.nextDouble();
       
       if (number < 0) {
           
           number *= -1.0;
           
       } 
    
       System.out.println("The absolute value of the number is " + number);
       
    }
}
