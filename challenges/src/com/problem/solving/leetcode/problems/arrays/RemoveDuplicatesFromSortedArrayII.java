package com.problem.solving.leetcode.problems.arrays;

public class RemoveDuplicatesFromSortedArrayII {

  public int removeDuplicates_II(int[] nums) {

    if (nums.length == 0) {
      return 0;
    }

    int i     = 1;
    int j     = 1;
    int count = 1;

    while (i < nums.length) {

      if (nums[i] == nums[i - 1]) {
        count++;

        if (count > 2) {
          i++;
          continue;
        }

      }

      else {
        count = 1;
      }

      nums[j] = nums[i];
      j++;
      i++;
    }

    // Java arrays can't be resized like C++ vectors,
    // so we return the size directly.
    return j;
  }

  public int removeDuplicates(int[] nums) {

    if (nums.length == 0) {
      return 0;
    }

    int insertIndex = 1;
    int count       = 1;

    for (int index = 1; index < nums.length; index++) {

      if (nums[index] == nums[index - 1]) {
        count++;
      }

      else {
        count = 1;
      }

      if (count <= 2) {
        nums[insertIndex++] = nums[index];
      }
    }

    return insertIndex;
  }
}
