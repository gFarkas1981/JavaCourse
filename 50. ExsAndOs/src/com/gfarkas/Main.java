package com.gfarkas;

/**
 * @author Gabor Farkas <info@gfarkas.com>
 */
public class Main {

    public static void main(String[] args) {

        Game game = new Game();
        StartGame startGame = new StartGame();

        boolean newGame;
        boolean firstGame = true;

        do {

            String[][] table = startGame.startGame();
            game.game(table, firstGame);
            firstGame = false;
            game.scoreDisplay();
            newGame = game.playAgain();

        } while (newGame);

    }

}
