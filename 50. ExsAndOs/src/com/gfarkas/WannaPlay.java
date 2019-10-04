package com.gfarkas;

public class WannaPlay {

    protected boolean wannaPlay() {

        StringScanner stringScanner = new StringScanner();

        boolean wrongAnswer = true;
        boolean newGame = false;


        while (wrongAnswer) {

            new HorizontalLine();
            String answer = stringScanner.stringScanner("Do you want to play another game? (y/n)");
            new HorizontalLine();

            if (answer.equalsIgnoreCase("y")) {

                newGame = true;
                wrongAnswer = false;

                for (int i = 0; i < 20 ; i++) {

                    new HorizontalLine();

                }

            } else wrongAnswer = !answer.equalsIgnoreCase("n");

        }

        return newGame;

    }

}
