package XandOs;

public class Game {

    Player player1;
    Player player2;
    boolean player1Turn;
    char[][] gameBoard;

    public Game() {
        player1 = new Player('X');
        player2 = new Player('O');
        player1Turn = true;
        gameBoard = new char[3][3];
    }

    public boolean gameOver() {

        return threeInARow() || threeInACol() && threeDiagonally();
    }

    private boolean threeDiagonally() {
        char[] diagonal = new char[3];
        char[] diagonal2 = new char[3];

        for (int row = 0; row < gameBoard.length; row++) {
            for (int col = 0; col < gameBoard.length; col++) {
                if (row == col) {
                    diagonal[row] = gameBoard[row][col];
                }
            }
        }

        for (int row = 0; row < gameBoard.length; row++) {
            for (int col = 0; col < gameBoard.length; col++) {
                if (row + col == gameBoard.length+1) {
                    diagonal[row] = gameBoard[row][col];
                }
            }
        }

        return checkForThree(diagonal) && checkForThree(diagonal2);

    }

    private boolean threeInACol() {
        char[] column = new char[3];
        for (int row = 0; row < gameBoard.length; row++) {
            for (int col = 0; col < gameBoard.length; col++) {

                column[row] = gameBoard[col][row];
                return checkForThree(column);
            }
        }
        return false;
    }

    private boolean threeInARow() {
        char[] row = new char[3];
        for (int i = 0; i < gameBoard.length; i++) {
            row = gameBoard[i];
            return checkForThree(row);
        }
        return false;
    }

    private boolean checkForThree(char[] row) {
        return row[0] == row[1] && row[0] == row[2] && row[0] != '\u0000';
    }

    public void process(String command) {

        char rowAsChar = command.charAt(0);
        int col = Character.getNumericValue(command.charAt(1)) - 1;
        int row = 0;

        switch (rowAsChar) {
            case 'A':
                row = 0;
                break;
            case 'B':
                row = 1;
                break;
            case 'C':
                row = 2;
                break;
        }

        if (player1Turn) {
            gameBoard[row][col] = player1.getSymbol();
        } else {
            gameBoard[row][col] = player2.getSymbol();
        }

        player1Turn = !player1Turn;
    }

    public void print() {

        for (char[] chars : gameBoard) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }
}
