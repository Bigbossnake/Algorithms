/**
 * Given two strings needle and haystack, return the index of the first
 * occurrence of needle in haystack,
 * or -1 if needle is not part of haystack.
 */

package com.problem.solving.leetcode.problems.strings;

public class FindFirstOcurrence {

  public int strStr(String haystack, String needle) {

    int needleLength    = needle.length();
    int haystackLength  = haystack.length();
    int lastWindowStart = haystackLength - needleLength;

    for (int windowStart = 0; windowStart <= lastWindowStart; windowStart++) {

      for (int i = 0; i < needleLength; i++) {

        if (needle.charAt(i) != haystack.charAt(windowStart + i)) {
          break;
        }
        if (i == needleLength - 1) {
          return windowStart;
        }
      }

    }

    return -1;
  }

  public static void main(String args[]) {
    FindFirstOcurrence solution = new FindFirstOcurrence();

    String haystack = "leetcode";
    String needle = "leeto";

    int result = solution.strStr(haystack, needle);
    System.out.printf("Result Is:  %s%n", result);
  }
}
