
package com.gfarkas;

/**
 *
 * @author Gabor Farkas <info@gfarkas.com>
 */
public class FunctionDemo {

    public static int sum(int a, int b, int c) {
        
        int sum = a + b + c;
        
        return sum;
    }
    
    public static int arraySum(int[] array) {
        
        int sum = 0;
        
        for (int number : array) {
            
            sum += number;
            
        }
        
        return sum;
        
    }
         
    
    public static void main(String[] args) {
        
        System.out.println(sum(1,2,3));
        int[] numbers1 = {1,2,3,4,5};
        int[] numbers2 = {6,7,5,46,7};
        System.out.println(arraySum(numbers1));
        System.out.println(arraySum(numbers2));
        
    }

}
