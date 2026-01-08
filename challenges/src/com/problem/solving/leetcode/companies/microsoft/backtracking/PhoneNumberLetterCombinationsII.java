package com.problem.solving.leetcode.companies.microsoft.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumberLetterCombinationsII {

  private static final Map<Character, String> phoneKeyBoard = new HashMap<>();

  static {
    phoneKeyBoard.put('2', "abc");
    phoneKeyBoard.put('3', "def");
    phoneKeyBoard.put('4', "ghi");
    phoneKeyBoard.put('5', "jkl");
    phoneKeyBoard.put('6', "mno");
    phoneKeyBoard.put('7', "pqrs");
    phoneKeyBoard.put('8', "tuv");
    phoneKeyBoard.put('9', "wxyz");
  }

  private List<String> combinations = new ArrayList<>();
  private String phoneDigits;

  private void combineLetters(int index, StringBuilder path) {

    if (path.length() == phoneDigits.length()) {
      combinations.add(path.toString());
      return;
    }

    String possibleLetters = phoneKeyBoard.get(phoneDigits.charAt(index));

    for (char letter : possibleLetters.toCharArray()) {
      path.append(letter);
      combineLetters(index + 1, path);
      path.deleteCharAt(path.length() - 1);
    }
  }

  public List<String> letterCombinations(String digits) {

    if (digits.length() == 0) {
      return combinations;
    }

    phoneDigits = digits;
    combineLetters(0, new StringBuilder());

    return combinations;
  }

  public static void main(String[] args) {
    PhoneNumberLetterCombinationsII phoneNumberLetterCombinations = new PhoneNumberLetterCombinationsII();

    List<String> letterCombinations = phoneNumberLetterCombinations.letterCombinations("23");

    for (String letter : letterCombinations) {
      System.out.print(letter + ", ");
    }
  }
}
