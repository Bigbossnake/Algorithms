package com.problem.solving.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubString {

    public int lengthOfLongestSubstring(String input) {

        Map<Character, Integer> dictionary = new HashMap<>();
        int start=0, len=0;

        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);

            if (dictionary.containsKey(letter)) {

                if (dictionary.get(letter) >= start)  {
                    start = dictionary.get(letter) + 1;
                }
            }

            len = Math.max(len, i-start+1);
            dictionary.put(letter, i);
        }

        return len;
    }
}
