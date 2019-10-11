package com.gfarkas;

import java.util.Random;

class Game {

    StringScanner stringScanner = new StringScanner();

    private Player p1 = new Player();
    private Player p2 = new Player();
    private boolean validAnswer;

    void game(String[][] table, boolean isFirstGame) {

        ExsOrOs exsOrOs = new ExsOrOs();
        HorizontalLine horizontalLine = new HorizontalLine();
        NextStep nextStep = new NextStep();
        DrawTable drawTable = new DrawTable();
        IsValid isValid = new IsValid();
        ValidYesNo validYesNo = new ValidYesNo();
        p2.setHuman(true);

        while (!validAnswer) {

            new HorizontalLine();
            String answer = stringScanner.stringScanner("Do you want to play with computer? (y/n)");
            new HorizontalLine();

            validAnswer = validYesNo.validYesNo(answer);

            if (answer.equalsIgnoreCase("y") && validAnswer) {

                p2.setHuman(false);

            }

        }

        p1.setActual(true);
        p1.setSymbol('X');
        p1.setPoints(0);

        if (isFirstGame && p2.isHuman()) {

            p1.setName(stringScanner.stringScanner("Please enter the first player's name: "));

            p2.setSymbol('O');
            p2.setPoints(0);
            p2.setName(stringScanner.stringScanner("Please enter the second player's name: "));

        } else {

            p1.setName(stringScanner.stringScanner("Please enter your name: "));
            p1.setActual(true);

            p2.setSymbol('O');
            p2.setPoints(0);
            p2.setName("Computer");

        }

        for (int i = 0; i < 9; i++) {

            char actualSymbol;

            if (p1.isActual()) {

                actualSymbol = p1.getSymbol();

            } else {

                actualSymbol = p2.getSymbol();

            }

            if (exsOrOs.exsOrOs(table) == 1) {

                horizontalLine.horizontalLine();
                System.out.println(p1.getName() + " won the game. Congratulations!");
                horizontalLine.horizontalLine();
                p1.setPoints(p1.getPoints() + 2);
                return;

            } else if (exsOrOs.exsOrOs(table) == 2 && p2.isHuman()) {

                horizontalLine.horizontalLine();
                System.out.println(p2.getName() + " won the game. Congratulations!");
                horizontalLine.horizontalLine();
                p2.setPoints(p2.getPoints() + 2);
                return;

            } else if (exsOrOs.exsOrOs(table) == 2) {

                horizontalLine.horizontalLine();
                System.out.println(p2.getName() + " won the game. I am terribly sorry!");
                horizontalLine.horizontalLine();
                p2.setPoints(p2.getPoints() + 2);
                return;

            }

            int[] nextMove = {0, 1};

            if ((p2.isHuman() && p2.isActual()) || p1.isActual()) {

                nextMove = nextStep.nextStep((p1.isActual() ? p1.getName() : p2.getName()));

                while (!isValid.isValid(table, nextMove)) {

                    horizontalLine.horizontalLine();
                    System.out.println("Invalid move!");
                    horizontalLine.horizontalLine();
                    drawTable.drawTable(table);
                    nextMove = nextStep.nextStep(p1.isActual() ? p1.getName() : p2.getName());

                }

            } else {

                while (!isValid.isValid(table, nextMove)) {

                    Random random = new Random();
                    nextMove = new int[]{random.nextInt(3), random.nextInt(2) + 1};

                }


            }

            table[nextMove[0]][nextMove[1] - 1] = String.valueOf(actualSymbol);
            drawTable.drawTable(table);

            if (p1.isActual()) {

                p2.setActual(true);
                p1.setActual(false);

            } else {

                p1.setActual(true);
                p2.setActual(false);

            }

        }

        horizontalLine.horizontalLine();
        System.out.println("All right then, we'll call it a draw!");
        horizontalLine.horizontalLine();
        p1.setPoints(p1.getPoints() + 1);
        p2.setPoints(p2.getPoints() + 1);

    }

    protected void scoreDisplay() {

        new HorizontalLine();
        System.out.println(p1.getName() + "'s score: " + p1.getPoints());
        System.out.println(p2.getName() + "'s score: " + p2.getPoints());
        new HorizontalLine();

    }

}
