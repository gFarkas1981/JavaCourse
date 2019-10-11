package com.gfarkas;

public class ExsOrOs {

    protected int exsOrOs(String[][] table) {

        // if returns 0 -> not yet won
        // if returns 1 -> "X" won
        // if returns 2 -> "O" won

        char xPerO = 'X';

        for (int j = 0; j < 2; j++) {

            if (j == 1) {

                xPerO = 'O';

            }

            for (int i = 0; i < 3; i++) {

                if ((table[i][0].charAt(0) == xPerO &&     // X X X
                        table[i][1].charAt(0) == xPerO &&
                        table[i][2].charAt(0) == xPerO)
                        ||
                        (table[0][i].charAt(0) == xPerO &&             // X
                                table[1][i].charAt(0) == xPerO &&      // X
                                table[2][i].charAt(0) == xPerO)        // X
                        ||
                        (table[0][0].charAt(0) == xPerO &&             // X
                                table[1][1].charAt(0) == xPerO &&      //  X
                                table[2][2].charAt(0) == xPerO)        //   X
                        ||
                        (table[0][2].charAt(0) == xPerO &&             //   X
                                table[1][1].charAt(0) == xPerO &&      //  X
                                table[2][0].charAt(0) == xPerO)) {     // X
                    return j + 1;

                }

            }

        }

        return 0;

    }

}
