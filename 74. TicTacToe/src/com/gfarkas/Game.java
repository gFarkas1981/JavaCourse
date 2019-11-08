package com.gfarkas;

public class Game {

    private Node[] board = new Node[9];
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

        if (hasWon(p1.getSymbol(), board)) {

            System.out.println(p1.getName() + " has won the game!");
            p1.increasePoints(2);
            displayScore();
            newGame();
            actualPlayer = p1;

            return true;

        }

        if (hasWon(p2.getSymbol(), board)) {

            System.out.println(p2.getName() + " has won the game!");
            p2.increasePoints(2);
            displayScore();
            newGame();
            actualPlayer = p2;

            return true;

        }

        if (isFullTable(board)) {

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

    private boolean isFullTable(Node[] nodes) {

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

            board[i] = new Node(i, " ", 0);

        }

    }

    private void drawTable(Node[] inputNodes) {

        final String hLine = "  +---+---+---+";

        System.out.println("    1   2   3 ");
        System.out.println(hLine);
        System.out.println("A | " + inputNodes[0].getSymbol() + " | " + inputNodes[1].getSymbol() + " | " + inputNodes[2].getSymbol() + " |");
        System.out.println(hLine);
        System.out.println("B | " + inputNodes[3].getSymbol() + " | " + inputNodes[4].getSymbol() + " | " + inputNodes[5].getSymbol() + " |");
        System.out.println(hLine);
        System.out.println("C | " + inputNodes[6].getSymbol() + " | " + inputNodes[7].getSymbol() + " | " + inputNodes[8].getSymbol() + " |");
        System.out.println(hLine);
        System.out.println();

    }


    private void displayScore() {

        System.out.println(p1.getName() + "'s score: " + p1.getPoints());
        System.out.println(p2.getName() + "'s score: " + p2.getPoints());

    }

    public void makeMove(int nextStep) {

        if (isValidMove(nextStep)) {

            board[nextStep].setSymbol(actualPlayer.getSymbol());

            if (actualPlayer == p1) {

                actualPlayer = p2;

            } else {

                actualPlayer = p1;

            }

            drawTable(board);

        }

    }

    private boolean isValidMove(int nextStep) {

        if (nextStep < 0 || nextStep > board.length - 1) {

            return false;

        }

        return board[nextStep].getSymbol().equals(" ");

    }

    private void evaluateBoard() {

        for (int i = 0; i < board.length; i++) {

            if (board[i].getSymbol().equals(" ")) {

                calcValues(i);

            }

        }

    }

