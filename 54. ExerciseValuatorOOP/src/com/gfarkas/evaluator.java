package com.gfarkas;

public class evaluator {

    public static void classEvaluator(double classAvarage, double sumOfMarks, int sizeOfTheClass) {

        System.out.println("The class average is: " + classAvarage);

        switch ((int) sumOfMarks / sizeOfTheClass) {

            case 1:
                System.out.println("Exceptionally poor.");
                break;

            case 2:
                System.out.println("Below average.");
                break;

            case 3:
                System.out.println("Avarage.");
                break;

            case 4:
                System.out.println("Above avarage.");
                break;

            default:
                System.out.println("Excelent.");

        }

    }

}
