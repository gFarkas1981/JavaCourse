package com.gfarkas;

/**
 *
 * @author Gabor Farkas <info@gfarkas.com>
 */
public class CopyElementsOfArray {

    public static void main(String[] args) {
        
        int[] numbers = {1,3,7,43,12,98};
        
        double[] doubles = new double[numbers.length + 1];
        
        double d = 2.4;
        
        for (int i = 0; i < numbers.length; i++) {
            
            if (i < 3) {
            
                doubles[i] = numbers[i];
                
            } else {
                
                doubles[i + 1] = numbers[i];
                
            }
        }
        
        doubles[3] = d;
        
        for (double aDouble : doubles) {
            
            System.out.println(aDouble);
            
        }
        
    }
    
}
