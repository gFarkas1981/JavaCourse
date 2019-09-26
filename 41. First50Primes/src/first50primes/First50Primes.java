package first50primes;

/**
 *
 * @author Gabor Farkas <info@gfarkas.com>
 */
public class First50Primes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int[] first50Primes = new int[50];
        IsPrime isPrime = new IsPrime();
        int primeCounter = 0;
        int possiblePrime = 2;
        
        while (primeCounter < 50) {
            
            if (isPrime.isPrime(possiblePrime)) {
                
                first50Primes[primeCounter] = possiblePrime;
                primeCounter++;    
                
            } 
            
            possiblePrime++;            
            
        }
        
        System.out.println("First Fifty primes: ");
        
        for (int i = 0; i < first50Primes.length; i++) {
            
            System.out.println((i + 1) + ". prime: " + first50Primes[i]);
            
        }
        
    }
    
}
