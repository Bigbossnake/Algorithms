/***
 * Given a string s consisting of words and spaces, return the length of the last word in the string.
 *
 * A word is a maximal substring consisting of non-space characters only.
 */
package com.problem.solving.leetcode.problems.strings;

public class LengthOfLastWord {

  private static final char SEPARATOR = ' ';

  public int lengthOfLastWord(String s) {
    s = s.trim();
    int index = s.length() - 1;
    StringBuilder lastWord = new StringBuilder("");

    while (index >= 0) {
      char currentChar = s.charAt(index);

      if (currentChar == SEPARATOR) {
        break;
      }

      lastWord.append(currentChar);
      index--;
    }

    return lastWord.toString().length();
  }
}
