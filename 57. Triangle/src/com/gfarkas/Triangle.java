package com.gfarkas;

public class Triangle {

    private int a;
    private int b;
    private int c;

    public Triangle() {
    }

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public boolean isValid() {

        return (this.a + this.b > this.c && this.a + this.c > this.b && this.b + this.c > this.a);

    }

    public double area() {

        double s = (this.a + this.b + this.c) / (double) 2;

        return Math.sqrt(s*(s - this.a)*(s - this.b) * (s - this.c));

    }

    public int perimeter() {

        return this.a + this.b + this.c;

    }

    public void display() {

        if (isValid()) {

            System.out.println("Area of the triangle: " + this.area());
            System.out.println("Perimeter of the triangle: " + this.perimeter());

        } else {

            System.out.println("Can't be edited!");

        }



    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }
}
