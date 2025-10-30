package com.problem.solving.leetcode;

import java.util.Hashtable;
import java.util.Map;

public class MostRepeatedChar {

  public int mostRepeated(String input) {
    int mostRepeated = 0;

    if (input == null || input.isBlank()) {
      return mostRepeated;
    }

    Map<Character, Integer> repeatedChars = new Hashtable<>();
    for (int i = 0; i < input.length(); i++) {
      char currentChar = input.charAt(i);

      if (!repeatedChars.containsKey(currentChar)) {
        repeatedChars.put(currentChar, 1);

        if (mostRepeated == 0) {
          mostRepeated = 1;
        }
        continue;
      }

      int numberOfTimes = repeatedChars.get(currentChar) + 1;
      repeatedChars.put(currentChar, numberOfTimes);

      if (mostRepeated < numberOfTimes) {
        mostRepeated = numberOfTimes;
      }
    }

    return mostRepeated;
  }

  public static void main(String args[]) {
    String input = "aab";
    MostRepeatedChar mostRepeatedChar = new MostRepeatedChar();

    System.out.println(mostRepeatedChar.mostRepeated(input));
  }
}
