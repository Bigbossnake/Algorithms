/**
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes
 * the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 *
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 */
package com.problem.solving.leetcode.problems.strings;

public class ReverseInteger {

    public int reverse(int x) {
        StringBuilder reverseNumber = new StringBuilder();
        boolean isNegative = false;
        int result = 0;

        try {
            if (x == 0) {
                return x;
            }

            if (x < 0) {
                x *= -1;
                isNegative = true;
            }

            while (x > 0) {
                int digit = x % 10;
                reverseNumber.append(digit);

                x = x/10;
            }

            result = Integer.parseInt(reverseNumber.toString());

            if (isNegative) {
                return -result;
            }

        } catch (NumberFormatException e) {
            return result;
        }

        return result;
    }

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        int input = 1534236469;

        System.out.println(reverseInteger.reverse(input));
    }
}
