package teglalapkt;

import java.util.Scanner;

public class TeglalapKT {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Kérem a téglalap a oldalát: ");
        double a = sc.nextDouble();
        System.out.print("Kérem a téglalap b oldalát: ");
        double b = sc.nextDouble();
        
        double t = a * b;
        
        System.out.println("Terület: " + t);
        System.out.println("Kerület: " + 2*(a + b));
        
    }
    
}
