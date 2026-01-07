package com.problem.solving.leetcode.problems.backtracking;

import java.util.*;

public class PhoneNumberLetterCombinations {

  private List<String> combinations = new ArrayList<>();
  private static final Map<Integer, String[]> phoneKeyBoard = new HashMap<>();

  static {
    phoneKeyBoard.put(2, new String[]{"a", "b", "c"});
    phoneKeyBoard.put(3, new String[]{"d", "e", "f"});
    phoneKeyBoard.put(4, new String[]{"g", "h", "i"});
    phoneKeyBoard.put(5, new String[]{"j", "k", "l"});
    phoneKeyBoard.put(6, new String[]{"m", "n", "o"});
    phoneKeyBoard.put(7, new String[]{"p", "q", "r", "s"});
    phoneKeyBoard.put(8, new String[]{"t", "u", "v"});
    phoneKeyBoard.put(9, new String[]{"w", "x", "y", "z"});
  }

  public String getCombination(LinkedList<String> track) {
    StringBuilder combination = new StringBuilder();

    for (String key : track) {
      combination.append(key);
    }

    return combination.toString();
  }

  public void combineLetters(String[] letters, LinkedList<String> track, int combinationSize) {

    if (track.size() == combinationSize) {
      combinations.add(getCombination(track));
      return;
    }

    for (int i = 0; i < letters.length; i++) {

      if (track.contains(letters[i])) {
        continue;
      }

      track.add(letters[i]);
      combineLetters(letters, track, combinationSize);
      track.removeLast();
    }

  }

  public List<String> letterCombinations(String digits) {
    int combinationSize = digits.length();

    LinkedList<String> track     = new LinkedList<>();
    List<String> possibleLetters = new ArrayList<>();

    for (int i = 0; i < digits.length(); i++) {
      int currentDigit = digits.charAt(i) - '0';
      possibleLetters.addAll(Arrays.asList(phoneKeyBoard.get(currentDigit)));
    }

    combinations.clear();
    combineLetters(possibleLetters.toArray(new String[0]), track, combinationSize);

    return combinations;
  }

  public static void main(String[] args) {
    PhoneNumberLetterCombinations phoneNumberLetterCombinations = new PhoneNumberLetterCombinations();

    List<String> letterCombinations = phoneNumberLetterCombinations.letterCombinations("23");

    for (String letter : letterCombinations) {
      System.out.print(letter + ", ");
    }
  }

}
