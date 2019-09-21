package nembeszelektobbetcsunyan;

import java.util.Scanner;

public class NemBeszelekTobbetCsunyan {


    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kérem adja meg, hányszor írjam ki: ");
        
        int darab = scanner.nextInt();
        
        for (int i = 1; i <= darab; i++) {
            
            System.out.println(i + ". Nem beszélek többet csúnyán!");
            
        }
        
    }
    
}
