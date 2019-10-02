package com.gfarkas;

/**
 *
 * @author Gabor Farkas <info@gfarkas.com>
 */
public class EvenNumbersInArray {

    public static void main(String[] args) {
        
        int[] numbers = {1, 95, 68, 67, 83, 107, 550};
        
        int[] evenNumbers = evenNumbersOnly(numbers);
        
        for (int evenNumber : evenNumbers) {
            
            System.out.println(evenNumber);
            
        }
        
    }
    
    public static int[] evenNumbersOnly (int[] numbers) {
        
        int counter = 0;
        
        for (int number : numbers) {
            
            if (number % 2 == 0) {
                
                counter++;
                
            }
            
        }
        
        int [] output = new int[counter];
        
        counter = 0;
        
        for (int number : numbers) {
            
            if (number % 2 == 0) {
                
                output[counter] = number;
                counter++;
                
            }
            
        }
        
        return output;
        
    }
    
}
