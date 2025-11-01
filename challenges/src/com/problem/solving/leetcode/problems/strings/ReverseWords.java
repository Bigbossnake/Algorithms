/**
 * Given an input string s, reverse the order of the words.
 *
 * A word is defined as a sequence of non-space characters.
 * The words in s will be separated by at least one space.
 *
 * Return a string of the words in reverse order concatenated
 * by a single space.
 *
 * Note that s may contain leading or trailing spaces or multiple spaces between two words.
 * The returned string should only have a single space separating the words.
 * Do not include any extra spaces.
 */
package com.problem.solving.leetcode.problems.strings;

public class ReverseWords {

  public String reverseWords(String input) {
    StringBuilder reverseWords = new StringBuilder();
    input = input.trim();
    final String SPACE_TOKEN = " ";

    String words[] = input.split(SPACE_TOKEN);

    for (int i = words.length - 1; i >= 0; i --) {

      if (!words[i].isBlank()) {
        reverseWords.append(words[i]);

        if (i > 0) {
          reverseWords.append(SPACE_TOKEN);
        }
      }
    }

    return reverseWords.toString();
  }

  public static void main(String args[]) {
    ReverseWords reverseWorker = new ReverseWords();

    String input = "a good   example";
    System.out.println(reverseWorker.reverseWords(input));
  }

}
