package com.gfarkas;

class HasWon {

    int hasWon(String[][] table) {

        // if returns 0 -> not yet won
        // if returns 1 -> "X" won
        // if returns 2 -> "O" won

        String xOrO = "X";

        for (int j = 0; j < 2; j++) {

            if (j == 1) {

                xOrO = "O";

            }

            for (int i = 0; i < 3; i++) {

                if ((table[i][0].equals(xOrO) &&     // X X X
                        table[i][1].equals(xOrO) &&
                        table[i][2].equals(xOrO)
                        ||
                        (table[0][i].equals(xOrO) &&             // X
                                table[1][i].equals(xOrO) &&      // X
                                table[2][i].equals(xOrO))        // X
                        ||
                        (table[0][0].equals(xOrO) &&                  // X
                                table[1][1].equals(xOrO) &&           //  X
                                table[2][2].equals(xOrO))             //   X
                        ||
                        (table[0][2].equals(xOrO) &&                  //   X
                                table[1][1].equals(xOrO) &&           //  X
                                table[2][0].equals(xOrO))))           // X

                    return j + 1;

            }

        }

        return 0;

    }

}
