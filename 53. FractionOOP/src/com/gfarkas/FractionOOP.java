package com.gfarkas;

public class FractionOOP {

    public static void main(String[] args) {

        Fraction fraction1 = new Fraction(3,4);
        fraction1.getValue();
        System.out.print("fraction1 = ");
        fraction1.display();
        System.out.println("-------------------------------------------");

        Fraction fraction2 = new Fraction(1,3);
        fraction2.getValue();
        System.out.print("fraction2 = ");
        fraction2.display();
        System.out.println("-------------------------------------------");

        Fraction fraction3 = fraction1.multiply(fraction2);
        System.out.print("fraction1 X fraction2 = ");
        fraction3.display();
        System.out.println("-------------------------------------------");

        Fraction fraction4 = fraction1.divide(fraction2);
        System.out.print("fraction1 / fraction2 = ");
        fraction4.display();
        System.out.println("-------------------------------------------");

        Fraction fraction5 = fraction1.subtract(fraction2);
        System.out.print("fraction1 - fraction2 = ");
        fraction5.display();
        System.out.println("-------------------------------------------");

        Fraction fraction6 = fraction1.add(fraction2);
        System.out.print("fraction1 + fraction2 = ");
        fraction6.display();

    }
}
