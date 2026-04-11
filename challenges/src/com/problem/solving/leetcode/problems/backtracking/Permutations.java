/**
 * Given an array nums of distinct integers, return all the possible permutations.
 * You can return the answer in any order.
 */
package com.problem.solving.leetcode.problems.backtracking;

import java.util.LinkedList;
import java.util.List;

public class Permutations {

  private void generateCombinations(int[] nums, int permutationSize, int index,
                                    LinkedList<Integer> permutation,
                                    List<List<Integer>> permutations) {

    if (permutation.size() == permutationSize) {
      permutations.add(new LinkedList<>(permutation));
      return;
    }

    for (int i = index; i < nums.length; i++) {

      if (permutation.contains(nums[i])) {
        continue;
      }

      permutation.add(nums[i]);
      generateCombinations(nums, permutationSize, index, permutation, permutations);
      permutation.removeLast();
    }
  }

  public List<List<Integer>> permute(int[] nums) {
    LinkedList<Integer> permutation  = new LinkedList<>();
    List<List<Integer>> permutations = new LinkedList<>();

    int index = 0;
    int permutationSize = nums.length;

    generateCombinations(nums, permutationSize, index, permutation, permutations);

    return permutations;
  }

  public static void main(String args[]) {
    int nums[] = {1, 2, 3};
    Permutations permutations = new Permutations();
    permutations.permute(nums);

    System.out.println(permutations.permute(nums));
  }
}
