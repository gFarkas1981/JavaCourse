package com.gfarkas;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private int dollars;
    List<Card> hand = new ArrayList<>();
    private byte valueOfHand;
    private boolean goneBust = false;
    private boolean hasBlackJack;
    private boolean isValuable = false;

    public Player() {
    }

    Player(String name, int dollars, boolean goneBust, boolean hasBlackJack) {
        this.name = name;
        this.dollars = dollars;
        this.goneBust = goneBust;
        this.hasBlackJack = hasBlackJack;
    }

    private void recalculate() {

        boolean hasAce = false;
        this.valueOfHand = 0;

        for (Card card : this.hand) {

            this.valueOfHand += card.value;

            if (card.name.equalsIgnoreCase("Ace")) {

                hasAce = true;

            }

        }

        if (hasAce && this.valueOfHand + 10 <= 21) {

            this.valueOfHand += 10;

        }

        if (valueOfHand > 21) {

            goneBust = true;

        } else if (valueOfHand > 16) {

            isValuable = true;

        }

    }

    String getName() {
        return name;
    }

    byte getValueOfHand() {

        recalculate();
        return valueOfHand;
    }

    public int getDollars() {
        return dollars;
    }

    public void setDollars(int dollars) {
        this.dollars = dollars;
    }

    boolean hasGoneBust() {
        return goneBust;
    }

    boolean isValuable() {
        return isValuable;
    }

    boolean hasBlackJack() {
        return hasBlackJack;
    }

    void setBlackJack(boolean hasBlackJack) {
        this.hasBlackJack = hasBlackJack;
    }
}
