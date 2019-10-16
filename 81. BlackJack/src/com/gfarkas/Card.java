package com.gfarkas;

public class Card {

    char suit;
    byte value;
    String name;

    public Card(char suit) {}

    public Card(char suit, byte value, String name) {
        this.suit = suit;
        this.value = value;
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " of " + suit;
    }

    public char getSuit() {
        return suit;
    }

    public void setSuit(char suit) {
        this.suit = suit;
    }

    public byte getValue() {
        return value;
    }

    public void setValue(byte value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
