/**
 * Find all valid combinations of k numbers that sum up to n such that the following conditions are
 * true:
 *
 * <p>Only numbers 1 through 9 are used. Each number is used at most once.
 *
 * <p>Return a list of all possible valid combinations. The list must not contain the same
 * combination twice, and the combinations may be returned in any order.
 */
package com.problem.solving.leetcode.problems.backtracking;

import java.util.LinkedList;
import java.util.List;

public class CombinationSumIII {

  protected void generateCombinations(int[] numbers, int target, int startIndex, int combinationSize,
                                      LinkedList<Integer> combination, List<List<Integer>> combinations) {

    if (target == 0 && combination.size() == combinationSize) {
      combinations.add(new LinkedList<>(combination));
      return;
    }

    else if (target < 0 || combination.size() == combinationSize) {
      return;
    }

    for (int i = startIndex; i < numbers.length; i++) {

      if (combination.contains(numbers[i])) {
        continue;
      }

      combination.add(numbers[i]);
      generateCombinations(numbers, target - numbers[i], i + 1, combinationSize, combination, combinations);
      combination.removeLast();
    }

  }

  public List<List<Integer>> combinationSum3(int k, int n) {
    LinkedList<Integer> combination  = new LinkedList<>();
    List<List<Integer>> combinations = new LinkedList<>();

    int startIndex = 0;
    int numbers[]  = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    generateCombinations(numbers, n, startIndex, k, combination, combinations);

    return combinations;
  }

  public static void main(String[] args) {
    int n = 7;
    int k = 3;

    CombinationSumIII combinator = new CombinationSumIII();
    List<List<Integer>> result = combinator.combinationSum3(k, n);

    System.out.println("Combinations for target " + k + ": " + result);
  }
}
