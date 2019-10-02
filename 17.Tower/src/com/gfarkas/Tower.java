package com.gfarkas;

public class Tower {

    public static void main(String[] args) {

        for (int i = 1; i < 8; i++) {

            if (i % 2 != 0) {

                for (int k = 0; k < i; k++) {

                    for (int m = 7 - i; m > 0; m--) {

                        System.out.print(" ");

                    }

                    for (int l = 0; l < i; l++) {

                        System.out.print(" *");

                    }

                    System.out.println("");
                }

            }

        }

    }

}
