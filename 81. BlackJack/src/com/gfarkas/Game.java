package com.gfarkas;

import java.util.Scanner;

public class Game {


    private boolean hit;

    public Game() {

        NewDeck newDeck = new NewDeck();
        Deal deal = new Deal();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name!");
        String playersName = scanner.nextLine();

        // Creating players
        Player dealer = new Player("Dealer", 1000);
        Player player = new Player(playersName, 1000);

        deal.firstDeal(newDeck.getDeck(), dealer, player);
        display(player);

        do {

            if (!evaluate(player, dealer)) {

                deal.notFirstDeal(newDeck.getDeck(), player);

            }


        } while (!evaluate(player, dealer));

    }

    public boolean hit() {

        hit = false;

        System.out.println("Do you want to continue? (hit = 'h')" +
                " or stay (stand = 's')");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        hit = answer.equalsIgnoreCase("h");

        return hit;

    }

    public void display(Player playerOrDealer) {

        System.out.println(playerOrDealer.getName() + "'s hand: ");

        for (Card card : playerOrDealer.hand) {

            System.out.println(card);

        }

        System.out.println("The value of "
                + playerOrDealer.getName() + "'s hand:" +
                playerOrDealer.getValueOfHand());

    }

    public boolean evaluate(Player player, Player dealer) {

        boolean isGameOver = false;
        boolean dealerGoneBust = false;
        boolean playerGoneBust = false;

        hit = hit();

        if (!hit) return true;

        if (dealer.getValueOfHand() == 21 &&
                player.getValueOfHand() == 21) {

            System.out.println("It's a push!");
            display(player);
            display(dealer);
            isGameOver = true;

        } else if (dealer.getValueOfHand() > 21) {

            dealerGoneBust = true;

        } else if (player.getValueOfHand() > 21) {

            playerGoneBust = true;

        } else if (playerGoneBust && dealerGoneBust) {

            System.out.println("It's a push! Nobody won!");
            display(player);
            display(dealer);
            isGameOver = true;

        } else {

            display(player);
            display(dealer);

        }

        return isGameOver;

    }

}
