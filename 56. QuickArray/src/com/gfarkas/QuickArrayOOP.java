package com.gfarkas;

public class QuickArrayOOP {

    public static void main(String[] args) {

        int[] a = new int[7];

        QuickArray qa = new QuickArray(a, 0);

        for (int number : a) {
            System.out.print(number + "\t");
        }

        System.out.println();
        a[5] = 2;

        for (int number : qa.getArray()) {

            System.out.print(number + "\t");

        }
    }
}
