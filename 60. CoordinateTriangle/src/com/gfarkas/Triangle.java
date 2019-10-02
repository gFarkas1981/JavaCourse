package com.gfarkas;

public class Triangle {

    private Point[] trianglePoints;

    public Triangle(Point[] trianglePoints) {
        this.trianglePoints = trianglePoints;
    }

    private double[] lengths() {

        double a = trianglePoints[0].distance(trianglePoints[1]);
        double b = trianglePoints[1].distance(trianglePoints[2]);
        double c = trianglePoints[2].distance(trianglePoints[0]);

        return new double[]{a,b,c};
    }

    public double perimeter() {

       double[] lengths = lengths();

       return lengths[0] + lengths[1] + lengths[2];

    }

    public double area() {

        double s = perimeter() / 2;
        double[] lengths = lengths();
        double a = lengths[0];
        double b = lengths[1];
        double c = lengths[2];

        return Math.sqrt(s * (s - a) * (s - b) * (s - c));

    }

    public Point[] getTrianglePoints() {
        return trianglePoints;
    }

    public void setTrianglePoints(Point[] trianglePoints) {
        this.trianglePoints = trianglePoints;
    }
}
