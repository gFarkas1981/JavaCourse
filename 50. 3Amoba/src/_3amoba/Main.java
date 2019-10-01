package _3amoba;

import java.util.Scanner;

/**
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

    public static void drawTable(String[][] table) {

        System.out.println("    1   2   3 ");
        System.out.println("  +---+---+---+");
        System.out.println("A | " + table[0][0] + " | " + table[0][1] + " | " + table[0][2] + " |");
        System.out.println("  +---+---+---+");
        System.out.println("B | " + table[1][0] + " | " + table[1][1] + " | " + table[1][2] + " |");
        System.out.println("  +---+---+---+");
        System.out.println("C | " + table[2][0] + " | " + table[2][1] + " | " + table[2][2] + " |");
        System.out.println("  +---+---+---+");
        System.out.println();
    }

    public static int[] nextStep() {

        int row = -1;
        int column = -1;
        String s1 = "";
        String s2 = "";

        while (s1.equals("") || s2.equals("")) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the next step: (ie.: A2)");
            String step = scanner.nextLine();

            if (step.length() < 1 || step.length() > 2) {

                s1 = "";
                System.out.println("One character and one integer, please!");

            } else {

                s1 = step.substring(0, 1);
                s2 = step.substring(1);


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

                    default:
                        s1 = "";
                        System.out.println("Wrong row character!");

                }

                try {

                    column = Integer.parseInt(s2);

                } catch (Exception e) {

                    s2 = "";
                    System.out.println("Wrong column number!");
                }

                if (!s1.equals("") && (column < 1 || column > 3)) {

                    s2 = "";
                    System.out.println("Wrong column number!");

                }

            }

        }

        return new int[]{row, column};

    }

    public static int checkMove(String[][] table, int[] nextMove) {
        // if return = 0; valid
        // if return = 1; invalid;
        // if return = 2; "X" won
        // if return = 3; "O" won
        // if return = 4; draw

        if (table[nextMove[0]][nextMove[1] - 1].equals("X") ||
                table[nextMove[0]][nextMove[1] - 1].equals("O")) {

            return 1;

        }

        for (int i = 0; i < 3; i++) {

            if ((table[i][0].equals("X") &&     // X X X
                    table[i][1].equals("X") &&
                    table[i][2].equals("X"))
                    ||
                    (table[0][i].equals("X") &&             // X
                            table[1][i].equals("X") &&      // X
                            table[2][i].equals("X"))        // X
                    ||
                    (table[0][0].equals("X") &&             // X
                            table[1][1].equals("X") &&      //  X
                            table[2][2].equals("X"))        //   X
                    ||
                    (table[0][2].equals("X") &&             //   X
                            table[1][1].equals("X") &&      //  X
                            table[2][0].equals("X"))) {     // X
                return 2;

            }

        }

        for (int i = 0; i < 3; i++) {

            if ((table[i][0].equals("O") &&     // X X X
                    table[i][1].equals("O") &&
                    table[i][2].equals("O"))
                    ||
                    (table[0][i].equals("O") &&             // X
                            table[1][i].equals("O") &&      // X
                            table[2][i].equals("O"))        // X
                    ||
                    (table[0][0].equals("O") &&             // X
                            table[1][1].equals("O") &&      //  X
                            table[2][2].equals("O"))        //   X
                    ||
                    (table[0][2].equals("O") &&             //   X
                            table[1][1].equals("O") &&      //  X
                            table[2][0].equals("O"))) {     // X
                return 3;

            }

        }


        return 0;

    }

    public static void main(String[] args) {

        String[][] table = new String[3][3];
        String player = "X";

        clearTable(table);
        drawTable(table);

        for (int i = 0; i < 9; i++) {

            int[] nextMove = nextStep();
            int phase = checkMove(table, nextMove);

            if (phase == 2) {

                System.out.println("'X' won the game. Congratulations!");
                System.exit(0);

            }

            if (phase == 3) {

                System.out.println("'O' won the game. Congratulations!");
                System.exit(0);

            }


            while (phase == 1) {

                System.out.println("Invalid move!");
                drawTable(table);
                nextMove = nextStep();
                phase = checkMove(table, nextMove);

            }

            table[nextMove[0]][nextMove[1] - 1] = player;
            drawTable(table);

            if (player.equals("X")) {

                player = "O";

            } else {

                player = "X";

            }

        }

    }

}
