/**
 * Given two integers n and k, return all possible combinations of k numbers chosen from the range
 * [1, n].
 *
 * <p>You may return the answer in any order.
 */
package com.problem.solving.leetcode.problems.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations {

  private void generateCombinations(int initialNumber, int upperLimit, int combinationSize,
                                    LinkedList<Integer> combination, List<List<Integer>> combinations) {

    if (combination.size() == combinationSize) {
      combinations.add(new ArrayList<>(combination));

      return;
    }

    for (int number = initialNumber; number < upperLimit; number++) {

      combination.add(number);
      generateCombinations(number + 1, upperLimit, combinationSize, combination, combinations);
      combination.removeLast();

    }
  }

  public List<List<Integer>> combine(int n, int k) {
    LinkedList<Integer> combination  = new LinkedList<>();
    List<List<Integer>> combinations = new LinkedList<>();

    int initialNumber = 1;
    generateCombinations(initialNumber, n, k, combination, combinations);

    return combinations;
  }

  public static void main(String args[]) {
      Combinations combinator = new Combinations();
      int n = 4;
      int k = 3;

      System.out.println(combinator.combine(n, k));
  }
}
