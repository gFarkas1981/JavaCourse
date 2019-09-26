package atm;

import java.util.Scanner;

/**
 *
 * @author Gabor Farkas <info@gfarkas.com>
 */
public class ATM {

    public static void main(String[] args) {

        int[] bankNotes = {10000, 5000, 2000, 1000, 500};
        int[] coins = {200, 100, 50, 20, 10, 5};

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the amount you'd like to withdraw from the ATM: ");
        int amount = scanner.nextInt();

        if (amount > 250_000) {

            System.out.println("-------------------------------------------------------");
            System.out.println("The maximum amount you can withdraw is HUF250000.");
            System.out.println("Would you like to withdraw HUF250000? ((y/n)");
            scanner.nextLine();
            boolean withdraw = scanner.nextLine().toLowerCase().equals("y");

            if (withdraw) {

                amount = 250_000;

            } else {

                amount = 0;

            }

        }

        amount /= 5;
        amount *= 5;

        if (amount > 0) {

            System.out.println("-------------------------------------------------------");
            System.out.println("You will get HUF " + amount);
            System.out.println("-------------------------------------------------------");

            for (int bankNote : bankNotes) {

                if (amount / bankNote > 0) {

                    String bn = " banknote ";

                    if (amount / bankNote > 1) {

                        bn = " banknotes ";

                    }

                    System.out.println("HUF " + bankNote + bn + amount / bankNote);
                    amount = amount % bankNote;
                    System.out.println("Remainder: HUF " + amount);
                    System.out.println("-------------------------------------------------------");

                }

            }
            
            
            for (int coin : coins) {

                if (amount / coin > 0) {

                    String cn = " coin ";

                    if (amount / coin > 1) {

                        cn = " coins ";

                    }

                    System.out.println("HUF " + coin + cn + amount / coin);
                    amount = amount % coin;
                    System.out.println("Remainder: HUF " + amount);
                    System.out.println("-------------------------------------------------------");

                }

            }

        }

    }

}
