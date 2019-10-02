package com.gfarkas;

public class PlanePoint {

    public static void main(String[] args) {

        Point p1 = new Point(4, 5);
        Point p2 = new Point(-1, 3);

        p1.display();


        System.out.println("The distance of the two points is " + p1.distance(p2));

        Point offsetedPoint = p1.offset(p2);
        System.out.println("The new point's coordinates after the offset operation: X{"
                + offsetedPoint.getX() + "} ; Y{" + offsetedPoint.getY() + "}.");



    }
}
