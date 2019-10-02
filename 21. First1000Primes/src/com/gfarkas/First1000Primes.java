package com.gfarkas;

public class First1000Primes {

    public static boolean isPrime(int number) {
        
        boolean isPrime = true;
        
        for (int i = 2; i <= number / 2; i++) {
            
            if (number % i == 0) {
                
                isPrime = false;
                break;
                
            }
            
        }

        return isPrime;

    }
    
    public static void main(String[] args) {

        int primeCounter = 6;

        System.out.println("First 1000 Prime number:");
        System.out.println("1. prime number is: 2");
        System.out.println("2. prime number is: 3");
        System.out.println("3. prime number is: 5");
        System.out.println("4. prime number is: 7");
        System.out.println("5. prime number is: 11");

        int possiblePrime = 12;

        while (primeCounter <= 1000) {

            if (isPrime(possiblePrime)) {

                System.out.println(primeCounter + ". prime number is: " + possiblePrime);
                primeCounter++;

            }

            possiblePrime++;

        }

    }

}
