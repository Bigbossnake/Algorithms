/**
 * Given a collection of candidate numbers (candidates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sum to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note: The solution set must not contain duplicate combinations.
 */
package com.problem.solving.leetcode.problems.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumII {

  private void generateCombinations(int[] candidates, int target, int index,
                                    List<List<Integer>> combinations, LinkedList<Integer> tempList) {

    if (target < 0) {
      return;
    }

    else if (target == 0) {
      combinations.add(new ArrayList<>(tempList));
    }

    else {
      for (int i = index; i < candidates.length && target >= candidates[i]; i++) {

        if (i > index && candidates[i] == candidates[i - 1]) {
          continue;
        }

        tempList.add(candidates[i]);
        generateCombinations(candidates, target - candidates[i], i + 1, combinations, tempList);
        tempList.removeLast();
      }
    }
  }

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    int index = 0;
    LinkedList<Integer> combination = new LinkedList<Integer>();
    List<List<Integer>> combinations = new LinkedList<List<Integer>>();
    Arrays.sort(candidates);

    generateCombinations(candidates, target, index, combinations, combination);
    return combinations;
  }

  public static void main(String[] args) {
    int candiates[] = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
    int target = 27;

    CombinationSumII combinator = new CombinationSumII();
    List<List<Integer>> result = combinator.combinationSum2(candiates, target);

    System.out.println("Combinations for target " + target + ": " + result);
  }
}
