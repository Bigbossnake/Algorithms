/**
 * Merge Intervals with Constraints
 *
 * <p>Problem Statement Given an array of intervals intervals[i] = [start, end], merge all
 * overlapping intervals and return the result in sorted order of start time.
 *
 * <p>Additionally, ensure that merged intervals are non-overlapping and minimal in count.
 *
 * <p>Input: list of intervals
 *
 * <p>Output: list of merged intervals
 *
 * <p>Example Test Cases:
 *
 * <p>Input: [[1,3],[2,6],[8,10],[15,18]] Output: [[1,6],[8,10],[15,18]]
 */
package company.lotus;

import java.util.ArrayList;
import java.util.List;

public class LotusInterview {

  public List<List<Integer>> mergeIntervals(List<List<Integer>> intervals) {

    List<Integer> mergedInterval = null;
    List<List<Integer>> solution = new ArrayList<>();

    for (int i = 0; i < intervals.size(); i++) {
      List<Integer> currentInterval = intervals.get(i);
      int prevMin = currentInterval.get(0);
      int prevMax = currentInterval.get(1);

      if (i + 1 < intervals.size()) {
        i = i + 1;

        while (i < intervals.size()) {
          List<Integer> nextInterval = intervals.get(i);
          int nextMin = nextInterval.get(0);
          int nextMax = nextInterval.get(1);

          if (nextMin > prevMin && nextMin < prevMax) {
            prevMax = nextMax;
          }

          else {
            mergedInterval = List.of(prevMin, prevMax);
            solution.add(mergedInterval);

            mergedInterval = List.of(nextMin, nextMax);
            solution.add(mergedInterval);

            break;
          }

          i++;
        }

      }

      else {
        mergedInterval = List.of(prevMin, prevMax);
        solution.add(mergedInterval);
      }
    }

    return solution;
  }

  public static void main(String args[]) {
    LotusInterview solution = new LotusInterview();
    List<List<Integer>> intervals = new ArrayList<>();

    intervals.add(List.of(1, 3));
    intervals.add(List.of(2, 6));
    intervals.add(List.of(8, 10));
    intervals.add(List.of(15, 18));

    System.out.println(solution.mergeIntervals(intervals));
  }
}
