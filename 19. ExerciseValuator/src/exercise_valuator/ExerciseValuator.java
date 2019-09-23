package exercise_valuator;

import java.util.Scanner;

public class ExerciseValuator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Size of the class: ");
        int sizeOfTheClass = scanner.nextInt();
        System.out.println("------------------------------------");
        System.out.println("The available maximum score: ");
        int maxScore = scanner.nextInt();

        int sumOfMarks = 0;
        int mark = 0;

        for (int i = 1; i <= sizeOfTheClass; i++) {

            System.out.println("------------------------------------");
            System.out.println("");
            System.out.println("Points that" + " student " + i + " achieved: ");

            int achievedPoints = scanner.nextInt();

            if (achievedPoints > maxScore) {
                achievedPoints = maxScore;
            }

            double rate = achievedPoints / (double) maxScore * 100;

            System.out.println(i + ". student's rate is " + String.format("%.2f", rate) + "%");

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

            sumOfMarks += mark;

        }

        System.out.println("------------------------------------");
        System.out.println("");
        System.out.println("The class average is: " + (double) sumOfMarks / sizeOfTheClass);

        switch (sumOfMarks / sizeOfTheClass) {

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
