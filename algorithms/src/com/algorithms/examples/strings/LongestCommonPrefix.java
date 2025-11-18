/**
 * Write a function to find the longest common prefix string amongst an array of strings. If there
 * is no common prefix, return an empty string “”.
 *
 * <p>eg 1: Input: strs = ["flower","flow","flight"] Output: “fl”
 *
 * <p>eg 2: Input: strs = [“dog”,”racecar”,”car”] Output: “” Explanation: There is no common prefix
 * among the input strings.
 *
 * <p>0<=len<=10000
 */
package com.algorithms.examples.strings;

class LongestCommonPrefix_II {

  public String longestCommonPrefix(String[] strs) {

    StringBuilder solution = new StringBuilder();

    if (strs == null || strs.length == 0) {
      return solution.toString();
    }

    if (strs.length == 1) {
      return strs[0];
    }

    boolean appendChar = true;
    String currentWord = null;

    for (int i = 0; i < strs[0].length(); i++) {
      char currentLetter = strs[0].charAt(i);

      for (int j = i; j < strs.length; j++) {
        currentWord = strs[j];

        if (i < currentWord.length() && currentWord.charAt(i) != currentLetter) {
          appendChar = false;
        }
      }

      if (appendChar) {
        solution.append(currentWord.charAt(i));
      }
    }

    return solution.toString();
  }

  public static void main(String args[]) {
    LongestCommonPrefix_II solution = new LongestCommonPrefix_II();
    String[] strs = {"dog", "racecar", "car"};

    String result = solution.longestCommonPrefix(strs);
    System.out.println(result);
  }
}

public class LongestCommonPrefix {

  public String longestCommonPrefix(String[] strs) {

    StringBuilder solution = new StringBuilder();

    if (strs == null || strs.length == 0) {
      return solution.toString();
    }

    if (strs.length == 1) {
      return strs[0];
    }

    boolean appendChar = true;
    String currentWord = null;

    for (int i = 0; i < strs[0].length(); i++) {
      char currentLetter = strs[0].charAt(i);

      for (int j = i; j < strs.length; j++) {
        currentWord = strs[j];

        if (i < currentWord.length() && currentWord.charAt(i) != currentLetter) {
          appendChar = false;
        }
      }

      if (appendChar) {
        solution.append(currentWord.charAt(i));
      }
    }

    return solution.toString();
  }

  public static void main(String args[]) {
    LongestCommonPrefix solution = new LongestCommonPrefix();
    String[] strs = {"dog", "racecar", "car"};

    String result = solution.longestCommonPrefix(strs);
    System.out.println(result);
  }
}
