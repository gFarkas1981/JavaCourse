package com.gfarkas;

public class WannaPlay {

    private boolean validAnswer;
    private String answer;

    protected boolean wannaPlay() {

        StringScanner stringScanner = new StringScanner();
        ValidYesNo validYesNo = new ValidYesNo();

        boolean newGame = false;


        while (!validAnswer) {

            new HorizontalLine();
            answer = stringScanner.stringScanner("Do you want to play another game? (y/n)");
            new HorizontalLine();

            validAnswer = validYesNo.validYesNo(answer);

        }

        if (answer.equalsIgnoreCase("y")) {

            newGame = true;

            for (int i = 0; i < 20 ; i++) {

                new HorizontalLine();

            }

        }

        return newGame;

    }

}
