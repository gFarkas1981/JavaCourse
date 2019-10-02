package com.gfarkas;

public class PlanePoint {

    public static void main(String[] args) {

        Point A = new Point(0,0);
        Point B = new Point(1,0);
        Point C = new Point(0,1);

        Triangle t1 = new Triangle(new Point[] {A, B, C});

        System.out.println("Triangle's perimeter is " + t1.perimeter());
        System.out.println("Triangle's area is " + t1.area());

    }
}
