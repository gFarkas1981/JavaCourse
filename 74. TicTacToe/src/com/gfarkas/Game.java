package com.gfarkas;

import java.util.Arrays;

public class Game {

    private Node[] nodes = new Node[9];
    private Node[] cpuTable;
    private Player p1 = new Player();
    private Player p2 = new Player();
    private Player actualPlayer;

    public Game() {

        newGame();

    }

    public String getActualPlayersName() {

        return actualPlayer.getName();

    }

    public void startGame(String p1Name) {

        p1 = new Player(p1Name, "X", true);
        p2 = new Player("CPU", "O", false);
        actualPlayer = p1;

    }

    public void startGame(String p1Name, String p2Name) {

        p1 = new Player(p1Name, "X", true);
        p2 = new Player(p2Name, "O", true);
        actualPlayer = p1;

    }

    public boolean isGameOver() {

        if (hasWon(p1.getSymbol(), nodes)) {

            System.out.println(p1.getName() + " has won the game!");
            p1.increasePoints(2);
            displayScore();
            newGame();
            actualPlayer = p1;
            return true;

        }

        if (hasWon(p2.getSymbol(), nodes)) {

            System.out.println(p2.getName() + " has won the game!");
            p2.increasePoints(2);
            displayScore();
            newGame();
            actualPlayer = p2;
            return true;

        }

        if (fullTable(nodes)) {

            System.out.println("All right then, we'll call it a draw!");
            p1.increasePoints(1);
            p2.increasePoints(1);
            displayScore();
            newGame();
            actualPlayer = p1;
            return true;

        }

        return false;

    }

    private boolean hasWon(String symbol, Node[] nodes) {

        for (int i = 0; i < 7; i += 3) {

            if ((nodes[i].getSymbol().equals(symbol) &&     // X X X
                    (nodes[i + 1].getSymbol().equals(symbol) &&
                            (nodes[i + 2].getSymbol().equals(symbol))))) {

                return true;

            }
        }

        for (int i = 0; i < 3; i++) {

            if ((nodes[i].getSymbol().equals(symbol) &&                     // X
                    (nodes[i + 3].getSymbol().equals(symbol) &&             // X
                            (nodes[i + 6].getSymbol().equals(symbol))))) {  // X

                return true;

            }

        }

        if ((nodes[0].getSymbol().equals(symbol) &&                      // X
                (nodes[4].getSymbol().equals(symbol) &&                  //  X
                        (nodes[8].getSymbol().equals(symbol))))) {       //   X

            return true;

        }

        return (nodes[2].getSymbol().equals(symbol) &&             //    X
                (nodes[4].getSymbol().equals(symbol) &&            //   X
                        (nodes[6].getSymbol().equals(symbol))));   //  X


    }

    private boolean fullTable(Node[] nodes) {

        for (int i = 0; i < 9; i++) {

            if (nodes[i].getSymbol().equals(" ")) {

                return false;

            }

        }

        return true;

    }

    public boolean isHumanActualPlayer() {

        return actualPlayer.isHuman();

    }


    private void newGame() {

        for (int i = 0; i < 9; i++) {

            nodes[i] = new Node(i, " ");

        }

    }

    private void drawTable(Node[] nodes) {

        final String hLine = "  +---+---+---+";

        System.out.println("    1   2   3 ");
        System.out.println(hLine);
        System.out.println("A | " + nodes[0] + " | " + nodes[1] + " | " + nodes[2] + " |");
        System.out.println(hLine);
        System.out.println("B | " + nodes[3] + " | " + nodes[4] + " | " + nodes[5] + " |");
        System.out.println(hLine);
        System.out.println("C | " + nodes[6] + " | " + nodes[7] + " | " + nodes[8] + " |");
        System.out.println(hLine);
        System.out.println();

    }


    private void displayScore() {

        System.out.println(p1.getName() + "'s score: " + p1.getPoints());
        System.out.println(p2.getName() + "'s score: " + p2.getPoints());

    }


    public void makeMove(int nextStep) {

        if (isValidMove(nextStep)) {

            nodes[nextStep].setSymbol(actualPlayer.getSymbol());

            if (actualPlayer == p1) {

                actualPlayer = p2;

            } else {

                actualPlayer = p1;

            }

            drawTable(nodes);

        }

    }

    private boolean isValidMove(int nextStep) {

        if (nextStep < 0 || nextStep > nodes.length - 1) {

            return false;

        }

        return nodes[nextStep].getSymbol().equals(" ");

    }


    int cpuMove() {

        String cpuSymbol = actualPlayer.getSymbol();
        cpuTable = Arrays.copyOf(nodes, nodes.length);

        return minimax(cpuSymbol, cpuTable, true);

    }

    private int minimax(String symbol, Node[] cpuTable, boolean isTurnOfCPU) {

        String human = "X";

        if (symbol.equalsIgnoreCase("X")) {

            human = "O";

        }

        String actualVirtualPlayer;

        int node = 0;
        int whoWon = -2;

        while (!isValidMove(node) && !fullTable(cpuTable) && whoWon != 1 && whoWon != -1) {

            node++;

            if (isValidMove(node)) {

                actualVirtualPlayer = human;

                if (isTurnOfCPU) {

                    actualVirtualPlayer = symbol;

                }


                cpuTable[node].setSymbol(actualVirtualPlayer);


                drawTable(cpuTable);

                if (hasWon(actualVirtualPlayer, cpuTable)) {

                    if (actualVirtualPlayer.equalsIgnoreCase(symbol)) {

                        whoWon = 1;
                        System.out.println("Who won: " + whoWon);

                    } else {

                        whoWon = -1;
                        System.out.println("Who won: " + whoWon);
                    }

                }

                if (fullTable(cpuTable)) {

                    whoWon = 0;
                    System.out.println("Who won: " + whoWon);

                }


                isTurnOfCPU = !isTurnOfCPU;

            }

        }

        return whoWon;

    }

}
