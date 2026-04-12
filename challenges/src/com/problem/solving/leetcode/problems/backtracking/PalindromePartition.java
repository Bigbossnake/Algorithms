/**
 * Given a string s, partition s such that every substring of the partition is a palindrome. Return
 * all possible palindrome partitioning of s.
 */
package com.problem.solving.leetcode.problems.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PalindromePartition {

  private boolean isPalindrome(String input) {
    boolean isPalindrome = true;

    int startIndex = 0;
    int endIndex   = input.length() - 1;

    while (startIndex < endIndex) {

      if (input.charAt(startIndex) != input.charAt(endIndex)) {
        return !isPalindrome;
      }

      startIndex++;
      endIndex--;
    }

    return isPalindrome;
  }

  private void generatePalindromes(String input, int inputSize, int startIndex,
                                   LinkedList<String> palindrome, List<List<String>> palindromes) {

    if (startIndex >= inputSize) {
      palindromes.add(new ArrayList(palindrome));
    }

    for (int endIndex = startIndex; endIndex < inputSize; endIndex++) {
      String subString = input.substring(startIndex, endIndex + 1);

      if (isPalindrome(subString)) {
        palindrome.add(subString);
        generatePalindromes(input, inputSize, endIndex + 1, palindrome, palindromes);
        palindrome.removeLast();
      }
    }
  }

  public List<List<String>> partition(String s) {

    LinkedList<String> palindrome = new LinkedList<>();
    List<List<String>> palindromes = new ArrayList<>();
    int startIndex = 0;
    int inputSize  = s.length();

    generatePalindromes(s, inputSize, startIndex, palindrome, palindromes);

    return palindromes;
  }

  public static void main(String[] args) {
    PalindromePartition palindromePartition = new PalindromePartition();
    String input = "aab";

    System.out.println(palindromePartition.partition(input));
  }
}
