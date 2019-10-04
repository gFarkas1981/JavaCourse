package com.gfarkas;

public class StartGame {

    protected String[][] startGame() {

        DrawTable drawTable = new DrawTable();
        String[][] table = new String[3][3];
        drawTable.clearTable(table);
        drawTable.drawTable(table);

        return table;

    }

}
