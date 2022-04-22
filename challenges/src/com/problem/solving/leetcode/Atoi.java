package com.problem.solving.leetcode;

/**
 * Implement atoi which converts a string to an integer.
 *
 * The function first discards as many whitespace characters as necessary
 * until the first non-whitespace character is found. Then, starting from
 * this character, takes an optional initial plus or minus sign followed by
 * as many numerical digits as possible, and interprets them as a numerical
 * value.
 *
 * The string can contain additional characters after those that form the
 * integral number, which are ignored and have no effect on the behavior
 * of this function.
 *
 * If the first sequence of non-whitespace characters in str is not a valid
 * integral number, or if no such sequence exists because either str is empty
 * or it contains only whitespace characters, no conversion is performed.
 *
 * If no valid conversion could be performed, a zero value is returned.
 *
 * Note:
 *
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers
 * within the 32-bit signed integer range: [−231,  231 − 1].
 * If the numerical value is out of the range of representable
 * values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
 *
 * Example 1:
 *
 * Input: "42"
 * Output: 42
 * Example 2:
 *
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus sign.
 *              Then take as many numerical digits as possible, which gets 42.
 * Example 3:
 *
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 * Example 4:
 *
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a numerical
 *              digit or a +/- sign. Therefore no valid conversion could be performed.
 * Example 5:
 *
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
 *              Thefore INT_MIN (−231) is returned.
 */
public class Atoi {

    public int myAtoi(String input) {

        int index   = 0;
        Long result = 0L;
        boolean isNegative = false;

        input = input.trim();

        if (input.isEmpty()) {
            return result.intValue();
        }

        if (Character.isAlphabetic(input.charAt(index))
                && input.charAt(index) != '-'
                && input.charAt(index) != '+') {
            return result.intValue();
        }

        if (input.charAt(index) == '-' || input.charAt(index) == '+') {

            if (input.charAt(index) == '-') {
                isNegative = true;
            }

            index = 1;
        }

        int length = input.length();
        while (index < length) {

            char digit = input.charAt(index);

            if (Character.isDigit(digit)) {

                int digitValue = (digit - '0');
                result = result * 10;

                if (isNegative) {
                    result = result - digitValue;

                    if (result < Integer.MIN_VALUE) {
                        return Integer.MIN_VALUE;
                    }

                }

                else {
                    result = result + digitValue;

                    if (result > Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    }
                }

            }

            else  {
                return result.intValue();
            }

            index++;
        }

        return result.intValue();
    }

    public static void main (String args[]) {
        Atoi converter = new Atoi();

        System.out.println(converter.myAtoi("123"));
    }

}
