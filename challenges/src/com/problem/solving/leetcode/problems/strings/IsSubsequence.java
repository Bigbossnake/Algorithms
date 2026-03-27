package com.problem.solving.leetcode.problems.strings;

/**
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 *
 * <p>A subsequence of a string is a new string that is formed from the original string by deleting
 * some (can be none) of the characters without disturbing the relative positions of the remaining
 * characters.
 *
 * <p>(i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 */
public class IsSubsequence {

  public boolean isSubsequence(String s, String t) {

    boolean isSubsequence = true;
    int sIndex  = 0;
    int sLength = s.length();
    int tIndex  = 0;

    if (s.isEmpty()) {
      return isSubsequence;
    }

    while (tIndex < t.length()) {
      char currentSChar = s.charAt(sIndex);
      char currentTChar = t.charAt(tIndex);

      if (currentSChar == currentTChar) {
        sIndex++;

        if (sIndex == sLength) {
          return isSubsequence;
        }
      }

      tIndex++;
    }

    return !isSubsequence;
  }

  public static void main(String[] args) {
    IsSubsequence isSubsequence = new IsSubsequence();
    String s = "abc";
    String t = "ahbgdc";

    System.out.println(isSubsequence.isSubsequence(s, t));
  }
}
