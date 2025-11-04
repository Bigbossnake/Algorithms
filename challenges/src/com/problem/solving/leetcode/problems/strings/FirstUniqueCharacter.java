/**
 * Given a string s, find the first non-repeating character in it and return its index.
 * If it does not exist, return -1.
 */
package com.problem.solving.leetcode.problems.strings;

import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueCharacter {

    public int firstUniqChar_II(String s) {
        int firstUniqueChar = -1;
        Hashtable<Character, Integer> charRepetitions = new Hashtable<>();

        if (s == null || s.isBlank()) {
            return firstUniqueChar;
        }

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (!charRepetitions.containsKey(currentChar)) {
                charRepetitions.put(currentChar, 1);
                continue;
            }

            charRepetitions.put(currentChar, charRepetitions.get(currentChar) + 1);
        }

        for (int j = 0; j < s.length(); j++) {
            char currentChar = s.charAt(j);

            if (charRepetitions.get(currentChar) == 1) {
                firstUniqueChar = j;
                break;
            }
        }

        return firstUniqueChar;
    }

    public int firstUniqChar(String s) {
        int firstUniqueChar = -1;
        LinkedHashMap<Character, Integer> charPosition = new LinkedHashMap<>();

        if (s == null || s.isBlank()) {
            return firstUniqueChar;
        }

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (!charPosition.containsKey(currentChar)) {
                charPosition.put(currentChar, i);
                continue;
            }

            charPosition.put(currentChar, -1);
        }

        for (Map.Entry<Character, Integer> entry : charPosition.entrySet()) {
            if (entry.getValue() >= 0) {
                return entry.getValue();
            }
        }

        return firstUniqueChar;
    }

    public static void main(String[] args) {
        FirstUniqueCharacter firstUniqueCharacter = new FirstUniqueCharacter();
        String input = "aadadaad";

        System.out.println(firstUniqueCharacter.firstUniqChar(input));
    }

}
