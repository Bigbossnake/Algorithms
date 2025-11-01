package com.problem.solving.leetcode.problems.strings;

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
 */
public class LongestPalindromeManachers {

  public String getSubstring(String str, int left, int right) {
    StringBuilder result = new StringBuilder("");

    for (int i = left; i <= right; i++) {
         result.append(str.charAt(i));
    }

    return result.toString();
  }

  // Implementation of Manacher's Algorithm
  public String longestPalindrome(String input) {

    int strLen = 2 * input.length() + 3;
    char[] sChars = new char[strLen];

    sChars[0]          = '@';
    sChars[strLen - 1] = '$';

    int t = 1;
    for (char c : input.toCharArray()) {
      sChars[t++] = '#';
      sChars[t++] = c;
    }
    sChars[t] = '#';

    int maxLen   = 0;
    int start    = 0;
    int maxRight = 0;
    int center   = 0;
    int[] p = new int[strLen];

    for (int i = 1; i < strLen - 1; i++) {

      if (i < maxRight) {
        p[i] = Math.min(maxRight - i, p[2 * center - i]);
      }

      // Expanding along the center
      while (sChars[i + p[i] + 1] == sChars[i - p[i] - 1]) {
        p[i]++;
      }

      // Updating center and its bound
      if (i + p[i] > maxRight) {
        center = i;
        maxRight = i + p[i];
      }

      // Updating ans
      if (p[i] > maxLen) {
        start = (i - p[i] - 1) / 2;
        maxLen = p[i];
      }
    }

    return getSubstring(input, start, start + maxLen - 1);
  }
}
