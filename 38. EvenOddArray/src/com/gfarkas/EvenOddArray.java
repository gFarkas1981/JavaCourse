package com.gfarkas;

/**
 *
 * @author Gabor Farkas <info@gfarkas.com>
 */
public class EvenOddArray {
    
    public static int[] countEvenOdd(int[] inputArray) {
        
        int even = 0;
        int odd = 0;
        
        for (int number : inputArray) {
            
            if (number % 2 == 0) {
                
                even++;
                
            } else {
                
                odd++;
                
            }
            
        }
        
        return new int[] {even,odd};
        
    }
    
    public static int[][] evenOddFromArray(int[] inputArray, int nrOfEven, int nrOfOdd) {
        
        int evenCounter = 0;
        int oddCounter = 0;
        
        int[] evenArray = new int[nrOfEven];
        int[] oddArray = new int[nrOfOdd];
        
        for (int number : inputArray) {
            
            if (number % 2 == 0) {
                
                evenArray[evenCounter] = number;
                evenCounter++;
                
            } else {
                
                oddArray[oddCounter] = number;
                oddCounter++;
                
            }
            
        }
        
        int[][] outputArray = new int[][]{evenArray,oddArray};
        
        return outputArray;
        
    }

    public static void main(String[] args) {
        
        int[] numbers = {13, 25, 36, 48, 17, 99};
        
        int[] evenOddCount = countEvenOdd(numbers);
        
        int even = evenOddCount[0];
        int odd = evenOddCount[1];;        
        
        int[][] evenAndOdd = evenOddFromArray(numbers, even, odd);
        
        int[] evenArray = evenAndOdd[0];
        int[] oddArray = evenAndOdd[1];
        
        System.out.print("Even numbers:  ");
        
        for (int i : evenArray) {
            
            System.out.print(i + "  ");
            
        }
        
        System.out.println("");
        
        
        System.out.print("Odd numbers:  ");
        
        for (int i : oddArray) {
            
            System.out.print(i + "  ");
            
        }
        
        System.out.println("");
        
    }
    
}
