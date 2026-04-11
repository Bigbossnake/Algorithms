package com.problem.solving.leetcode.problems.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PermutationsIIOptimized {

  protected void backtrack(Integer permutationSize,
      HashMap<Integer, Integer> occurrences,
      LinkedList<Integer> permutation,
      List<List<Integer>> permutations) {

    if (permutation.size() == permutationSize) {
      permutations.add(new ArrayList<Integer>(permutation));
      return;
    }

    for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
      Integer number     = entry.getKey();
      Integer occuerence = entry.getValue();

      if (occuerence == 0) {
        continue;
      }

      permutation.addLast(number);
      occurrences.put(number, occuerence - 1);

      backtrack(permutationSize, occurrences, permutation, permutations);

      permutation.removeLast();
      occurrences.put(number, occuerence);
    }
  }

  public List<List<Integer>> permuteUnique(int[] nums) {
    LinkedList<Integer> permutation      = new LinkedList<>();
    List<List<Integer>> permutations     = new ArrayList<>();
    HashMap<Integer, Integer> occurences = new HashMap<>();

    int permutationSize = nums.length;

    for (int num : nums) {
      if (!occurences.containsKey(num)) {
        occurences.put(num, 0);
      }

      occurences.put(num, occurences.get(num) + 1);
    }

    backtrack(permutationSize, occurences, permutation, permutations);
    return permutations;
  }
}
