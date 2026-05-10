/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 * <p>Example 1: Input: intervals = [[1,3],[2,6],[8,10],[15,18]] Output: [[1,6],[8,10],[15,18]]
 *
 * <p>Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 *
 * <p>Example 2: Input: intervals = [[1,4],[4,5]] Output: [[1,5]]
 *
 * <p>Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 * <p>Example 3: Input: intervals = [[4,7],[1,4]] Output: [[1,7]]
 *
 * <p>Explanation: Intervals [1,4] and [4,7] are considered overlapping.
 */
package com.problem.solving.leetcode.problems.arrays;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {

  public int[][] merge(int[][] intervals) {

    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    LinkedList<int[]> mergedIntervals = new LinkedList<>();

    for (int[] interval : intervals) {

      if (mergedIntervals.isEmpty() || mergedIntervals.getLast()[1] < interval[0]) {
        mergedIntervals.add(interval);
      }

      else {
        mergedIntervals.getLast()[1] = Math.max(mergedIntervals.getLast()[1], interval[1]);
      }
    }

    return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
  }

  public static void main(String[] args) {
    MergeIntervals mergeIntervals = new MergeIntervals();
    int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
    // int[][] intervals = {{1, 4}, {2, 3}};

    System.out.print("[");
    for (int[] interval : mergeIntervals.merge(intervals)) {
      int start = interval[0];
      int end = interval[1];
      System.out.print(start + ", " + end + " ,");
    }
    System.out.print("]");
  }
}
