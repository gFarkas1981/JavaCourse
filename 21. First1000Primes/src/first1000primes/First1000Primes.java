package first1000primes;

public class First1000Primes {

    public static void main(String[] args) {

        int primeCounter = 6;
        boolean isPrime = true;

        System.out.println("First 1000 Prime number:");
        System.out.println("1. prime number is: 2");
        System.out.println("2. prime number is: 3");
        System.out.println("3. prime number is: 5");
        System.out.println("4. prime number is: 7");
        System.out.println("5. prime number is: 11");

        int possiblePrime = 12;

        while (primeCounter <= 1000) {

            isPrime = true;

            for (int divisor = 2; divisor < (possiblePrime / 2); divisor++) {

                if (possiblePrime % divisor == 0) {

                    isPrime = false;
                    break;

                }

            }

            if (isPrime) {

                System.out.println(primeCounter + ". prime number is: " + possiblePrime);
                primeCounter++;

            }

            possiblePrime++;

        }

    }

}
