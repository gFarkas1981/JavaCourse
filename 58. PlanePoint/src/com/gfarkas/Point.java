package com.gfarkas;

public class Point {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void display() {

        System.out.println("This point's X coordinate is " + this.x);
        System.out.println("This point's Y coordinate is " + this.y);
        System.out.println("This point's distance from the origo is " + this.distance());

    }

    public double distance() {

//        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
        return distance(new Point(0, 0));

    }

    public double distance(Point p) {

        int pointX = p.getX();
        int pointY = p.getY();

        return Math.sqrt(Math.pow((pointX - this.x), 2) + Math.pow((pointY - this.y), 2));

    }

    public Point offset(Point p) {

        return new Point((this.x + p.x), this.y + p.y);

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


}
