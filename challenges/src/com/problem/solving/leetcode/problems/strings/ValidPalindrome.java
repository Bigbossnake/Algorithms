/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
 * and removing all non-alphanumeric characters, it reads the same forward and backward.
 * Alphanumeric characters include letters and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 */
package com.problem.solving.leetcode.problems.strings;

public class ValidPalindrome {

    public boolean isPalindrome_III(String s) {

        boolean isPalindrome = true;
        int leftIndex        = 0;
        int rightIndex       = s.length() - 1;

        while (leftIndex < rightIndex) {

            while (leftIndex < rightIndex && !Character.isLetterOrDigit(s.charAt(leftIndex))) {
                leftIndex++;
            }

            while (leftIndex < rightIndex && !Character.isLetterOrDigit(s.charAt(rightIndex))) {
                rightIndex--;
            }

            if (Character.toUpperCase(s.charAt(leftIndex)) != Character.toUpperCase(s.charAt(rightIndex))) {
                isPalindrome = false;
                break;
            }

            leftIndex++;
            rightIndex--;
        }

        return isPalindrome;
    }

    public boolean isPalindrome_II(String s) {

        boolean isPalindrome = true;
        int leftIndex  = 0;
        int rightIndex = s.length() - 1;

        while (leftIndex < rightIndex) {

            if (!Character.isLetterOrDigit(s.charAt(leftIndex))) {
                leftIndex++;
                continue;
            }

            if (!Character.isLetterOrDigit(s.charAt(rightIndex))) {
                rightIndex--;
                continue;
            }

            if (Character.toUpperCase(s.charAt(leftIndex)) != Character.toUpperCase(s.charAt(rightIndex))) {
                isPalindrome = false;
                break;
            }

            leftIndex++;
            rightIndex--;
        }

        return isPalindrome;
    }

    public boolean isPalindrome(String s) {
        boolean isPalindrome = true;
        StringBuilder palindromeString = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (Character.isLetterOrDigit(currentChar)) {
                palindromeString.append(Character.toUpperCase(currentChar));
            }
        }

        int leftIndex  = 0;
        int rightIndex = palindromeString.length() - 1;

        while (leftIndex < rightIndex) {
            if (palindromeString.charAt(leftIndex) != palindromeString.charAt(rightIndex)) {
                isPalindrome = false;
                break;
            }

            leftIndex++;
            rightIndex--;
        }

        return isPalindrome;
    }

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        String input = "race a car";

        System.out.println(validPalindrome.isPalindrome_III(input));
    }

}
