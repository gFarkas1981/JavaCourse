package com.gfarkas;

public class EvenNumbers {

    public static void main(String[] args) {

        for (int i = 2; i < 101; i++) {

            if (i % 2 == 0) {

                System.out.println(i);

            }

        }

        for (int i = 2; i < 101; i += 2) {

            System.out.println(i);

        }

    }

}
