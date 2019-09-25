package drawer;

import java.util.Scanner;

public class Drawer {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Please enter a number: ");
        
        int number = scanner.nextInt();
        
        for (int i = 0; i < number; i++) {
            
           for (int k = 0; k < number; k++) {
               
               System.out.print("* ");
               
           } 
            System.out.println("");
          
            
        }
        
    }
    
}
