/**
 * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 */
package com.problem.solving.leetcode.problems.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetsII {

  private void generateSubsets(int[] numbers, int numberIndex, int numbersSize,
                               LinkedList<Integer> subset, List<List<Integer>> subsets) {

    subsets.add(new ArrayList(subset));

    for (int i = numberIndex; i < numbersSize; i++) {

      if (i != numberIndex && numbers[i] == numbers[i -1]) {
        continue;
      }

      subset.add(numbers[i]);
      generateSubsets(numbers, i + 1, numbersSize, subset, subsets);
      subset.removeLast();
    }
  }

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    LinkedList<Integer> subset  = new LinkedList<>();
    List<List<Integer>> subsets = new ArrayList<>();
    Arrays.sort(nums);

    int numbersIndex = 0;
    int numbersSize  = nums.length;
    generateSubsets(nums, numbersIndex, numbersSize, subset, subsets);

    return subsets;
  }

  public static void main(String[] args) {
    SubsetsII subsetsII = new SubsetsII();
    int[] nums = {1, 2, 2};

    List<List<Integer>> result = subsetsII.subsetsWithDup(nums);
    System.out.println(result);
  }

}
