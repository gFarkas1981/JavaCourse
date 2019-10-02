package com.gfarkas;

public class FractionOOP {

    public static void main(String[] args) {

        Fraction fraction1 = new Fraction(3,4);
            fraction1.setDenominator(0);
//        fraction1.numerator = 3;
//        fraction1.denominator = 4;
        fraction1.getValue();
        System.out.print("fraction1 = ");
        fraction1.display();

        Fraction fraction2 = new Fraction(1,3);
//        fraction2.numerator = 1;
//        fraction2.denominator = 3;
        fraction2.getValue();
        System.out.print("fraction2 = ");
        fraction2.display();

        Fraction fraction3 = fraction1.multiply(fraction2);
        System.out.print("fraction1 / fraction2 = ");
        fraction3.display();

    }
}
