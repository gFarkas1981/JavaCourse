package com.gfarkas;

import java.util.List;
import java.util.Scanner;

public class Deal {

    public Deal() {}

    public void firstDeal(List<Card> deck, Player dealer, Player player) {

        player.hand.add(deck.get(0));
        dealer.hand.add(deck.get(1));
        player.hand.add(deck.get(2));
        dealer.hand.add(deck.get(3));

        deck.remove(0);
        deck.remove(0);
        deck.remove(0);
        deck.remove(0);

        player.recalculate();
        dealer.recalculate();

        while (dealer.getValueOfHand() < 17) {

            dealer.hand.add(deck.get(0));
            deck.remove(0);
            dealer.recalculate();

        }

    }

    public void notFirstDeal(List<Card> deck, Player player) {

        player.hand.add(deck.get(0));
        deck.remove(0);
        player.recalculate();

    }
}
