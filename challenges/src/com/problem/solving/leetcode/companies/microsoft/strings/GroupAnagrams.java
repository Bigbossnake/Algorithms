/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any
 * order.
 */
package com.problem.solving.leetcode.companies.microsoft.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

public class GroupAnagrams {

  public String getAnagramHash(String input) {
    char[] arrayHash = input.toCharArray();
    Arrays.sort(arrayHash);

    return String.valueOf(arrayHash);
  }

  public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> anagramsList      = new ArrayList<List<String>>();
    Map<String, List<String>> anagramMap = new HashMap<String, List<String>>();
    List<String> wordList                = null;

    for (int i = 0; i < strs.length; i++) {
      String currentWord = strs[i];
      String wordHash    = getAnagramHash(currentWord);

      if (!anagramMap.containsKey(wordHash)) {
        wordList = new ArrayList<>();
        wordList.add(currentWord);

        anagramMap.put(wordHash, wordList);
      } else {
          wordList = anagramMap.get(wordHash);
          wordList.add(currentWord);

          anagramMap.put(wordHash, wordList);
      }
    }

    for (Map.Entry<String, List<String>> entry : anagramMap.entrySet()) {
        anagramsList.add(entry.getValue());
    }

    return anagramsList;
  }

  public static void main(String[] args) {
    GroupAnagrams anagrams = new GroupAnagrams();
    String[] anagramArray = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};

    anagrams.groupAnagrams(anagramArray);
  }
}
