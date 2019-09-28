package lottery;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Gabor Farkas <info@gfarkas.com>
 */
public class Lottery {

    public static int[] winnerNumbers() {

        int[] winnerNumbers = new int[5];

        Random rnd = new Random();

        for (int i = 0; i < winnerNumbers.length; i++) {

            int generatedNumber;
            
            do {

                generatedNumber = rnd.nextInt(90) + 1;

            } while (arrayContains(winnerNumbers, generatedNumber));

            winnerNumbers[i] = generatedNumber;
            
        }

        return winnerNumbers;

    }

    public static void arraySort(int[] inputArray) {

        for (int j = 0; j < inputArray.length; j++) {

            for (int i = 0; i < inputArray.length - 1 - j; i++) {

                if (inputArray[i] > inputArray[i + 1]) {

                    int tmp = inputArray[i];
                    inputArray[i] = inputArray[i + 1];
                    inputArray[i + 1] = tmp;

                }

            }

        }

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

    private static int[] userNumbers() {

        Scanner scanner = new Scanner(System.in);
        int[] userNumbers = new int[5];

        for (int i = 0; i < 5; i++) {

            while (userNumbers[i] < 1 || userNumbers[i] > 90) {
                    
                System.out.print("Please enter the " + (i + 1) + " number: ");
                userNumbers[i] = scanner.nextInt();
                
            }

        }
        scanner.nextLine();

        return userNumbers;

    }

    public static void soutArray(int[] inputArray) {

        for (int element : inputArray) {

            System.out.print(element + " ");

        }

    }

    public static void main(String[] args) {

        int[] userNumbers = userNumbers();
        int[] winnerNumbers = winnerNumbers();

        int hits = 0;

        for (int userNumber : userNumbers) {

            if (arrayContains(winnerNumbers, userNumber)) {

                System.out.println("The " + userNumber + " is a hit.");
                hits++;
                System.out.println("You have " + hits + " hit(s).");

            }

        }
        
        arraySort(winnerNumbers);
        
        soutArray(winnerNumbers);
        
        System.out.println("");

    }

}
