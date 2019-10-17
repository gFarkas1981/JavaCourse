package com.gfarkas;

public class Card {

    private char suit;
    byte value;
    String name;

    Card(char suit, byte value, String name) {
        this.suit = suit;
        this.value = value;
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " of " + suit;
    }

}
