package whiledemo;

import java.util.Scanner;

public class WhileDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        
        
        int mark;
        
        do {
            
            System.out.println("Please enter a mark: ");
            mark = sc.nextInt();
        
        } while (mark < 1 || mark > 5);
        
        System.out.println("That's an existing mark");

    }

}
