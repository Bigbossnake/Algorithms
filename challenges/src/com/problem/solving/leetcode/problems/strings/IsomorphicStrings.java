package com.problem.solving.leetcode.problems.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

  public boolean isIsomorphic(String s, String t) {
    int inputSize = s.length();
    char defaultValue = '*';
    Map<Character, Character> replacementMap = new HashMap<>();
    StringBuilder isomorphicString = new StringBuilder(s);

    for (int i = 0; i < inputSize; i++) {
      char currentCharS = s.charAt(i);
      char currentCharT = t.charAt(i);

      if (!replacementMap.containsKey(currentCharS)
          && !replacementMap.containsValue(currentCharT)) {
        replacementMap.put(currentCharS, currentCharT);
        continue;
      }

      if (!replacementMap.containsKey(currentCharS)) {
        replacementMap.put(currentCharS, defaultValue);
      }
    }

    for (int j = 0; j < inputSize; j++) {
      char currentChar = isomorphicString.charAt(j);
      char replacement = replacementMap.get(currentChar);

      isomorphicString.setCharAt(j, replacement);
    }

    return isomorphicString.toString().equalsIgnoreCase(t);
  }

  public boolean isIsomorphicOptimized(String s, String t) {
    int inputSize     = s.length();
    char defaultValue = '*';
    Map<Character, Character> replacementMap = new HashMap<>();
    StringBuilder isomorphicString = new StringBuilder(s);

    for (int i = 0; i < inputSize; i++) {
      char currentCharS = s.charAt(i);
      char currentCharT = t.charAt(i);

      if (!replacementMap.containsKey(currentCharS)
          && !replacementMap.containsValue(currentCharT)) {
        replacementMap.put(currentCharS, currentCharT);
        isomorphicString.setCharAt(i, currentCharT);
      }

      else if (replacementMap.containsKey(currentCharS)) {
        char replacement = replacementMap.get(currentCharS);
        isomorphicString.setCharAt(i, replacement);
      }

      else {
        replacementMap.put(currentCharS, defaultValue);
        isomorphicString.setCharAt(i, defaultValue);
      }
    }

    return isomorphicString.toString().equalsIgnoreCase(t);
  }

  public boolean isIsomorphicOptimizedII(String s, String t) {
    int inputSize        = s.length();
    int defaultValue     = -1;
    boolean isIsomorphic = true;

    int[] mappingDictStoT = new int[256];
    Arrays.fill(mappingDictStoT, defaultValue);

    int[] mappingDictTtoS = new int[256];
    Arrays.fill(mappingDictTtoS, defaultValue);

    for (int i = 0; i < inputSize; i++) {
      char currentS = s.charAt(i);
      char currentT = t.charAt(i);

      if (mappingDictStoT[currentS] == -1 && mappingDictTtoS[currentT] == -1) {
        mappingDictStoT[currentS] = currentT;
        mappingDictTtoS[currentT] = currentS;
      }

      if (!(mappingDictStoT[currentS] == currentT && mappingDictTtoS[currentT] == currentS)) {
        isIsomorphic = false;
        break;
      }
    }

    return isIsomorphic;
  }

  public static void main(String[] args) {
    String s = "egg";
    String t = "add";
    IsomorphicStrings isomorphicStrings = new IsomorphicStrings();

    boolean result = isomorphicStrings.isIsomorphic(s, t);
    System.out.println("Isomorphic: " + result);
  }
}
