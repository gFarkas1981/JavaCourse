package atm;

import java.util.Scanner;

/**
 *
 * @author Gabor Farkas <info@gfarkas.com>
 */
public class ATM {

    public static void main(String[] args) {

        int[] bankNotes = {20000, 10000, 5000, 1000};

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

        amount /= 1000;
        amount *= 1000;

        if (amount > 0) {

            System.out.println("-------------------------------------------------------");
            System.out.println("You will get HUF " + amount);
            System.out.println("-------------------------------------------------------");

            for (int bankNote : bankNotes) {

                if (amount / bankNote > 0) {

                    System.out.println("HUF " + bankNote + " banknote(s) " + amount / bankNote);
                    amount = amount % bankNote;
                    System.out.println("Remainder: HUF " + amount);
                    System.out.println("-------------------------------------------------------");

                }

            }

        }

    }

}
