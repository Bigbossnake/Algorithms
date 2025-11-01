package com.problem.solving.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when
 * it reads the same backward as forward.
 *
 * Example 1:
 * Input: 121
 * Output: true
 *
 * Example 2:
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-.
 * Therefore it is not a palindrome.
 *
 * Example 3:
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * Follow up:
 *
 * Coud you solve it without converting the integer to a string?
 */
public class PalindromeNumber {

    public boolean isPalindrome(int input) {

        List<Integer> digits = new ArrayList<Integer>();

        if (input < 0) {
            return false;
        }

        while (input > 0) {
            int digit = input % 10;

            digits.add(digit);
            input = input/10;
        }

        int size       = digits.size();
        int rightIndex = 0;
        int leftIndex  = size - 1;
        int middle     = size/2;

        while (rightIndex < middle) {

            if (digits.get(rightIndex).intValue() != digits.get(leftIndex).intValue()) {
                return false;
            }

            rightIndex++;
            leftIndex--;
        }

        return true;
    }

    public static void main (String args[]) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();

        System.out.println("IsPalindrome: " + palindromeNumber.isPalindrome(123));
    }

}
