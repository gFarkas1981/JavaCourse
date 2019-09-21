package whiledemo;

import java.util.Scanner;

public class WhileDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        
        
        int osztalyzat;
        
        do {
            
            System.out.println("Kérem, adjon meg egy osztályzatot: ");
            osztalyzat = sc.nextInt();
        
        } while (osztalyzat < 1 || osztalyzat > 5);
        
        System.out.println("Ez egy helyes osztályzat!");

    }

}
