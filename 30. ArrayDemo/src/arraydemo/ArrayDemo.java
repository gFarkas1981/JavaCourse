package arraydemo;

/**
 *
 * @author Gabor Farkas <info@gfarkas.com>
 */
public class ArrayDemo {

    public static void main(String[] args) {

            
        int[] numbers = {23,1,98,45,12,6,24};
        
        int sum = 0;
        int min = numbers[0];
        int max = numbers[0];
        
        for (int number : numbers) {
            
            System.out.println(number);
            
            sum += number;
            
            if (number < min) {
                
                min = number;
                
            }
            
            if (number > max) {
                
                max = number;
                
            }
            
        }
        
        System.out.println("Sum: " + sum);
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
        
    }
    
}
