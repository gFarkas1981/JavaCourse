package com.gfarkas;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Set<Integer> winnerNumbers = new HashSet<>();
        Set<Integer> userNumbers = new HashSet<>();
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        while (winnerNumbers.size() < 7) {

            winnerNumbers.add(random.nextInt(35) + 1);

        }

        for (Integer winnerNumber : winnerNumbers) {

            System.out.println(winnerNumber);

        }

        while (userNumbers.size() < winnerNumbers.size()) {

            System.out.println("Please enter a number!");

            int temp = scanner.nextInt();
            if (!userNumbers.add(temp) ||
             temp > 90 || temp < 1) {

                System.out.println("Wrong number");

            }

        }

        userNumbers.retainAll(winnerNumbers);

        System.out.println("You have " + userNumbers.size() + " hit(s).");

    }
}
