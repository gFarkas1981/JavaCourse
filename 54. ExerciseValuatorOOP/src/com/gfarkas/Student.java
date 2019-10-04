package com.gfarkas;

public class Student {

    private String name;
    private int mark;
    private int achievedScore;

    public Student() {}

    public Student(String name, int achievedScore) {
        this.name = name;
        this.achievedScore = achievedScore;
    }

    public Student(String name, int achievedScore, int maxScore) {

        this.name = name;

        if (achievedScore > maxScore) {

            achievedScore = maxScore;

        }

        this.achievedScore = achievedScore;

        evaluator(maxScore);

    }



    public void evaluator(int maxScore) {

        double rate = (double) achievedScore / maxScore * 100;

        if (rate < 20) {

            System.out.println("Exceptionally poor.");
            mark = 1;

        } else if (rate < 40) {

            System.out.println("Below average.");
            mark = 2;

        } else if (rate < 60) {

            System.out.println("Average.");
            mark = 3;

        } else if (rate < 80) {

            System.out.println("Above avarage.");
            mark = 4;

        } else {

            System.out.println("Excelent.");
            mark = 5;

        }

    }

    public void display() {

        System.out.println(name + "'s mark is: "
                + mark + " and the achieved score is "
                + achievedScore);

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

    public void setMark(int mark) {
        this.mark = mark;
    }

    public int getAchievedScore() {
        return achievedScore;
    }

    public void setAchievedScore(int achievedScore) {
        this.achievedScore = achievedScore;
    }
}
