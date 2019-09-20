package cube;

import java.util.Scanner;

public class Cube {
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Please enter the length of an edge of a cube: ");
        
        double edge = scanner.nextDouble();
        
        System.out.println("The cube's surface area: " + (6*edge*edge));
        
        System.out.println("The cube's volume: " + (edge*edge*edge));

    }
    
}