    private void calcValues(int i) {

        switch (i) {

            case 0:
                if ((board[1].getSymbol().equalsIgnoreCase(board[2].getSymbol()) && !board[1].getSymbol().equals(" ")) ||
                        ((board[3].getSymbol().equalsIgnoreCase(board[6].getSymbol()) && !board[3].getSymbol().equals(" ")) ||
                                (board[4].getSymbol().equalsIgnoreCase(board[8].getSymbol()) && !board[4].getSymbol().equals(" ")))) {

                    board[0].setValue(100);


                } else if (board[1].getSymbol().equalsIgnoreCase(actualPlayer.getSymbol()) ||
                        board[2].getSymbol().equalsIgnoreCase(actualPlayer.getSymbol()) ||
                        board[4].getSymbol().equalsIgnoreCase(actualPlayer.getSymbol()) ||
                        board[8].getSymbol().equalsIgnoreCase(actualPlayer.getSymbol()) ||
                        board[3].getSymbol().equalsIgnoreCase(actualPlayer.getSymbol()) ||
                        board[6].getSymbol().equalsIgnoreCase(actualPlayer.getSymbol())) {

                    board[0].setValue(60);

                } else if (!board[4].getSymbol().equals(" ")) {

                    board[0].setValue(75);

                } else {

                    board[0].setValue(0);

                }
                break;

            case 1:
                if ((board[0].getSymbol().equalsIgnoreCase(board[2].getSymbol()) && !board[0].getSymbol().equals(" ")) ||
                        (board[4].getSymbol().equalsIgnoreCase(board[7].getSymbol()) && !board[4].getSymbol().equals(" "))) {

                    board[1].setValue(100);


                } else if (board[0].getSymbol().equalsIgnoreCase(actualPlayer.getSymbol()) ||
                        board[2].getSymbol().equalsIgnoreCase(actualPlayer.getSymbol()) ||
                        board[4].getSymbol().equalsIgnoreCase(actualPlayer.getSymbol()) ||
                        board[7].getSymbol().equalsIgnoreCase(actualPlayer.getSymbol())) {

                    board[1].setValue(50);

                } else {

                    board[1].setValue(0);

                }
                break;

            case 2:
                if ((board[0].getSymbol().equalsIgnoreCase(board[1].getSymbol()) && !board[0].getSymbol().equals(" ")) ||
                        (board[4].getSymbol().equalsIgnoreCase(board[6].getSymbol()) && !board[4].getSymbol().equals(" ")) ||
                        (board[5].getSymbol().equalsIgnoreCase(board[8].getSymbol()) && !board[5].getSymbol().equals(" "))) {

                    board[2].setValue(100);


                } else if (board[0].getSymbol().equalsIgnoreCase(actualPlayer.getSymbol()) ||
                        board[1].getSymbol().equalsIgnoreCase(actualPlayer.getSymbol()) ||
                        board[4].getSymbol().equalsIgnoreCase(actualPlayer.getSymbol()) ||
                        board[6].getSymbol().equalsIgnoreCase(actualPlayer.getSymbol()) ||
                        board[5].getSymbol().equalsIgnoreCase(actualPlayer.getSymbol()) ||
                        board[8].getSymbol().equalsIgnoreCase(actualPlayer.getSymbol())) {

                    board[2].setValue(60);

                } else if (!board[4].getSymbol().equals(" ")) {

                    board[2].setValue(75);

                } else {

                    board[2].setValue(0);

                }
                break;

            case 3:
                if ((board[0].getSymbol().equalsIgnoreCase(board[6].getSymbol()) && !board[0].getSymbol().equals(" ")) ||
                        (board[4].getSymbol().equalsIgnoreCase(board[5].getSymbol()) && !board[4].getSymbol().equals(" "))) {

                    board[3].setValue(100);


                } else if (board[0].getSymbol().equalsIgnoreCase(actualPlayer.getSymbol()) ||
                        board[6].getSymbol().equalsIgnoreCase(actualPlayer.getSymbol()) ||
                        board[4].getSymbol().equalsIgnoreCase(actualPlayer.getSymbol()) ||
                        board[5].getSymbol().equalsIgnoreCase(actualPlayer.getSymbol())) {

                    board[3].setValue(50);

                } else {

                    board[3].setValue(0);

                }
                break;

            case 4:
                if ((board[0].getSymbol().equalsIgnoreCase(board[8].getSymbol()) && !board[0].getSymbol().equals(" ")) ||
                        (board[3].getSymbol().equalsIgnoreCase(board[5].getSymbol()) && !board[3].getSymbol().equals(" ")) ||
                        (board[6].getSymbol().equalsIgnoreCase(board[2].getSymbol()) && !board[6].getSymbol().equals(" ")) ||
                        (board[1].getSymbol().equalsIgnoreCase(board[7].getSymbol()) && !board[1].getSymbol().equals(" "))) {

                    board[4].setValue(100);


                } else if (board[0].getSymbol().equalsIgnoreCase(actualPlayer.getSymbol()) ||
                        board[1].getSymbol().equalsIgnoreCase(actualPlayer.getSymbol()) ||
                        board[2].getSymbol().equalsIgnoreCase(actualPlayer.getSymbol()) ||
                        board[3].getSymbol().equalsIgnoreCase(actualPlayer.getSymbol()) ||
                        board[5].getSymbol().equalsIgnoreCase(actualPlayer.getSymbol()) ||
                        board[6].getSymbol().equalsIgnoreCase(actualPlayer.getSymbol()) ||
                        board[7].getSymbol().equalsIgnoreCase(actualPlayer.getSymbol()) ||
                        board[8].getSymbol().equalsIgnoreCase(actualPlayer.getSymbol())) {

                    board[4].setValue(70);

                } else {

                    board[4].setValue(60);

                }
                break;

            case 5:
                if ((board[2].getSymbol().equalsIgnoreCase(board[8].getSymbol()) && !board[2].getSymbol().equals(" ")) ||
                        (board[3].getSymbol().equalsIgnoreCase(board[4].getSymbol()) && !board[3].getSymbol().equals(" "))) {

                    board[5].setValue(100);


                } else if (board[2].getSymbol().equalsIgnoreCase(actualPlayer.getSymbol()) ||
                        board[8].getSymbol().equalsIgnoreCase(actualPlayer.getSymbol()) ||
                        board[3].getSymbol().equalsIgnoreCase(actualPlayer.getSymbol()) ||
                        board[4].getSymbol().equalsIgnoreCase(actualPlayer.getSymbol())) {

                    board[5].setValue(50);

                } else {

                    board[5].setValue(0);

                }
                break;

            case 6:
                if (board[0].getSymbol().equalsIgnoreCase(board[3].getSymbol()) && !board[0].getSymbol().equals(" ") ||
                        (board[4].getSymbol().equalsIgnoreCase(board[2].getSymbol()) && !board[4].getSymbol().equals(" ")) ||
                        (board[7].getSymbol().equalsIgnoreCase(board[8].getSymbol()) && !board[1].getSymbol().equals(" "))) {

                    board[6].setValue(100);


                } else if (board[0].getSymbol().equalsIgnoreCase(actualPlayer.getSymbol()) ||
                        board[3].getSymbol().equalsIgnoreCase(actualPlayer.getSymbol()) ||
                        board[4].getSymbol().equalsIgnoreCase(actualPlayer.getSymbol()) ||
                        board[2].getSymbol().equalsIgnoreCase(actualPlayer.getSymbol()) ||
                        board[7].getSymbol().equalsIgnoreCase(actualPlayer.getSymbol()) ||
                        board[8].getSymbol().equalsIgnoreCase(actualPlayer.getSymbol())) {

                    board[6].setValue(60);

                } else if (!board[4].getSymbol().equals(" ")) {

                    board[6].setValue(75);

                } else {

                    board[6].setValue(0);

                }
                break;

            case 7:
                if ((board[1].getSymbol().equalsIgnoreCase(board[4].getSymbol()) && !board[1].getSymbol().equals(" ")) ||
                        (board[6].getSymbol().equalsIgnoreCase(board[8].getSymbol()) && !board[6].getSymbol().equals(" "))) {

                    board[7].setValue(100);


                } else if (board[1].getSymbol().equalsIgnoreCase(actualPlayer.getSymbol()) ||
                        board[4].getSymbol().equalsIgnoreCase(actualPlayer.getSymbol()) ||
                        board[6].getSymbol().equalsIgnoreCase(actualPlayer.getSymbol()) ||
                        board[8].getSymbol().equalsIgnoreCase(actualPlayer.getSymbol())) {

                    board[7].setValue(50);

                } else {

                    board[7].setValue(0);

                }
                break;

            case 8:
                if ((board[6].getSymbol().equalsIgnoreCase(board[7].getSymbol()) && !board[6].getSymbol().equals(" ")) ||
                        (board[0].getSymbol().equalsIgnoreCase(board[4].getSymbol())) && !board[0].getSymbol().equals(" ") ||
                        (board[2].getSymbol().equalsIgnoreCase(board[5].getSymbol())) && !board[2].getSymbol().equals(" ")) {

                    board[8].setValue(100);


                } else if (board[6].getSymbol().equalsIgnoreCase(actualPlayer.getSymbol()) ||
                        board[7].getSymbol().equalsIgnoreCase(actualPlayer.getSymbol()) ||
                        board[0].getSymbol().equalsIgnoreCase(actualPlayer.getSymbol()) ||
                        board[4].getSymbol().equalsIgnoreCase(actualPlayer.getSymbol()) ||
                        board[2].getSymbol().equalsIgnoreCase(actualPlayer.getSymbol()) ||
                        board[5].getSymbol().equalsIgnoreCase(actualPlayer.getSymbol())) {

                    board[8].setValue(60);

                } else if (!board[4].getSymbol().equals(" ")) {

                    board[8].setValue(75);

                } else {

                    board[8].setValue(0);

                }
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + i);
        }
    }

    public int cpuMove() {

        evaluateBoard();
        Node nodeWithHighestValue = board[0];

        for (Node value : board) {

            if (value.getSymbol().equals(" ")) {

                nodeWithHighestValue = value;

            }

        }

        for (Node node : board) {

            if (node.getValue() > nodeWithHighestValue.getValue() &&
                    node.getSymbol().equals(" ")) {

                nodeWithHighestValue = node;

            }

        }

        return nodeWithHighestValue.getNumberOfNode();

    }

    public int findBestMove() {

        // duplicate original board for test purpose
        Node[] testBoard = new Node[board.length];

        for (int i = 0; i < board.length; i++) {

            testBoard[i] = new Node(board[i].getNumberOfNode(), board[i].getSymbol(), board[i].getValue());

        }

        // initializing best possible move with the worst value for player 2 (computer)
        Node bestMove = new Node(-1, "X", Integer.MIN_VALUE);

        // iterating through the board
        for (Node node : testBoard) {

            // if we can make this move
            if (node.getSymbol().equals(" ")) {

                // making a move
                node.setSymbol("O");
                // and recursively playing the game with this starting position
                node.setValue(minimax(testBoard, 0, false));

                // comparing this value and the best move's value so far
                if (node.getValue() > bestMove.getValue()) {

                    // setting the new best move
                    bestMove = new Node
                            (node.getNumberOfNode(), node.getSymbol(), node.getValue());

                }

                // undoing move
                node.setSymbol(" ");

            }

        }

        // returning the best possible move's position on the board
        return bestMove.getNumberOfNode();

    }

    private int minimax(Node[] testBoard, int depth, boolean isMaximizingPlayer) {

        int valueOfTheBoard;

        // if the game is over and computer won
        if (hasWon("O", testBoard)) {

            return 10;

            // if player 1 won
        } else if (hasWon("X", testBoard)) {

            return  -10;

            // if it's a draw
        } else if (isFullTable(testBoard)){

            return 0;

        }

        if (isMaximizingPlayer) {

            // recursively making the next...next move
            int bestValue = Integer.MIN_VALUE;

            for (Node node : testBoard) {

                if (node.getSymbol().equals(" ")) {

                    node.setSymbol("O");
                    valueOfTheBoard = minimax(testBoard, depth + 1, false);
                    // selecting the new best value for p2 (computer)
                    bestValue = Math.max(bestValue, valueOfTheBoard);


                    // undoing move
                    node.setSymbol(" ");

                }

            }

            return bestValue;

        } else {

            int bestValue = Integer.MAX_VALUE;

            for (Node node : testBoard) {

                if (node.getSymbol().equals(" ")) {

                    node.setSymbol("X");
                    valueOfTheBoard = minimax(testBoard, depth + 1, true);
                    // selecting the new best value for p1 (human)
                    bestValue = Math.min(bestValue, valueOfTheBoard);

                    // undoing move
                    node.setSymbol(" ");

                }

            }

            return bestValue;

        }

    }


}
