/**
 * Write a function that reverses a string. The input string is given as an array of characters s.
 *
 * You must do this by modifying the input array in-place with O(1) extra memory.
 */
package com.problem.solving.leetcode.problems.strings;

import java.util.Arrays;

public class ReverseString {

    public void reverseString(char[] s) {
        int leftIndex  = 0;
        int rightIndex = s.length - 1;

        if (s == null || s.length == 0) {
            return;
        }

        while (leftIndex < rightIndex) {
            char temp = s[leftIndex];

            s[leftIndex]  = s[rightIndex];
            s[rightIndex] = temp;


            leftIndex++;
            rightIndex--;
        }
    }

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        char input[] = {'H', 'E', 'L', 'L', 'O', 'W'};

        reverseString.reverseString(input);
        System.out.println(Arrays.toString(input));
    }

}
