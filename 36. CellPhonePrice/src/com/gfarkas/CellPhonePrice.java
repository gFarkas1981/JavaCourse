package com.gfarkas;

import java.util.Scanner;

/**
 *
 * @author Gabor Farkas <info@gfarkas.com>
 */
public class CellPhonePrice {

    public static void main(String[] args) {

        double sumOfPrices = 0;
        int countMoreThan90000 = 0;

        double min = Double.MAX_VALUE;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter how many stores do we have to compare? ");
        int nrOfShops = scanner.nextInt();
        scanner.nextLine();

        divider();

        String[] shops = new String[nrOfShops];
        double[] prices = new double[nrOfShops];

        for (int i = 0; i < nrOfShops; i++) {

            divider();

            System.out.println("Please enter the name of the shop: (eg. Tesco)");
            shops[i] = scanner.nextLine();

            divider();

            System.out.println("Please enter the price of the cellphone in " + shops[i] + ": (eg. 99,99)");
            prices[i] = scanner.nextDouble();

            sumOfPrices += prices[i];

            if (prices[i] > 90000) {

                countMoreThan90000++;

            }

            if (prices[i] < min) {

                min = prices[i];

            }

            scanner.nextLine();

        }

        divider();

        // avarage
        System.out.println("The avarage price of the cellphone is " + sumOfPrices / nrOfShops);

        divider();

        // shops where the price is higher than 90000
        System.out.println("This cellphone's price is higher than 90000 in " + countMoreThan90000 + " shop(s).");

        divider();

        // shop which has the cheapest price for this cellphone
        System.out.println("These are the shops where you can buy this cellphone for the cheapest price (" + min + "):");
        for (int i = 0; i < nrOfShops; i++) {

            if (prices[i] == min) {

                System.out.println(shops[i]);

            }

        }
        
        divider();
        
        // searching for a price
        boolean priceExists = false;
        System.out.println("Please enter the price you search for: ");
        double thePrice = scanner.nextDouble();
        
        System.out.println("");
        System.out.println("In these shops you can buy this cellphone for this price: ");
        for (int i = 0; i < nrOfShops ; i++) {
            
            if (prices[i] == thePrice) {
                
                System.out.println((i+1) + ". " + shops[i]);
                priceExists = true;
                
            }
            
        }
        
        if  (!priceExists) System.out.println("-1-");

    }

    public static void divider() {

        System.out.println("-----------------------------------------------------------");

    }

}
