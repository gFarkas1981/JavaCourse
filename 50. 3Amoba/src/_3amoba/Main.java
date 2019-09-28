package _3amoba;

import java.util.Scanner;

/**
 *
 * @author Gabor Farkas <info@gfarkas.com>
 */
public class Main {

    public static void soutArray(int[] inputArray) {

        for (int element : inputArray) {

            System.out.print(element + " ");

        }

    }

    public static void clearTable(String[][] table) {

        for (int i = 0; i < table.length; i++) {

            for (int j = 0; j < table[i].length; j++) {

                table[i][j] = " ";

            }

        }

    }

    public static boolean arrayContains(int[] inputArray, int number) {

        boolean contains = false;

        for (int i = 0; i < inputArray.length && !contains; i++) {

            if (inputArray[i] == number) {

                contains = true;

            }

        }

        return contains;

    }

    public static void drawTable(String[][] table) {

        System.out.println("    1   2   3 ");
        System.out.println("  +---+---+---+");
        System.out.println("A | " + table[0][0] + " | " + table[0][1] + " | " + table[0][2] + " |");
        System.out.println("  +---+---+---+");
        System.out.println("B | " + table[1][0] + " | " + table[1][1] + " | " + table[1][2] + " |");
        System.out.println("  +---+---+---+");
        System.out.println("C | " + table[2][0] + " | " + table[2][1] + " | " + table[2][2] + " |");
        System.out.println("  +---+---+---+");
        System.out.println("");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[][] table = new String[3][3];
        String player = "X";

        clearTable(table);
        drawTable(table);
        int row = -1;
        int column = -1;
        System.out.println("Please enter the next step: (ie.: A2)");
        String step = scanner.nextLine();
        String s1 = step.substring(0, 1);
        String s2 = step.substring(1);

        switch (s1.toLowerCase()) {

            case "a":
                row = 0;
                break;

            case "b":
                row = 1;
                break;

            case "c":
                row = 2;
                break;
                
        }
        
        column = Integer.parseInt(s2);

        table[row][column] = "X";
        drawTable(table);

    }

}
