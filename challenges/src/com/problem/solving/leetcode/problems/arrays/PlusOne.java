/**
 * You are given a large integer represented as an integer array digits, where each digits[i]
 * is the ith digit of the integer. The digits are ordered from most significant to least
 * significant in left-to-right order. The large integer does not contain any leading 0's.
 *
 * Increment the large integer by one and return the resulting array of digits.
 */
package com.problem.solving.leetcode.problems.arrays;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlusOne {

    public int[] plusOne_II(int[] digits) {

        if (digits[digits.length - 1] > 9) {
            digits[digits.length - 1]+=1;

            return digits;
        }

        for (int i = digits.length - 1; i >= 0; i--) {
            int digit = digits[i];

            if (digit == 9) {
                digits[i] = 0;
            }

            else {
                digits[i]+=1;
                return digits;
            }
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;

        return digits;
    }

    public int[] plusOne(int[] digits) {
        List<Integer> plusOneNumberList  = new ArrayList<>();

        int base                 = 10;
        int exponent             = digits.length - 1;
        BigInteger plusOneNumber = BigInteger.valueOf(0);
        BigInteger digitPow      = BigInteger.valueOf(base);


        for (int digit : digits) {
            BigInteger number = digitPow.pow(exponent).multiply(BigInteger.valueOf(digit));
            plusOneNumber = plusOneNumber.add(number);

            exponent--;
        }

        plusOneNumber = plusOneNumber.add(BigInteger.valueOf(1));
        System.out.println(plusOneNumber);

        while (plusOneNumber.compareTo(BigInteger.ZERO) > 0) {
            plusOneNumberList.add(plusOneNumber.mod(BigInteger.TEN).intValue());

            plusOneNumber = plusOneNumber.divide(BigInteger.TEN);
        }

        return plusOneNumberList.reversed()
                .parallelStream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        int[] inputString = {9,9,9};

        System.out.println(Arrays.toString(plusOne.plusOne_II(inputString)));
    }

}
