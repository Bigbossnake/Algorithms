/**
 * Given an input string s, reverse the order of the words.
 *
 * A word is defined as a sequence of non-space characters.
 * The words in s will be separated by at least one space.
 *
 * Return a string of the words in reverse order concatenated by a single space.
 *
 * Note that s may contain leading or trailing spaces or multiple spaces between
 * two words. The returned string should only have a single space separating the words.
 * Do not include any extra spaces.
 */
package com.problem.solving.leetcode.companies.microsoft.arrays;

public class ReverseWords {

    public String reverseWords_II(String words) {
        StringBuilder currentWord   = new StringBuilder();
        StringBuilder reversedWords = new StringBuilder();
        final char BLANK_SPACE      = ' ';

        words = words.trim();
        for (int i = 0; i < words.length(); i++) {
            char currentChar = words.charAt(i);

            if (currentChar != BLANK_SPACE) {
                currentWord.append(currentChar);
                continue;
            }

            if (!currentWord.isEmpty()) {
                currentWord.insert(0, BLANK_SPACE);
                reversedWords.insert(0, currentWord.toString());
                currentWord = new StringBuilder();
            }
        }

        if (!currentWord.isEmpty()) {
            reversedWords.insert(0, currentWord.toString());
            reversedWords.append(BLANK_SPACE);
        }

        return reversedWords.toString().trim();
    }

    public String reverseWords(String input) {
        final String BLANK_SPACE = " ";
        StringBuilder reversed   = new StringBuilder();

        if (input == null || input.isBlank()) {
            return input;
        }

        input = input.trim();
        String[] words = input.split(BLANK_SPACE);
        int index      = words.length - 1;

        for (int i = index; i >= 0; i--) {
            String word = words[i];

            if (!word.isEmpty()) {
                reversed.append(word);
                reversed.append(BLANK_SPACE);
            }
        }

        return reversed.toString().trim();
    }

    public static void main(String[] args) {
        ReverseWords rw = new ReverseWords();
        String input = "a good   example";

        System.out.println(rw.reverseWords_II(input));
    }

}
