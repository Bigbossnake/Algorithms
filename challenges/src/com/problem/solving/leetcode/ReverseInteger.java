package com.problem.solving.leetcode;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 *
 * Input: 123
 * Output: 321
 * Example 2:
 *
 * Input: -123
 * Output: -321
 * Example 3:
 *
 * Input: 120
 * Output: 21
 *
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit
 * signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function
 * returns 0 when the reversed integer overflows.
 */
public class ReverseInteger {

    public int reverse(int x) {

        StringBuilder result = new StringBuilder("0");
        boolean isNegative   = false;

        Long reverseDigits;
        Long reverseNumber;
        Long input = (long)x;

        if (input < 0) {
            input = Math.abs(input);
            isNegative = true;
        }

        while (input > 0) {
            reverseDigits = input%10;
            result.append(reverseDigits);

            input = input/10;
        }

        reverseNumber = Long.parseLong(result.toString());

        if (isNegative) {
            reverseNumber = reverseNumber* -1;
        }

        if (reverseNumber > Integer.MAX_VALUE || reverseNumber < Integer.MIN_VALUE) {
            return 0;
        }

        return reverseNumber.intValue();
    }

    public static void main (String args[]) {
        ReverseInteger reverseInteger = new ReverseInteger();

        System.out.println(reverseInteger.reverse(1534236496));
    }

}
