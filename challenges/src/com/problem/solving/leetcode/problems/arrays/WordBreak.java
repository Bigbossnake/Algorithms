/**
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a
 * space-separated sequence of one or more dictionary words.
 *
 * <p>Note that the same word in the dictionary may be reused multiple times in the segmentation.
 */
package com.problem.solving.leetcode.problems.arrays;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordBreak {

  public boolean wordBreak(String s, List<String> wordDict) {
    Set<String> wordsSet = new HashSet<>(wordDict);
    Queue<Integer> queue = new LinkedList<>();
    boolean[] seen       = new boolean[s.length() + 1];
    queue.add(0);

    while (!queue.isEmpty()) {

      int startIdx = queue.remove();

      if (startIdx == s.length()) {
        return true;
      }

      for (int endIdx = startIdx + 1; endIdx <= s.length(); endIdx++) {

        if (seen[endIdx]) {
          continue;
        }

        if (wordsSet.contains(s.substring(startIdx, endIdx))) {
          queue.add(endIdx);
          seen[endIdx] = true;
        }
      }
    }

    return false;
  }

  public static void main(String[] args) {
    List<String> wordDict = List.of("aaaa", "aaa");
    WordBreak wordBreak = new WordBreak();
    String input = "aaaaaaa";

    System.out.println(wordBreak.wordBreak(input, wordDict));
  }
}
