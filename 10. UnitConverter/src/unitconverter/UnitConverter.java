package unitconverter;

import java.util.Scanner;

public class UnitConverter {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Please enter a value in feet: ");
        double feet = scanner.nextDouble();
        
        System.out.println(feet + " feet = " + feet / 5280 + " miles.");
        System.out.println(feet + " feet = " + feet / 3 + " yards.");
        System.out.println(feet + " feet = " + feet * 12 + " inches.");
        System.out.println(feet + " feet = " + feet * 143.997732 + " line.");
        
    }
    
}
