/**
 * Given a sorted array of distinct integers and a target value,
 * return the index if the target is found. If not,
 * return the index where it would be if it were inserted in order.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 */
package com.problem.solving.leetcode;

public class SearchInsertPosition {

  public int searchInsert(int[] input, int target) {

    int solution = -1;
    int left     = 0;
    int right    = input.length - 1;

    while (left <= right) {

      int index = (left + right) / 2;

      if (input[index] == target) {
        return index;
      }

      if (input[index] > target) {
        right = index - 1;
      }

      else if (input[index] < target) {
        left = index + 1;
      }

    }


    if (left >= 0 || right >= input.length - 1) {
      return right + 1;
    }

    return 0;
  }

  public static void main(String args[]) {

    int input[] = {1,3,5,6};
    SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
    int result = searchInsertPosition.searchInsert(input, 7);

    System.out.println(result);

  }

}
