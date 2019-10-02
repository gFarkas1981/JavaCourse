package com.gfarkas;

import java.util.Arrays;

public class QuickArray {

    private int[] array;
    private int sumOfArray;

    public QuickArray() {
    }

    public QuickArray(int[] array, int sumOfArray) {

        this.array = new int[array.length];

        for (int i = 0; i < array.length; i++) {

            this.array[i] = array[i];

        }
        this.sumOfArray = sumOfArray;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }


    public int getSumOfArray() {
        return sumOfArray;
    }

    public void setSumOfArray(int sumOfArray) {
        this.sumOfArray = sumOfArray;
    }
}
