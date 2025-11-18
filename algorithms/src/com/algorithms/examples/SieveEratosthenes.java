package com.algorithms.examples;

import java.util.Hashtable;
import java.util.Scanner;

public class SieveEratosthenes
{
    public static final int NOT_A_PRIME_NUMBER    = -1;
    public static final int POSSIBLE_PRIME_NUMBER = 0;
    public static final int IS_PRIME_NUMBER       = 1;

    public static void sieveOfEratosthenes(int limit)
    {
        int possiblePrimeNumber  = 2;
        Hashtable<Integer, Integer> primeNumbers = new Hashtable<Integer, Integer>();

        System.out.println("\nRunning sieveOfEratosthenes");

        //Mark The Prime Numbers As Possible PrimeNumbers
        for (int i = 2; i <=limit; i++)
            primeNumbers.put(i, POSSIBLE_PRIME_NUMBER);

        do
        {
            if (primeNumbers.get(possiblePrimeNumber) == POSSIBLE_PRIME_NUMBER)
            {
                primeNumbers.computeIfPresent(possiblePrimeNumber, (key, value) -> value = IS_PRIME_NUMBER);

                int primeNumberMultipliers = possiblePrimeNumber * 2;

                //Optional Condition for (int i = primeNumberMultipliers; i < limit/possiblePrimeNumber; i+= possiblePrimeNumber)
                while (primeNumberMultipliers <= limit)
                {
                    primeNumbers.computeIfPresent(primeNumberMultipliers, (key, value) -> value = NOT_A_PRIME_NUMBER);

                    primeNumberMultipliers += possiblePrimeNumber;
                }
            }

            possiblePrimeNumber++;
        }
        while (Math.pow(possiblePrimeNumber, 2) < limit);

        primeNumbers.forEach((key, value) ->
        {
            if (primeNumbers.get(key) != NOT_A_PRIME_NUMBER)
                System.out.print(key + " ");
        });
    }

    public static void main(String args[])
    {
        System.out.println("****************************************\n" +
                           "*    ORALCE PRIME NUMBERS CHALLENGE    *\n" +
                           "****************************************\n");

        System.out.println("Introduce The Limit For The PrimeNumbers");
        Scanner input = new Scanner(System.in);
        int limit     = input.nextInt();

        sieveOfEratosthenes(limit);
    }
}

