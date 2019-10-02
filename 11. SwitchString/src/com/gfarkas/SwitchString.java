package com.gfarkas;

import java.util.Scanner;

public class SwitchString {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter a fruit name: ");

        String fruit = scanner.nextLine();

        switch (fruit) {

            case "apple":
                System.out.println("red");
                break;
            case "pear":
                System.out.println("green");
                break;
            case "peach":
                System.out.println("blue");
                break;
            default:
                System.out.println("I don't know such fruit name");
        }

    }

}
