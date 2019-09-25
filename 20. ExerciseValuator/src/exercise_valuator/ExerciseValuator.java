package exercise_valuator;

import java.util.Scanner;

public class ExerciseValuator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Size of the class: ");
        int sizeOfTheClass = scanner.nextInt();

        int[] marks = new int[sizeOfTheClass];
        String[] names = new String[sizeOfTheClass];

        System.out.println("------------------------------------");
        System.out.println("The available maximum score: ");
        int maxScore = scanner.nextInt();

        int sumOfMarks = 0;
        int mark = 0;

        for (int i = 1; i <= sizeOfTheClass; i++) {

            System.out.println("------------------------------------");
            System.out.println("");
            System.out.println("Name of the student: ");

            scanner.nextLine();

            names[i - 1] = scanner.nextLine();

            System.out.println("Points that " + names[i - 1] + " achieved: ");

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

            marks[i - 1] = mark; // for loop starts from 1

            sumOfMarks += mark;

        }

        System.out.println("------------------------------------");
        System.out.println("");
        double classAvarage = (double) sumOfMarks / sizeOfTheClass;

        System.out.println("The class average is: " + classAvarage);

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

        for (int i = 1; i <= sizeOfTheClass; i++) {

            if (marks[i - 1] > classAvarage) {

                System.out.println(names[i - 1] + "'s mark is higher than avarage: " + marks[i - 1]);

            }

        }

    }

}
