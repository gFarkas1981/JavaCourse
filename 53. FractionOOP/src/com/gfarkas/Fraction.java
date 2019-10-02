package com.gfarkas;

public class Fraction {

    private int numerator;
    private int denominator;

    public Fraction() {
    }

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;

        setDenominator(denominator);

    }

    public void display() {

        System.out.println(numerator + " / " + denominator + " = " +getValue());

    }

    public double getValue() {

        return numerator / (double) denominator;

    }

    public Fraction multiply(Fraction multiplier) {

        Fraction result = new Fraction();

        result.numerator = numerator * multiplier.numerator;
        result.denominator = denominator * multiplier.denominator;

        return result;
    }

    public Fraction divide(Fraction divider) {

        Fraction result = new Fraction();

        result.numerator = numerator / divider.numerator;
        result.denominator= denominator * divider.denominator;

        return result;

    }


    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {

        if (denominator == 0) {

            denominator++;
            System.out.println("Denominator could not be zero, changed to 1!");

        }

        this.denominator = denominator;

    }
}
