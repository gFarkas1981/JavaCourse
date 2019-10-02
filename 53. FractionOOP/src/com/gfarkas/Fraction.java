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

        return fractionSimplifier(result);
    }

    public Fraction divide(Fraction divider) {

        Fraction result = new Fraction();

        result.numerator = numerator * divider.denominator;
        result.denominator= denominator * divider.numerator;

        return fractionSimplifier(result);

    }

    public Fraction subtract(Fraction substrahend) {

        Fraction result = new Fraction();

        int commonDenominator = denominator * substrahend.denominator;

        numerator *= substrahend.denominator;
        substrahend.numerator *= denominator;
        denominator = commonDenominator;
        substrahend.denominator = commonDenominator;

        result.numerator = numerator - substrahend.numerator;
        result.denominator = commonDenominator;

        return fractionSimplifier(result);

    }

    public Fraction add(Fraction substrahend) {

        Fraction result = new Fraction();

        int commonDenominator = denominator * substrahend.denominator;

        numerator *= substrahend.denominator;
        substrahend.numerator *= denominator;
        denominator = commonDenominator;
        substrahend.denominator = commonDenominator;

        result.numerator = numerator + substrahend.numerator;
        result.denominator = commonDenominator;

        return fractionSimplifier(result);

    }

    public Fraction fractionSimplifier(Fraction fraction) {

        int highestCommonFactor = 1;
        Fraction simplifiedFraction = new Fraction();
        int difference = Math.abs(fraction.denominator - fraction.numerator);

        if (fraction.denominator % difference == 0 && fraction.numerator % difference == 0) {

            highestCommonFactor = difference;

        } else {

            for (int i = 2; i < difference / 2; i++) {

                if (fraction.denominator % i == 0 && fraction.numerator % i == 0) {

                    highestCommonFactor = i;

                }

            }

        }


        simplifiedFraction.numerator = fraction.numerator / highestCommonFactor;
        simplifiedFraction.denominator = fraction.denominator / highestCommonFactor;

        return simplifiedFraction;

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
