/**
 * Given an array of strings wordsDict and two different strings that already exist in the array
 * word1 and word2, return the shortest distance between these two words in the list.
 */
package com.problem.solving.leetcode.problems.arrays;

public class ShortestWordDistance {

  public int shortestDistance(String[] wordsDict, String word1, String word2) {
    int shortestDistance = Integer.MAX_VALUE;
    int wor1Position     = -1;
    int wor2Position     = -1;

    int currentMinDistance = 0;
    for (int i = 0; i < wordsDict.length; i++) {
      String currentWord  = wordsDict[i];
      int currentPosition = i + 1;

      if (currentWord.equals(word1)) {
        wor1Position = currentPosition;

        if (wor2Position >= 0) {
          currentMinDistance = Math.abs(wor1Position - wor2Position);
          shortestDistance   = Math.min(shortestDistance, currentMinDistance);
        }

        continue;
      }

      if (currentWord.equals(word2)) {
        wor2Position = currentPosition;

        if (wor1Position >= 0) {
          currentMinDistance = Math.abs(wor1Position - wor2Position);
          shortestDistance   = Math.min(shortestDistance, currentMinDistance);
        }
      }
    }

    return shortestDistance;
  }

  public static void main(String[] args) {
    ShortestWordDistance shortestWordDistance = new ShortestWordDistance();

    String[] wordsDict = {"practice", "makes", "perfect", "coding", "makes"};
    String word1 = "makes";
    String word2 = "coding";

    int shortestDistance = shortestWordDistance.shortestDistance(wordsDict, word1, word2);
    System.out.println(
        "Shortest distance between '" + word1 + "' and '" + word2 + "': " + shortestDistance);
  }
}
