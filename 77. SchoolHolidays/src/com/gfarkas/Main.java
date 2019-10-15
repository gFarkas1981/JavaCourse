package com.gfarkas;


import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a date: (ie.: 1981.03.01)");
        String[] date = scanner.nextLine().split("\\.");
        new Holidays(date[0],date[1],date[2]);

    }

}
