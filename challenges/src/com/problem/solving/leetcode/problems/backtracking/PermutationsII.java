package com.problem.solving.leetcode.problems.backtracking;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PermutationsII {

  private void generateCombinations(int[] nums, int permutationSize, int index,
      LinkedList<Integer> indexes,
      Set<String> permutationId,
      LinkedList<Integer> permutation,
      List<List<Integer>> permutations) {

    if (permutation.size() == permutationSize && !permutationId.contains(permutation.toString())) {
      permutations.add(new LinkedList<>(permutation));
      permutationId.add(permutation.toString());
      return;
    }

    for (int i = index; i < nums.length; i++) {

      if (!indexes.contains(i)) {
        indexes.add(i);
        permutation.add(nums[i]);

        generateCombinations(nums, permutationSize, index, indexes, permutationId, permutation, permutations);

        permutation.removeLast();
        indexes.removeLast();
      }
    }
  }

  public List<List<Integer>> permuteUnique(int[] nums) {
    LinkedList<Integer> indexes      = new LinkedList<>();
    Set<String> permutationId        = new HashSet<>();
    LinkedList<Integer> permutation  = new LinkedList<>();
    List<List<Integer>> permutations = new LinkedList<>();

    int index = 0;
    int permutationSize = nums.length;

    generateCombinations(
        nums, permutationSize, index, indexes, permutationId, permutation, permutations);

    return permutations;
  }

  public static void main(String args[]) {
    int nums[] = {1, 1, 2};
    PermutationsII permutations = new PermutationsII();
    System.out.println(permutations.permuteUnique(nums));
  }
}
