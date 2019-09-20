package abszolutertek;

import java.util.Scanner;

public class AbszolutErtek {

   public static void main(String[] args) {
     
       Scanner sc = new Scanner(System.in);
       int szam;
       System.out.println("Kérem adjon meg egy egész számot: ");
       szam = sc.nextInt();
       
       if (szam > 0) {
           
           System.out.println("Az abszolútértéke: " + szam);
           
       } else {
       
            System.out.println("A szám abszolútértéke: " + (szam * - 1));
       
       }
    
    }
}
