package com.gfarkas;

/**
 *
 * @author Gabor Farkas <info@gfarkas.com>
 */
public class IsPrime {

    public boolean isPrime (int integerNumber) {
        
        // assuming that the number is prime
        boolean isPrime = true;
        
        for (int divider = 2; divider <= integerNumber / 2 && isPrime; divider++) {
            
            if (integerNumber % divider == 0 && divider != integerNumber && integerNumber != 2) {
                
                isPrime = false;
                
            }
            
        }
        
        return isPrime;
        
    }
    
}
