package com.gfarkas;

import java.util.List;

class Game {

    private UI userInterface = new UI();
    private boolean isFirstRound;
    private final int BET = 100;

    Game() {

        boolean hit = true;
        String playerName = userInterface.playerName();

        // Creating players
        Player dealer = new Player("Dealer", 1000, false, false);
        Player player = new Player(playerName, 1000, false, false);

        // Making the first deal with a new shoe
        Shoe shoe = new Shoe(1);
        firstRound(shoe.getShoe(), dealer, player);

        // Displaying initial scores
        System.out.println("Both " + playerName + " and dealer have $1000.");

        // playing until someone loses all it's money
        while (player.getDollars() > 1 && dealer.getDollars() > 1) {

            System.out.println("Taking bets!");
            player.setDollars(player.getDollars() - BET);
            dealer.setDollars(player.getDollars() - BET);

            // displaying player's cards and the first card of dealer
            userInterface.display(player);
            System.out.println("First card of dealer is " + dealer.hand.get(0));

            // checking if player has BlackJack or has gone bust
            if (evaluate(player)) {

                endOfTheGame(shoe.getShoe(), player, dealer);

            }

            // if someone has 21 in the first round, has BlackJack
            isFirstRound = false;

            // while player has not BlackJack, has not 21 and has not gone bust and wants to continue
            while (!evaluate(player) && hit) {

                // if player's hand's value is higher then 16
                if (player.isValuable()) {

                    // checking if player wants to continue
                    hit = userInterface.hit();

                    if (hit) {

                        // add a new card to player
                        notFirstRound(shoe.getShoe(), player);
                        // showing player's hand
                        userInterface.display(player);

                    }

                } else {

                    // add a new card to player
                    notFirstRound(shoe.getShoe(), player);
                    // showing player's hand
                    userInterface.display(player);

                }

            }

            endOfTheGame(shoe.getShoe(), player, dealer);

        }

    }

    private boolean evaluate(Player player) {

        if (player.getValueOfHand() == 21 && isFirstRound) {

            player.setBlackJack(true);

        }

        return player.hasGoneBust() || player.hasBlackJack() || player.getValueOfHand() == 21;

    }

    public void firstRound(List<Card> shoe, Player dealer, Player player) {

        // In first deal a player gets a card
        player.hand.add(shoe.get(0));

        // and dealer gets an other
        dealer.hand.add(shoe.get(1));

        // then player gets an other
        player.hand.add(shoe.get(2));

        // then dealer gets an other
        dealer.hand.add(shoe.get(3));

        // removing these cards from the shoe
        shoe.remove(0);
        shoe.remove(0);
        shoe.remove(0);
        shoe.remove(0);

        // recalculating the values of hands
        player.getValueOfHand();
        dealer.getValueOfHand();

    }

    public void notFirstRound(List<Card> shoe, Player player) {

        player.hand.add(shoe.get(0));
        shoe.remove(0);
        player.getValueOfHand();

    }

    public void endOfTheGame(List<Card> shoe, Player player, Player dealer) {

        byte valueOfDealer = 0;
        byte valueOfPlayer = 0;

        // adding cards to the dealer until dealer's hand's value under 17
        while (dealer.getValueOfHand() < 17) {

            dealer.hand.add(shoe.get(0));
            shoe.remove(0);

        }

        // showing dealer's hand
        userInterface.display(dealer);

        // comparing hands

        if (player.hasBlackJack() && dealer.hasBlackJack()) {

            userInterface.displayMessage(1, player);
            player.setDollars(player.getDollars() + BET);
            dealer.setDollars(dealer.getDollars() + BET);

        } else if (player.hasBlackJack()) {

            userInterface.displayMessage(2, player);
            player.setDollars(player.getDollars() + (BET * 2));

        } else if (player.hasGoneBust() && dealer.hasGoneBust()) {

            userInterface.displayMessage(3, player);
            player.setDollars(player.getDollars() + BET);
            dealer.setDollars(dealer.getDollars() + BET);

        } else if (player.hasGoneBust()) {

            userInterface.displayMessage(4, player);
            dealer.setDollars(dealer.getDollars() + (BET * 2));

        } else if (dealer.hasGoneBust()) {

            userInterface.displayMessage(5, player);
            player.setDollars(player.getDollars() + (BET * 2));


        } else if (player.getValueOfHand() == 21 && dealer.getValueOfHand() == 21) {

            userInterface.displayMessage(6, player);
            player.setDollars(player.getDollars() + BET);
            dealer.setDollars(dealer.getDollars() + BET);

        } else if (player.getValueOfHand() == 21) {

            userInterface.displayMessage(7, player);
            player.setDollars(player.getDollars() + (BET * 2));

        } else if (player.getValueOfHand() == dealer.getValueOfHand()) {

            userInterface.displayMessage(8, player);
            player.setDollars(player.getDollars() + BET);
            dealer.setDollars(dealer.getDollars() + BET);

        } else if (player.getValueOfHand() > dealer.getValueOfHand()) {

            userInterface.displayMessage(9, player);
            player.setDollars(player.getDollars() + (BET * 2));

        } else if (player.getValueOfHand() < dealer.getValueOfHand()) {

            userInterface.displayMessage(10, player);
            dealer.setDollars(dealer.getDollars() + (BET * 2));

        }

        System.out.println(player.getName() + "'s score: $" + player.getDollars());
        System.out.println("Dealer's score: $" + dealer.getDollars());

    }

}
