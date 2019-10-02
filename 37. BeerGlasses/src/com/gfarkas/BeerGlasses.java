package com.gfarkas;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Gabor Farkas <info@gfarkas.com>
 */
public class BeerGlasses {

    public static void main(String[] args) {
      
        Random rnd = new Random();
        
        int[] beerGlasses1 = new int[7];
        int[] beerGlasses2 = {3, 5, 6, 9, 10, 8, 2};
        int[] beerGlasses3 = new int[7];
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many beers have you drank on ");
        
        for (int i = 0; i < 7; i++) {
            
            switch (i) {
                
                case 0: System.out.println("Monday: ");
                break;
                
                case 1: System.out.println("Tuesday: ");
                break;
                
                case 2: System.out.println("Wednesday: ");
                break;
                
                case 3: System.out.println("Thursday: ");
                break;
                
                case 4: System.out.println("Friday: ");
                break;
                
                case 5: System.out.println("Saturday: ");
                break;
                
                case 6: System.out.println("Sunday: ");
                break;
                
            }
            
            beerGlasses1[i] = scanner.nextInt();
            beerGlasses3[i] = rnd.nextInt(99) + 1;
        }
        
        for (int i = 0; i < 7; i++) {
            
            System.out.println("-------------------------------------------");
            
            switch (i) {
                
                case 0: 
                    System.out.println("On Monday you have drunk " + beerGlasses1[i] + " glasses of beer.");
                    System.out.println("On Monday I have drunk " + beerGlasses2[i] + " glasses of beer.");
                    System.out.println("On Monday he has drunk " + beerGlasses3[i] + " glasses of beer.");
                break;
                
                case 1: 
                    System.out.println("On Tuesday you have drunk " + beerGlasses1[i] + " glasses of beer.");
                    System.out.println("On Tuesday I have drunk " + beerGlasses2[i] + " glasses of beer.");
                    System.out.println("On Tuesday he has drunk " + beerGlasses3[i] + " glasses of beer.");
                break;
                
                case 2: 
                    System.out.println("On Wednesday you have drunk " + beerGlasses1[i] + " glasses of beer.");
                    System.out.println("On Wednesday I have drunk " + beerGlasses2[i] + " glasses of beer.");
                    System.out.println("On Wednesday he has drunk " + beerGlasses3[i] + " glasses of beer.");
                break;
                
                case 3: 
                    System.out.println("On Thursday you have drunk " + beerGlasses1[i] + " glasses of beer.");
                    System.out.println("On Thursday I have drunk " + beerGlasses2[i] + " glasses of beer.");
                    System.out.println("On Thursday he has drunk " + beerGlasses3[i] + " glasses of beer.");
                break;
                
                case 4: 
                    System.out.println("On Friday you have drunk " + beerGlasses1[i] + " glasses of beer.");
                    System.out.println("On Friday I have drunk " + beerGlasses2[i] + " glasses of beer.");
                    System.out.println("On Friday he has drunk " + beerGlasses3[i] + " glasses of beer.");
                break;
                
                case 5: 
                    System.out.println("On Saturday you have drunk " + beerGlasses1[i] + " glasses of beer.");
                    System.out.println("On Saturday I have drunk " + beerGlasses2[i] + " glasses of beer.");
                    System.out.println("On Saturday he has drunk " + beerGlasses3[i] + " glasses of beer.");
                break;
                
                case 6: 
                    System.out.println("On Sunday you have drunk " + beerGlasses1[i] + " glasses of beer.");
                    System.out.println("On Sunday I have drunk " + beerGlasses2[i] + " glasses of beer.");
                    System.out.println("On Sunday he has drunk " + beerGlasses3[i] + " glasses of beer.");
                break;
                
            }
            
        }
        
    }
    
}
