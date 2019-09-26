package evenoddarray;

/**
 *
 * @author Gabor Farkas <info@gfarkas.com>
 */
public class EvenOddArray {

    public static void main(String[] args) {
        
        int[] numbers = {13, 25, 36, 48, 17, 99};
        int even = 0;
        int odd = 0;
        
        for (int number : numbers) {
            
            if (number % 2 == 0) {
                
                even++;
                
            } else {
                
                odd++;
                
            }
            
        }
        
        int[] evenArray = new int [even];
        int[] oddArray = new int [odd];
        
        even = 0;
        odd = 0;
        
        for (int number : numbers) {
            
            if (number % 2 == 0) {
                
                evenArray[even] = number;
                even++;
                
            } else {
                
                oddArray[odd] = number;
                odd++;
                
            }
            
        }
        
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
