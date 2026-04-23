/**
 * You are given a string sentence that consist of words separated by spaces. Each word consists of
 * lowercase and uppercase letters only.
 *
 * <p>We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig
 * Latin.) The rules of Goat Latin are as follows:
 *
 * <p>If a word begins with a vowel ('a', 'e', 'i', 'o', or 'u'), append "ma" to the end of the
 * word. For example, the word "apple" becomes "applema".
 *
 * <p>If a word begins with a consonant (i.e., not a vowel), remove the first letter and append it
 * to the end, then add "ma". For example, the word "goat" becomes "oatgma".
 *
 * <p>Add one letter 'a' to the end of each word per its word index in the sentence, starting with
 * 1.
 *
 * <p>For example, the first word gets "a" added to the end, the second word gets "aa" added to the
 * end, and so on. Return the final sentence representing the conversion from sentence to Goat
 * Latin.
 */
package com.problem.solving.leetcode.problems.strings;

import java.util.Objects;
import java.util.Set;

public class GoatLatin {

  public static final Set<Character> VOWELS = Set.of('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u');

  public String toGoatLatinWord(String word, String endString) {
    StringBuilder goatLatinWord = new StringBuilder();

    if (Objects.isNull(word) || word.isEmpty()) {
      return goatLatinWord.toString();
    }

    String suffix    = "ma";
    char firstLetter = word.charAt(0);
    int startIndex   = VOWELS.contains(firstLetter) ? 0 : 1;

    goatLatinWord.append(word.substring(startIndex));

    if (startIndex == 1) {
      goatLatinWord.append(firstLetter);
    }

    goatLatinWord.append(suffix);
    goatLatinWord.append(endString);

    return goatLatinWord.toString();
  }

  public String toGoatLatin(String sentence) {
    StringBuilder goatLatinSentence = new StringBuilder();

    if (Objects.isNull(sentence) || sentence.isEmpty()) {
      return goatLatinSentence.toString();
    }

    String endChar   = "a";
    String separator = " ";
    StringBuilder endString = new StringBuilder(endChar);

    String[] words = sentence.trim().split(separator);

    for (String word : words) {
      String goatLatinWord = toGoatLatinWord(word, endString.toString());
      goatLatinSentence.append(goatLatinWord);
      goatLatinSentence.append(separator);

      endString.append(endChar);
    }

    return goatLatinSentence.toString().trim();
  }

  public static void main(String[] args) {
    GoatLatin goatLatin = new GoatLatin();
    String testSentence = "over";
    String goatLatinResult = goatLatin.toGoatLatin(testSentence);

    System.out.println("Goat Latin Result: " + goatLatinResult);
  }
}
