package com.problem.solving.leetcode;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:
 *
 * All given inputs are in lowercase letters a-z.
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] input) {

        StringBuilder longestCommonPrefix = new StringBuilder("");

        if (input.length == 0) {
            return longestCommonPrefix.toString();
        }

        for (int j = 0; j < input[0].length(); j++) {

            boolean isSolution = true;

            for (int k = 0; k < input.length; k++) {

                if (j >= input[k].length() ) {
                    isSolution = false;
                    break;
                }

                if (input[k].charAt(j) != input[0].charAt(j)) {
                    isSolution = false;
                    break;
                }
            }

            if (!isSolution) {
                break;
            }

            longestCommonPrefix.append(input[0].charAt(j));
        }

        return longestCommonPrefix.toString();
    }

}
