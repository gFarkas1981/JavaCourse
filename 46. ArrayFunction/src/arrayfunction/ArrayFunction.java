package arrayfunction;

/**
 *
 * @author info
 */
public class ArrayFunction {

    public static int arraySum(int[] array) {
        
        int sum = 0;
        
        for (int number : array) {
            
            sum += number;
            
        }
        
        return sum;
        
    }
    
    public static double arrayAvarage(int[] array) {
          
        return (double) arraySum(array)/ array.length;
        
    }
    
    public static int arrayMin(int[] array) {
        
        int min = array[0];
        
        for (int element : array) {
            
            if (element < min) {
                
                min = element;
                
            }
            
        }
        
        return min;
        
    }
    
    public static int arrayMax(int[] array) {
        
        int max = array[0];
        
        for (int element : array) {
            
            if (element > max) {
                
                max = element;
                
            }
            
        }
        
        return max;
        
    }
    
    public static boolean arrayContains(int[] array, int number) {
        
        for (int element : array) {
            
            if (element == number) {
                
                return true;
                
            }
            
        }
        
        return false;
        
    }
    
    public static int[] reverseArray(int[] inputArray) {
        
        int [] outputArray= new int[inputArray.length];
        
        for (int i = inputArray.length - 1; i >= 0; i--) {
            
            outputArray[inputArray.length - i-1] = inputArray[i];
            
        }
        
        return outputArray;
        
    }
   
    public static void main(String[] args) {
       
        int[] numbers = {1, 2, 3, 6, 23, 9, 17, 21, 53};
        
        System.out.println("Sum of the elements of the array: " + arraySum(numbers));
        System.out.println("The avarage value of the array: " + arrayAvarage(numbers));
        System.out.println("The maximum value of the array: " + arrayMax(numbers));
        System.out.println("The minimum value of the array: " + arrayMin(numbers));
        
        int number = 23;
        System.out.println("Does the array contain the number " + number + "? " + arrayContains(numbers, number));
        System.out.print("The array in reverse order: ");
        int [] reversed = reverseArray(numbers);
        
        for (int element : reversed) {
            
            System.out.print(element + " ");
            
        }
        System.out.println("");
            
        }
        
        
    }
    
}
