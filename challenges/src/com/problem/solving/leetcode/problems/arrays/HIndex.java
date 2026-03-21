/**
 * Given an array of integers citations where citations[i] is the number of citations a researcher
 * received for their ith paper, return the researcher's h-index.
 *
 * <p>According to the definition of h-index on Wikipedia: The h-index is defined as the maximum
 * value of h such that the given researcher has published at least h papers that have each been
 * cited at least h times.
 */
package com.problem.solving.leetcode.problems.arrays;

public class HIndex {

  public int hIndex(int[] citations) {
    int n = citations.length;
    int[] buckets = new int[n + 1];

    // Count papers by citation frequency
    for (int citation : citations) {
      if (citation >= n) {
        buckets[n]++;
      }

      else {
        buckets[citation]++;
      }
    }

    int papers = 0;

    // Traverse from highest possible h-index to lowest
    for (int i = n; i >= 0; i--) {
      papers += buckets[i];

      if (papers >= i) {
        return i;
      }

    }

    return 0;
  }

  public static void main(String[] args) {
    int citations[] = {1, 3, 2, 3, 100};
    HIndex hIndex = new HIndex();

    hIndex.hIndex(citations);
  }
}
