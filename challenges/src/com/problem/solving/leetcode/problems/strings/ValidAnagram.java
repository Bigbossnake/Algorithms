/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 */
package com.problem.solving.leetcode.problems.strings;

import java.util.Hashtable;
import java.util.Map;

public class ValidAnagram {

    public boolean isAnagram_II(String s, String t) {
        boolean isAnagram = true;
        int [] counterLetter = new int[26];

        if (s.length() != t.length()) {
            return !isAnagram;
        }

        for (int i = 0; i < s.length(); i++) {
            counterLetter[s.charAt(i) - 'a']++;
            counterLetter[t.charAt(i) - 'a']--;
        }

        for (int counter : counterLetter) {
            if (counter != 0) {
                isAnagram = false;
                break;
            }
        }

        return isAnagram;
    }

    public boolean isAnagram(String s, String t) {
        boolean isAnagram = true;
        Map<Character, Integer> anagramLetters = new Hashtable<>();
        int sLength = s.length();
        int tLength = t.length();

        if (sLength != tLength) {
            return !isAnagram;
        }

        for (int i = 0; i < sLength; i++) {
            char currentChar = s.charAt(i);

            if (!anagramLetters.containsKey(currentChar)) {
                anagramLetters.put(currentChar, 1);
                continue;
            }

            anagramLetters.put(currentChar, anagramLetters.get(currentChar) + 1);
        }

        for (int j = 0; j < tLength; j++) {
            char currentChar = t.charAt(j);

            if (!anagramLetters.containsKey(currentChar)) {
                isAnagram = false;
                break;
            }

            int availableLetters = anagramLetters.get(currentChar) - 1;

            if (availableLetters < 0) {
                isAnagram = false;
                break;
            }

            anagramLetters.put(currentChar, availableLetters);
        }


        return isAnagram;
    }

    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        String s = "ab";
        String t = "a";

        System.out.println(validAnagram.isAnagram(s, t));
    }

}
