package com.gfarkas.model;

import java.io.Serializable;

public class Student {


    private int reachedPoint;
    private String name;
    private int mark;

    public Student() {
    }

    public Student(int reachedPoint, String name) {
        this.reachedPoint = reachedPoint;
        this.name = name;
    }

    public Student(int reachedPoint, String name, int maxPoint) {
        this.reachedPoint = reachedPoint;
        this.name = name;
        calcMark(maxPoint);
    }

    public void calcMark(int maxPoint) {

        double rate = (double) reachedPoint / maxPoint * 100;

        if (rate < 20) {

            mark = 1;

        } else if (rate < 40) {

            mark = 2;

        } else if (rate < 60) {

            mark = 3;

        } else if (rate < 80) {

            mark = 4;

        } else  {

            mark = 5;

        }


    }

    public void display() {

        System.out.println(name + "'s mark is: "
                + mark +
                " Reached point: "
                + reachedPoint);

    }

    public int getReachedPoint() {
        return reachedPoint;
    }

    public void setReachedPoint(int reachedPoint) {
        this.reachedPoint = reachedPoint;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMark() {
        return mark;
    }

}
