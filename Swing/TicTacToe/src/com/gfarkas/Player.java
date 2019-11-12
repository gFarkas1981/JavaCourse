package com.gfarkas;

public class Player {

    private String name;
    private int points;
    private String symbol;
    private boolean isHuman;

    public Player() {
    }

    public Player(String name, String symbol, boolean isHuman) {
        this.name = name;
        this.points = 0;
        this.symbol = symbol;
        this.isHuman = isHuman;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public String getSymbol() {
        return symbol;
    }

    public void increasePoints(int points) {
        this.points += points;
    }

    public boolean isHuman() {
        return isHuman;
    }

}
