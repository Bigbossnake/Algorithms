package com.problem.solving.leetcode;


/**
 * Given a string s, find the longest palindromic substring in s.
 * You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 *
 * RESPONSE: Manachers - Algorithm
 */
public class LongestPalindrome {

    public String longestPalindrome(String input) {

        String EMPTY_STRING = "";
        int currentIndex    = 0;
        int inputLength     = input.length();

        StringBuilder currentPalindrome = new StringBuilder(EMPTY_STRING);
        StringBuilder longestPalindrome = new StringBuilder(EMPTY_STRING);

        if (input.length() == 1 || input.isEmpty()) {
            return input;
        }

        while (currentIndex < inputLength) {

            currentPalindrome.append(input.charAt(currentIndex));
            currentIndex++;

            if (currentPalindrome.toString().equals(currentPalindrome.reverse().toString()) &&
                    longestPalindrome.length() < currentPalindrome.length()) {

                longestPalindrome = new StringBuilder(currentPalindrome.toString());

                continue;
            }

            currentIndex--;
            currentPalindrome = new StringBuilder(EMPTY_STRING);
            currentPalindrome.append(input.charAt(currentIndex));
            currentIndex++;
        }


        return longestPalindrome.toString();
    }

    public static void main (String args[]) {
        LongestPalindrome palindrome = new LongestPalindrome();

        System.out.println(palindrome.longestPalindrome("babad"));
    }
}
