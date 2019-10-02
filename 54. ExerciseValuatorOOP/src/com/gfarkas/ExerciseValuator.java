package com.gfarkas;

public class ExerciseValuator {

    public static void main(String[] args) {

        PleaseEnter pleaseEnter = new PleaseEnter();
        int sizeOfTheClass = pleaseEnter.enterInt("Size of the class: ");

        Student[] students = new Student[sizeOfTheClass];

        System.out.println("------------------------------------");
        int maxScore = pleaseEnter.enterInt("The achievable maximum score: ");

        int sumOfMarks = 0;
        int mark = 0;

        for (int i = 1; i <= sizeOfTheClass; i++) {

            System.out.println("------------------------------------");
            System.out.println("");

            String name = pleaseEnter.enterString("Name of the student: ");

            int achievedPoints = pleaseEnter.enterInt("Points that " + name + " achieved: ");

            students[i - 1] = new Student(name, achievedPoints, maxScore);

            students[i - 1].display();

            sumOfMarks += students[i - 1].getMark();

        }

        System.out.println("------------------------------------");
        System.out.println("");
        double classAvarage = (double) sumOfMarks / sizeOfTheClass;

        evaluator.classEvaluator(classAvarage, sumOfMarks, sizeOfTheClass);

        for (int i = 1; i <= sizeOfTheClass; i++) {

            if (students[i - 1].getMark() > classAvarage) {

                System.out.println(students[i - 1].getName() + "'s mark is higher than avarage: " + students[i - 1].getMark());

            }

        }

    }

}
