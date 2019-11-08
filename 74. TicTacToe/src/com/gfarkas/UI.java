package com.gfarkas;

import java.util.Scanner;

public class UI {

    private Game game = new Game();
    private Scanner scanner = new Scanner(System.in);

    public void start() {

        String answer = "";

        while (!validYesNo(answer)) {

            System.out.println("Do you want to play with computer? (y/n)");
            answer = scanner.nextLine();

        }

        if (answer.equalsIgnoreCase("y")) {

            System.out.println("Please enter your name: ");
            String p1Name = scanner.nextLine();
            game.startGame(p1Name);

        } else {
            System.out.println("Please enter the first player's name: ");
            String p1Name = scanner.nextLine();
            System.out.println("Please enter the second player's name: ");
            String p2Name = scanner.nextLine();
            game.startGame(p1Name, p2Name);

        }

        boolean isFirstRound = true;

        while (isFirstRound || playAgain()) {

            while (!game.isGameOver()) {

                game.makeMove(nextStep());

            }

            isFirstRound = false;

        }

    }

    private boolean validYesNo(String yesNo) {

        return (yesNo.equalsIgnoreCase("y") ||
                yesNo.equalsIgnoreCase("n"));

    }

    private boolean playAgain() {

        String answer = "";

        while (!validYesNo(answer)) {

            System.out.println("Do you want to play another game? (y/n)");
            answer = scanner.nextLine();

        }

        return answer.equalsIgnoreCase("y");

    }

    private int nextStep() {

        String actualPlayer = game.getActualPlayersName();

        int node = -1;
        int row = -1;
        int column = -1;
        String s1 = "";
        String s2 = "";

        if (game.isHumanActualPlayer()) {

            while (s1.equals("") || s2.equals("")) {

                System.out.println(actualPlayer + " please enter the next step: (ie.: A1 to C3)");
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

                            System.out.println("Wrong row character!");
                            s1 = "";

                    }

                    try {

                        column = Integer.parseInt(s2);

                    } catch (Exception e) {

                        s2 = "";


                        System.out.println("Wrong column number!");

                    }

                    if (!s1.equals("") && !s2.equals("") && (column < 1 || column > 3)) {

                        s2 = "";

                        System.out.println("Wrong column number!");


                    }

                }

            }

        } else {

            return game.findBestMove();
            //return game.cpuMove();

        }

        switch ("" + row + column) {

            case "01":
                node = 0;
                break;

            case "02":
                node = 1;
                break;

            case "03":
                node = 2;
                break;

            case "11":
                node = 3;
                break;

            case "12":
                node = 4;
                break;

            case "13":
                node = 5;
                break;

            case "21":
                node = 6;
                break;

            case "22":
                node = 7;
                break;

            case "23":
                node = 8;
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + s1.toLowerCase() + (column - 1));
        }

        return node;

    }

}
