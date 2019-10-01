package three_amoba;

import java.util.Scanner;

/**
 * @author Gabor Farkas <info@gfarkas.com>
 */
public class Main {

    private static int xPoints = 0;
    private static int oPoints = 0;

    private static void horizontalLine() {

        System.out.println("-------------------------------------------------------------");

    }

    private static void clearTable(String[][] table) {

        for (int i = 0; i < table.length; i++) {

            for (int j = 0; j < table[i].length; j++) {

                table[i][j] = " ";

            }

        }

    }

    private static void drawTable(String[][] table) {
        final String hLine = "  +---+---+---+";

        System.out.println("    1   2   3 ");
        System.out.println(hLine);
        System.out.println("A | " + table[0][0] + " | " + table[0][1] + " | " + table[0][2] + " |");
        System.out.println(hLine);
        System.out.println("B | " + table[1][0] + " | " + table[1][1] + " | " + table[1][2] + " |");
        System.out.println(hLine);
        System.out.println("C | " + table[2][0] + " | " + table[2][1] + " | " + table[2][2] + " |");
        System.out.println(hLine);
        System.out.println();
    }

    public static String stringScanner(String text) {

        Scanner scanner = new Scanner(System.in);
        System.out.println(text);

        return scanner.nextLine();

    }

    public static String stringScanner(char player) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("'" + player + "' please enter the next step: (ie.: A2)");

        return scanner.nextLine();

    }

    private static int[] nextStep(char player) {

        int row = -1;
        int column = -1;
        String s1 = "";
        String s2 = "";

        while (s1.equals("") || s2.equals("")) {

            String step = stringScanner(player);

            if (step.length() < 1 || step.length() > 2) {

                s1 = "";
                horizontalLine();
                System.out.println("One character and one integer, please!");
                horizontalLine();

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
                        horizontalLine();
                        System.out.println("Wrong row character!");
                        horizontalLine();

                }

                try {

                    column = Integer.parseInt(s2);

                } catch (Exception e) {

                    s2 = "";
                    horizontalLine();
                    System.out.println("Wrong column number!");
                    horizontalLine();
                }

                if (!s1.equals("") && !s2.equals("") && (column < 1 || column > 3)) {

                    s2 = "";
                    horizontalLine();
                    System.out.println("Wrong column number!");
                    horizontalLine();

                }

            }

        }

        return new int[]{row, column};

    }

    private static int exsOrOs(String[][] table) {

        // if returns 0 -> not yet won
        // if returns 1 -> "X" won
        // if returns 2 -> "O" won

        char xPerO = 'X';

        for (int j = 0; j < 2; j++) {

            if (j == 1) {
                xPerO = 'O';
            }

            for (int i = 0; i < 3; i++) {

                if ((table[i][0].charAt(0) == xPerO &&     // X X X
                        table[i][1].charAt(0) == xPerO &&
                        table[i][2].charAt(0) == xPerO)
                        ||
                        (table[0][i].charAt(0) == xPerO &&             // X
                                table[1][i].charAt(0) == xPerO &&      // X
                                table[2][i].charAt(0) == xPerO)        // X
                        ||
                        (table[0][0].charAt(0) == xPerO &&             // X
                                table[1][1].charAt(0) == xPerO &&      //  X
                                table[2][2].charAt(0) == xPerO)        //   X
                        ||
                        (table[0][2].charAt(0) == xPerO &&             //   X
                                table[1][1].charAt(0) == xPerO &&      //  X
                                table[2][0].charAt(0) == xPerO)) {     // X
                    return j + 1;

                }

            }

        }

        return 0;

    }

    private static boolean isValid(String[][] table, int[] nextMove) {
        // if returns true -> valid
        return (table[nextMove[0]][nextMove[1] - 1].charAt(0) == ' ');

    }

    private static String[][] startGame() {

        String[][] table = new String[3][3];

        clearTable(table);
        drawTable(table);

        return table;

    }

    public static void scoreDisplay() {

        horizontalLine();
        System.out.println("'X's score: " + xPoints);
        System.out.println("'O's score: " + oPoints);
        horizontalLine();

    }

    private static void game(String[][] table) {

        char player = 'X';

        for (int i = 0; i < 9; i++) {

            if (exsOrOs(table) == 1) {

                horizontalLine();
                System.out.println("'X' won the game. Congratulations!");
                horizontalLine();
                xPoints += 2;
                return;

            } else if (exsOrOs(table) == 2) {

                horizontalLine();
                System.out.println("'O' won the game. Congratulations!");
                horizontalLine();
                oPoints += 2;
                return;

            }

            int[] nextMove = nextStep(player);

            while (!isValid(table, nextMove)) {

                horizontalLine();
                System.out.println("Invalid move!");
                horizontalLine();
                drawTable(table);
                nextMove = nextStep(player);

            }

            table[nextMove[0]][nextMove[1] - 1] = String.valueOf(player);
            drawTable(table);

            if (player == 'X') {

                player = 'O';

            } else {

                player = 'X';

            }

        }

        horizontalLine();
        System.out.println("All right then, we'll call it a draw!");
        horizontalLine();
        xPoints++;
        oPoints++;

    }

    private static boolean wannaPlay() {

        boolean wrongAnswer = true;
        boolean newGame = false;


        while (wrongAnswer) {

            horizontalLine();
            String answer = stringScanner("Do you want to play another game? (y/n)");
            horizontalLine();

            if (answer.equalsIgnoreCase("y")) {

                newGame = true;
                wrongAnswer = false;

                for (int i = 0; i < 20 ; i++) {

                    horizontalLine();

                }

            } else wrongAnswer = !answer.equalsIgnoreCase("n");

        }

        return newGame;

    }

    public static void main(String[] args) {

        boolean newGame;

        do {

            String[][] table = startGame();

            game(table);

            scoreDisplay();

            newGame = wannaPlay();

        } while (newGame);

    }

}
