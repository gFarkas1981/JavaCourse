package com.gfarkas;

import java.util.Scanner;

class UI {


    UI() {
    }

    String playerName() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name!");

        return scanner.nextLine();

    }

    boolean hit() {

        boolean hit;

        System.out.println("Do you want to continue? (hit = 'h')" +
                " or stay (stand = 's')");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        hit = answer.equalsIgnoreCase("h");

        return hit;

    }

    void display(Player player) {

        System.out.println(player.getName() + "'s hand: ");

        for (Card card : player.hand) {

            System.out.println(card);

        }

        System.out.println("The value of "
                + player.getName() + "'s hand:" +
                player.getValueOfHand());

    }

    void displayMessage(int messageNr, Player player) {

        String push = "It's a push! Nobody won!";
        String both = "Both ";
        String uWon = "Congratulations, you won!";

        switch (messageNr) {



            case 1:
                System.out.println(both + player.getName() + " and dealer have BlackJack!");
                System.out.println(push);
                break;

            case 2:
                System.out.println(player.getName() + " has BlackJack!");
                System.out.println(uWon);
                break;

            case 3:
                System.out.println(both + player.getName() + " and dealer have gone bust!");
                System.out.println(push);
                break;

            case 4:
                System.out.println(player.getName() + " has gone bust!");
                System.out.println("Dealer won!");
                break;

            case 5:
                System.out.println("Dealer has gone bust!");
                System.out.println(uWon);
                break;

            case 6:
                System.out.println(both + player.getName() + " and dealer have 21!");
                System.out.println(push);
                break;

            case 7:
                System.out.println(player.getName() + " has 21!");
                System.out.println(uWon);
                break;

            case 8:
                System.out.println(both + player.getName() + " and dealer have " + player.getValueOfHand() + "!");
                System.out.println(push);
                break;

            case 9:
                System.out.println(player.getName() + "'s hand has higher value!");
                System.out.println(uWon);
                break;

            case 10:
                System.out.println("Dealer's hand has higher value!");
                System.out.println("Dealer won!");
                break;

            default:

        }

    }

}
