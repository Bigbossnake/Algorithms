/**
 * Given an integer array nums, rotate the array to
 * the right by k steps, where k is non-negative.
 */

package com.problem.solving.leetcode;

public class RotateArray {

  public void rotate(int[] nums, int k) {

    k = k % nums.length;

    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);

  }

  public void reverse(int[] nums, int startIndex, int endIndex) {

    while (startIndex < endIndex) {
      int temp = nums[startIndex];
      nums[startIndex] = nums[endIndex];
      nums[endIndex] = temp;
      startIndex++;
      endIndex--;
    }

  }

}
