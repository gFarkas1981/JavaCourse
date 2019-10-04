package com.gfarkas;

public class IsValid {

    protected boolean isValid(String[][] table, int[] nextMove) {
        // if returns true -> valid
        return (table[nextMove[0]][nextMove[1] - 1].charAt(0) == ' ');

    }

}
