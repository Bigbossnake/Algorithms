/**
 * Given an input string (s) and a pattern (p), implement wildcard pattern
 * matching with support for '?' and '*' where:
 *
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 *
 * The matching should cover the entire input string (not partial).
 */
package com.problem.solving.leetcode.problems.backtracking;

public class WildcardMatching {

  public boolean isMatch(String input, String pattern) {
    int inputLength   = input.length();
    int patternLength = pattern.length();

    // base cases
    if (pattern.equals(input)) {
      return true;
    }

    if (patternLength > 0 && pattern.chars().allMatch(c -> c == '*')) {
      return true;
    }

    if (pattern.isEmpty() || input.isEmpty()) {
      return false;
    }

    // init all matrix except [0][0] element as False
    boolean[][] solutions = new boolean[patternLength + 1][inputLength + 1];
    solutions[0][0] = true;

    // DP compute
    for (int patternIndex = 1; patternIndex < patternLength + 1; patternIndex++) {

      // the current character in the pattern is '*'
      if (pattern.charAt(patternIndex - 1) == '*') {
        int inputIndex = 1;

        // d[p_idx - 1][s_idx - 1] is a string-pattern match
        // on the previous step, i.e. one character before.
        // Find the first idx in string with the previous math.
        while ((!solutions[patternIndex - 1][inputIndex - 1]) && (inputIndex < inputLength + 1)) {
          inputIndex++;
        }

        // If (string) matches (pattern),
        // when (string) matches (pattern)* as well
        solutions[patternIndex][inputIndex - 1] = solutions[patternIndex - 1][inputIndex - 1];

        // If (string) matches (pattern),
        // when (string)(whatever_characters) matches (pattern)* as well
        while (inputIndex < inputLength + 1) {
          solutions[patternIndex][inputIndex++] = true;
        }

        // the current character in the pattern is '?'
      }

      else if (pattern.charAt(patternIndex - 1) == '?') {

        for (int inputIndex = 1; inputIndex < inputLength + 1; inputIndex++) {
          solutions[patternIndex][inputIndex] = solutions[patternIndex - 1][inputIndex - 1];
        }

        // the current character in the pattern is not '*' or '?'
      }

      else {
        for (int inputIndex = 1; inputIndex < inputLength + 1; inputIndex++) {
          // Match is possible if there is a previous match
          // and current characters are the same
          solutions[patternIndex][inputIndex] = solutions[patternIndex - 1][inputIndex - 1] &&
              (pattern.charAt(patternIndex - 1) == input.charAt(inputIndex - 1));
        }
      }
    }

    return solutions[patternLength][inputLength];
  }

}
