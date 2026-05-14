/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i !=
 * j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * <p>Notice that the solution set must not contain duplicate triplets.
 */
package com.problem.solving.leetcode.problems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Sum3 {

  private static final int TARGET = 0;

  public List<List<Integer>> threeSum(int[] nums) {
    int numsSize = nums.length;
    List<List<Integer>> triplets = new ArrayList<>();

    Arrays.sort(nums);
    for (int i = 0; i < numsSize && nums[i] <= 0; i++) {
      int leftIdx  = i + 1;
      int rightIdx = nums.length - 1;

      if (i == 0 || nums[i - 1] != nums[i]) {

        while (leftIdx < rightIdx) {
          int currentSum = nums[i] + nums[leftIdx] + nums[rightIdx];

          if (currentSum < TARGET) {
            leftIdx++;
          }

          else if (currentSum > TARGET) {
            rightIdx--;
          }

          else {
            LinkedList<Integer> triplet = new LinkedList<>();
            triplet.add(nums[i]);
            triplet.add(nums[leftIdx++]);
            triplet.add(nums[rightIdx--]);
            triplets.add(triplet);

            while (leftIdx < rightIdx && nums[leftIdx] == nums[leftIdx - 1]) {
              leftIdx++;
            }
          }
        }
      }
    }

    return triplets;
  }

  public static void main(String[] args) {
    Sum3 sum = new Sum3();
    int[] nums = new int[] {-100, -70, -60, 110, 120, 130, 160};

    System.out.println(sum.threeSum(nums));
  }
}
