/**
 * Given an array of distinct integers candidates and a target integer target, return a list of all
 * unique combinations of candidates where the chosen numbers sum to target. You may return the
 * combinations in any order.
 *
 * <p>The same number may be chosen from candidates an unlimited number of times. Two combinations
 * are unique if the frequency of at least one of the chosen numbers is different.
 *
 * <p>The test cases are generated such that the number of unique combinations that sum up to target
 * is less than 150 combinations for the given input.
 */
package com.problem.solving.leetcode.problems.backtracking;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CombinationSum {

  private final List<List<Integer>> combinations = new LinkedList<>();

  private void generateCombinations(int[] nums, int start, int target, int summatory, LinkedList<Integer> combination) {

    if (summatory == target) {
      combinations.add(new LinkedList<>(combination));
      return;
    }

    if (summatory > target) {
      return;
    }

    for (int i = start; i < nums.length; i++) {
      combination.add(nums[i]);
      generateCombinations(nums, i, target, summatory + nums[i], combination);
      combination.removeLast();
    }

  }

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    LinkedList<Integer> combination = new LinkedList<>();

    int start     = 0;
    int summatory = 0;
    generateCombinations(candidates, start, target, summatory, combination);

    return combinations;
  }

  public static void main(String[] args) {
    int candiates[] = {2, 3, 5};
    int target = 8;

    CombinationSum combinator = new CombinationSum();
    List<List<Integer>> result = combinator.combinationSum(candiates, target);

    System.out.println("Combinations for target " + target + ": " + result);
  }
}
