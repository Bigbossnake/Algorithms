/**
 * Given an integer array nums of length n and an integer target, find three integers at distinct
 * indices in nums such that the sum is closest to target.
 *
 * <p>Return the sum of the three integers.
 *
 * <p>You may assume that each input would have exactly one solution.
 */
package com.problem.solving.leetcode.problems.arrays;

import java.util.Arrays;

public class Sum3Closest {

  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);

    int distance = Integer.MAX_VALUE;
    int numsSize = nums.length;

    if (nums.length < 4) {
      return nums[0] + nums[1] + nums[2];
    }

    int smallest = nums[0] + nums[1] + nums[2];
    if (smallest >= target) {
      return smallest;
    }

    int largest = nums[distance - 3] + nums[distance - 2] + nums[distance - 1];
    if (largest <= target) {
      return largest;
    }

    for (int i = 0; i < numsSize && distance != 0; ++i) {

      int leftIdx  = i + 1;
      int rigthIdx = numsSize - 1;

      while (leftIdx < rigthIdx) {
        int sum = nums[i] + nums[leftIdx] + nums[rigthIdx];

        if (Math.abs(target - sum) < Math.abs(distance)) {
          distance = target - sum;
        }

        if (sum < target) {
          leftIdx++;
        }

        else {
          rigthIdx--;
        }
      }
    }

    return target - distance;
  }

  public static void main(String[] args) {
    Sum3Closest sum3Closest = new Sum3Closest();
    int[] nums = {0, 1, 2};
    int target = 0;

    System.out.println("Closest Sum: " + sum3Closest.threeSumClosest(nums, target));
  }
}
