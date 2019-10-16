package com.gfarkas;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private int dollars;
    List<Card> hand = new ArrayList<>();
    private byte valueOfHand;
    private boolean hasAce;

    public Player() {
    }

    public Player(String name, int dollars) {
        this.name = name;
        this.dollars = dollars;
    }

    public void recalculate() {

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

    }

    public String getName() {
        return name;
    }

    public byte getValueOfHand() {
        return valueOfHand;
    }

}
