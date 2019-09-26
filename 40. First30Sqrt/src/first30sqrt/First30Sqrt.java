package first30sqrt;

/**
 *
 * @author Gabor Farkas <info@gfarkas.com>
 */
public class First30Sqrt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Square root of the first thirty integers
        double[] squareRoots = new double [30];
        
        for (int i = 1; i <=30; i++) {
            
            squareRoots[i - 1] = Math.sqrt(i);
            
        }
        
        for (int i = 0; i < squareRoots.length; i++) {
            
            System.out.println("Square root of "+ (i + 1) + ": " +squareRoots[i]);
            
        }
        
    }
    
}
