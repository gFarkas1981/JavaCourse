package com.gfarkas;

public class Player {

    private String name;
    private int points;
    private char symbol;
    private boolean isActual;

    public Player() {
    }

    public Player(String name, int points, char symbol, boolean isActual) {
        this.name = name;
        this.points = points;
        this.symbol = symbol;
        this.isActual = isActual;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public boolean isActual() {
        return isActual;
    }

    public void setActual(boolean actual) {
        isActual = actual;
    }
}
