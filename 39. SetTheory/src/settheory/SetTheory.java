package settheory;

import java.util.Arrays;
import java.util.HashSet;

/**
 *
 * @author Gabor Farkas <info@gfarkas.com>
 */
public class SetTheory {

    public static void main(String[] args) {

        int[] array1 = {1, 2, 3};
        int[] array2 = {2, 3, 4, 3};

        System.out.println("The two arrays:");

        for (int element : array1) {

            System.out.print(element + " ");

        }

        System.out.println("");

        for (int element : array2) {

            System.out.print(element + " ");

        }

        System.out.println("");

        Union union = new Union();
        union.unionMethod(array1, array2);

        System.out.println("");
        System.out.println("");

        Intersection intersection = new Intersection();
        intersection.intersectionMethod(array1, array2);

    }

}
