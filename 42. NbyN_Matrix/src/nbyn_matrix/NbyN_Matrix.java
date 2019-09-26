package nbyn_matrix;

import java.util.Scanner;

/**
 *
 * @author Gabor Farkas <info@gfarkas.com>
 */
public class NbyN_Matrix {


    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter an integer: ");
        
        int n = scanner.nextInt();
        
        System.out.println("");
        
        int[][] matrix = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            
            matrix[i][i] = 1;
            
        }
        
        for (int i = 0; i < n; i++) {
            
            for (int j = 0; j < n; j++) {
                
                System.out.print(matrix[i][j]);
                
            }
            
            System.out.println("");
            
        }
        
    }
    
}
