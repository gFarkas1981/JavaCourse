package com.gfarkas;

/**
 * @author Gabor Farkas <info@gfarkas.com>
 */
public class ExsAndOs {

    public static void main(String[] args) {

        Game game = new Game();
        StartGame startGame = new StartGame();
        WannaPlay wannaPlay = new WannaPlay();

        boolean newGame;
        boolean firstGame = true;

        do {

            String[][] table = startGame.startGame();
            game.game(table, firstGame);
            firstGame = false;
            game.scoreDisplay();
            newGame = wannaPlay.wannaPlay();

        } while (newGame);

    }

}
