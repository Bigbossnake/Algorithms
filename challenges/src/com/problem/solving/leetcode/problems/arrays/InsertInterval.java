/**
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi]
 * represent the start and the end of the ith interval and intervals is sorted in ascending order by
 * starti. You are also given an interval newInterval = [start, end] that represents the start and
 * end of another interval.
 *
 * <p>Insert newInterval into intervals such that intervals is still sorted in ascending order by
 * starti and intervals still does not have any overlapping intervals (merge overlapping intervals
 * if necessary).
 *
 * <p>Return intervals after the insertion.
 *
 * <p>Note that you don't need to modify intervals in-place. You can make a new array and return it.
 */
package com.problem.solving.leetcode.problems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

  public int[][] insert(int[][] intervals, int[] newInterval) {
    int intervalsSize = intervals.length;
    int intervalIndex = 0;
    List<int[]> newIntervals = new ArrayList<>();

    // Case 1: No overlapping before merging intervals
    while (intervalIndex < intervalsSize && intervals[intervalIndex][1] < newInterval[0]) {
      newIntervals.add(intervals[intervalIndex]);
      intervalIndex++;
    }

    // Case 2: Overlapping and merging intervals
    while (intervalIndex < intervalsSize && newInterval[1] >= intervals[intervalIndex][0]) {
      newInterval[0] = Math.min(newInterval[0], intervals[intervalIndex][0]);
      newInterval[1] = Math.max(newInterval[1], intervals[intervalIndex][1]);
      intervalIndex++;
    }
    newIntervals.add(newInterval);

    // Case 3: No overlapping after merging newInterval
    while (intervalIndex < intervalsSize) {
      newIntervals.add(intervals[intervalIndex]);
      intervalIndex++;
    }

    return newIntervals.toArray(new int[newIntervals.size()][]);
  }

  public static void main(String args[]) {
    InsertInterval insertInterval = new InsertInterval();
    int[][] intervals = new int[][] {{1, 5}};

    System.out.println(Arrays.toString(insertInterval.insert(intervals, new int[] {6, 8})));
  }
}
