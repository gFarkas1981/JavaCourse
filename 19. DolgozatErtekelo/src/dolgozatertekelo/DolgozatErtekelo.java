package dolgozatertekelo;

import java.util.Scanner;

public class DolgozatErtekelo {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Az osztály létszáma: ");
        int letszam = scanner.nextInt();
        System.out.println("------------------");
        System.out.println("Az elérhető maximális pontszám: ");
        int maxPont = scanner.nextInt();
        
        int jegyekOsszege = 0;
        int jegy = 0;
        
        for (int i = 1; i <= letszam; i++) {
            
            System.out.println("------------------");
            System.out.println("");
            System.out.println("Diák elért pontszáma: ");
            int elertPont = scanner.nextInt();
            
            double szazalek = (double) maxPont / 100 * elertPont;
                        
            if (szazalek < 20) {
                
                System.out.println("Elért eredmény: elégtelen.");
                jegy = 1;
                
            }else if (szazalek < 40) {
                
                System.out.println("Elért eredmény: elégséges.");
                jegy = 2;
                
            }else if (szazalek < 60) {
                
                System.out.println("Elért eredmény: közepes.");
                jegy = 3;
                
            }else if (szazalek < 60) {
                
                System.out.println("Elért eredmény: jó.");
                jegy = 4;
                
            }else if (szazalek < 80) {
                
                System.out.println("Elért eredmény: jeles.");
                jegy = 5;
                
            }
            
            jegyekOsszege += jegy;
            
        }
        
        System.out.println("");
        System.out.println("Osztályátlag: " + jegyekOsszege / letszam);
        
    }
    
}
