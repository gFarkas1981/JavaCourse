package com.gfarkas;

import java.util.Scanner;

public class PleaseEnter {

    public String enterString(String whatToDisplay) {

        Scanner scanner = new Scanner(System.in);

        System.out.println(whatToDisplay);

        return scanner.nextLine();
    }



        public int enterInt(String whatToDisplay) {

            Scanner scanner = new Scanner(System.in);

            System.out.println(whatToDisplay);

            return scanner.nextInt();
        }



}
