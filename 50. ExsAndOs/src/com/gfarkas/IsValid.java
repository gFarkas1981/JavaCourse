package com.gfarkas;

class IsValid {

    boolean isValid(String[][] table, int[] nextMove) {
        // if returns true -> valid
        return (table[nextMove[0]][nextMove[1] - 1].charAt(0) != ' ');

    }

}
