package com.problem.solving.leetcode.problems.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets {

  private void generateSubsets(int[] numbers, int numbersSize, int subsetIndex,
                               LinkedList<Integer> subset,
                               List<List<Integer>> subsets) {

    subsets.add(new ArrayList(subset));

    for (int i = subsetIndex; i < numbersSize; i++) {
      subset.add(numbers[i]);
      generateSubsets(numbers, numbersSize, i + 1, subset, subsets);
      subset.removeLast();
    }
  }

  public List<List<Integer>> subsets(int[] nums) {
    LinkedList<Integer> subset = new LinkedList<>();
    List<List<Integer>> subsets = new ArrayList<>();

    int subSetIndex = 0;
    generateSubsets(nums, nums.length, subSetIndex, subset, subsets);

    return subsets;
  }

  public static void main(String args[]) {
    Subsets subsets = new Subsets();
    int nums[] = {1, 2, 3};

    System.out.println(subsets.subsets(nums));
  }
}
