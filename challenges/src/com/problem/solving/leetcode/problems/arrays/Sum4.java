/***
 * Given an array nums of n integers, return an array of all the unique quadruplets
 * [nums[a], nums[b], nums[c], nums[d]] such that:
 *
 * 0 <= a, b, c, d < n
 * a, b, c, and d are distinct.
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 *
 * You may return the answer in any order.
 */
package com.problem.solving.leetcode.problems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum4 {

  public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> quadruplets = new ArrayList<>();

    Arrays.sort(nums);

    return quadruplets;
  }
}
