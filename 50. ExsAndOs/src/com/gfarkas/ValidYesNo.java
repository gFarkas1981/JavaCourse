package com.gfarkas;

public class ValidYesNo {

    private boolean validAnswer = false;

    public boolean validYesNo(String yesNo) {

        return  (yesNo.equalsIgnoreCase("y") ||
                yesNo.equalsIgnoreCase("n"));

    }

}
