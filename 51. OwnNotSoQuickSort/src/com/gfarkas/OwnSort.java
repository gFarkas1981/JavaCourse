package com.gfarkas;

import java.util.Random;

/**
 * @author Gabor Farkas <info@gfarkas.com>
 */
public class OwnSort {

    public static void soutArray(int[] inputArray) {

        for (int element : inputArray) {

            System.out.print(element + " ");

        }

        System.out.println();

    }

    public static boolean arrayContains(int[] inputArray, int number) {

        boolean contains = false;

        for (int i = 0; i < inputArray.length && !contains; i++) {

            if (inputArray[i] == number) {

                contains = true;

            }

        }

        return contains;

    }

    public static void ownSort(int[] inArray, int minusElements) {

        int min = inArray[minusElements];
        int minPos = minusElements;
        int max = inArray[minusElements];
        int maxPos = minusElements;

        for (int i = minusElements; i < inArray.length - minusElements; i++) {

            if (inArray[i] < min) {

                min = inArray[i];
                minPos = i;

            }

            if (inArray[i] > max) {

                max = inArray[i];
                maxPos = i;

            }

        }

        if (maxPos == minusElements && minPos == inArray.length - 1 - minusElements) {

            inArray[minusElements] = min;
            inArray[inArray.length - 1 - minusElements] = max;

        } else if (maxPos == minusElements) {

            inArray[minusElements] = min;
            int tmpLast = inArray[inArray.length - 1 - minusElements];
            inArray[inArray.length - 1 - minusElements] = max;
            inArray[minPos] = tmpLast;

        } else if (minPos == inArray.length - 1 - minusElements) {

            inArray[inArray.length - 1 - minusElements] = max;
            int tmpFirst = inArray[minusElements];
            inArray[minusElements] = min;
            inArray[maxPos] = tmpFirst;

        } else {

            int tmpFirst = inArray[minusElements];
            int tmpLast = inArray[inArray.length - 1 - minusElements];
            inArray[minusElements] = min;
            inArray[inArray.length - 1 - minusElements] = max;
            inArray[minPos] = tmpFirst;
            inArray[maxPos] = tmpLast;

        }

    }

    public static void main(String[] args) {

        Random random = new Random();
        int rndNr = 0;

        int inArray[] = new int[10_000];

        for (int i = 0; i < 9_999 ; i++) {

            while (arrayContains(inArray, rndNr)) {

                rndNr = random.nextInt(1000);

            }

        }

        //int[] inArray = {98, 65, 76, 32, 6, 22, 11, 9, 44, 3};

        long time = System.nanoTime();

        for (int i = 0; i < inArray.length / 2; i++) {

            ownSort(inArray, i);

        }


        soutArray(inArray);

        String strDouble = String.format("%.4f",
                (System.nanoTime() - time) / (double) 1_000_000_000);
        System.out.println(strDouble + "seconds.");

    }

}
