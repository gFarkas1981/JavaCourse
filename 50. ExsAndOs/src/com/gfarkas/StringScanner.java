package com.gfarkas;

import java.util.Scanner;

public class StringScanner {

    protected String stringScanner(String text) {

        Scanner scanner = new Scanner(System.in);
        System.out.println(text);

        return scanner.nextLine();

    }

}
