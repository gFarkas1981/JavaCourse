package com.gfarkas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class NewDeck {

    private char clubs = '♣';
    private char spades = '♠';
    private char hearts = '♡';
    private char diamonds = '♦';
    private List<Card> deck = new ArrayList<>();
    private char[] suits = new char[] {clubs,spades,hearts,diamonds};
    private byte[] value = new byte[] {1,2,3,4,5,6,7,8,9,10,10,10,10};
    private String[] name = new String[]
            {"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};

    NewDeck() {

        createDeck();
        shuffleDeck();
        //displayDeck();

    }

    private void createDeck() {

        for (char suit : suits) {

            for (int j = 0; j < name.length; j++) {

                deck.add(new Card(suit, value[j], name[j]));

            }

        }

    }

    private void shuffleDeck() {

        Collections.shuffle(deck);

    }

    private void displayDeck() {

        for (Card card : deck) {

            System.out.println(card);

        }

    }

    public List<Card> getDeck() {
        return deck;
    }
}
