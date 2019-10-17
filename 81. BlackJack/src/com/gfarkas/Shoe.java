package com.gfarkas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Shoe {

    private char clubs = '♣';
    private char spades = '♠';
    private char hearts = '♡';
    private char diamonds = '♦';
    private List<Card> deck = new ArrayList<>();
    private char[] suits = new char[] {clubs,spades,hearts,diamonds};
    private byte[] value = new byte[] {1,2,3,4,5,6,7,8,9,10,10,10,10};
    private String[] name = new String[]
            {"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};

    Shoe(int decks) {

        createShoe(decks);
        shuffleShoe();

    }

    private void createShoe(int decks) {

        for (int i = 0; i < decks ; i++) {

            for (char suit : suits) {

                for (int j = 0; j < name.length; j++) {

                    deck.add(new Card(suit, value[j], name[j]));

                }

            }

        }

    }

    private void shuffleShoe() {

        Collections.shuffle(deck);

    }

    List<Card> getShoe() {
        return deck;
    }
}
