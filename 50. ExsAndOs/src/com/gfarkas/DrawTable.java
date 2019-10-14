package com.gfarkas;

class DrawTable {

    public void drawTable(String[][] table) {

        final String hLine = "  +---+---+---+";

        System.out.println("    1   2   3 ");
        System.out.println(hLine);
        System.out.println("A | " + table[0][0] + " | " + table[0][1] + " | " + table[0][2] + " |");
        System.out.println(hLine);
        System.out.println("B | " + table[1][0] + " | " + table[1][1] + " | " + table[1][2] + " |");
        System.out.println(hLine);
        System.out.println("C | " + table[2][0] + " | " + table[2][1] + " | " + table[2][2] + " |");
        System.out.println(hLine);
        System.out.println();

    }

    void clearTable(String[][] table) {

        for (int i = 0; i < table.length; i++) {

            for (int j = 0; j < table[i].length; j++) {

                table[i][j] = " ";

            }

        }

    }

}
