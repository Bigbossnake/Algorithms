/**
 * Given a character array s, reverse the order of the words.
 *
 * A word is defined as a sequence of non-space characters. T
 * he words in s will be separated by a single space.
 *
 * Your code must solve the problem in-place, i.e. without allocating extra space.
 */
package com.problem.solving.leetcode.companies.microsoft.arrays;

import java.util.Arrays;

public class ReverseWordsII {

    public void reverserString(int leftIndex, int rightIndex, char[] input) {

        while (leftIndex < rightIndex) {
            char tmp = input[leftIndex];

            input[leftIndex]  = input[rightIndex];
            input[rightIndex] = tmp;

            leftIndex++;
            rightIndex--;
        }

    }

    public void reverseWords(char[] s) {
        final char BLANK_SPACE = ' ';

        int leftIndex  = 0;
        int rightIndex = s.length - 1;

        reverserString(leftIndex, rightIndex, s);

        int index      = 0;
        int wordLength = 0;
        int length     = s.length - 1;

        while(index < length) {
            char currentChar = s[index];

            if (currentChar != BLANK_SPACE) {
                index++;
                wordLength++;
                continue;
            }

            leftIndex  = index - wordLength;
            rightIndex = index - 1;
            reverserString(leftIndex, rightIndex, s);

            index++;
            wordLength = 0;
        }

        if (wordLength > 0) {
            leftIndex  = index - wordLength;
            rightIndex = index;

            reverserString(leftIndex, rightIndex, s);
        }
    }

    public static void main(String[] args) {
        ReverseWordsII reverseWordsII = new ReverseWordsII();
        char[] input = {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};

        System.out.println(Arrays.toString(input));
        reverseWordsII.reverseWords(input);
        System.out.println(Arrays.toString(input));
    }
}
