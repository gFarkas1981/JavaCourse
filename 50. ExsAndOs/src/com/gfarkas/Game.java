package com.gfarkas;

import com.gfarkas.ExsAndOs;

class Game {

    StringScanner stringScanner = new StringScanner();

    private Player p1 = new Player();
    private Player p2 = new Player();

    void game(String[][] table, boolean isFirstGame) {

        ExsOrOs exsOrOsOs = new ExsOrOs();
        HorizontalLine horizontalLine = new HorizontalLine();
        NextStep nextStep = new NextStep();
        DrawTable drawTable = new DrawTable();
        IsValid isValid = new IsValid();

        p1.setActual(true);

        if (isFirstGame) {

            p1.setSymbol('X');
            p1.setPoints(0);
            p1.setName(stringScanner.stringScanner("Please enter the first player's name: "));

            p2.setSymbol('O');
            p2.setPoints(0);
            p2.setName(stringScanner.stringScanner("Please enter the second player's name: "));

        }

        for (int i = 0; i < 9; i++) {

            char actualSymbol;

            if (p1.isActual()) {

                actualSymbol = p1.getSymbol();

            } else {

                actualSymbol = p2.getSymbol();

            }

            if (exsOrOsOs.exsOrOs(table) == 1) {

                horizontalLine.horizontalLine();
                System.out.println(p1.getName() + " won the game. Congratulations!");
                horizontalLine.horizontalLine();
                p1.setPoints(p1.getPoints() + 2);
                return;

            } else if (exsOrOsOs.exsOrOs(table) == 2) {

                horizontalLine.horizontalLine();
                System.out.println(p2.getName() + " won the game. Congratulations!");
                horizontalLine.horizontalLine();
                p2.setPoints(p2.getPoints() + 2);
                return;

            }


            int[] nextMove = nextStep.nextStep(p1.isActual() ? p1.getName() : p2.getName());

            while (!isValid.isValid(table, nextMove)) {

                horizontalLine.horizontalLine();
                System.out.println("Invalid move!");
                horizontalLine.horizontalLine();
                drawTable.drawTable(table);
                nextMove = nextStep.nextStep(p1.isActual() ? p1.getName() : p2.getName());

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
