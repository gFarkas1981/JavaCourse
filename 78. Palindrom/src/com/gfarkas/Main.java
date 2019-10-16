package com.gfarkas;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter something!");
        String text = scanner.nextLine().toLowerCase();

        System.out.println(new IsPalindrome(text));

    }
}
