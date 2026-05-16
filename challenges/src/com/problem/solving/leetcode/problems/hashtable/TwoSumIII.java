/**
 * Design a data structure that accepts a stream of integers and checks if it has a pair of integers
 * that sum up to a particular value.
 *
 * <p>Implement the TwoSum class:
 *
 * <p>TwoSum() Initializes the TwoSum object, with an empty array initially. void add(int number)
 * Adds number to the data structure.
 *
 * <p>boolean find(int value) Returns true if there exists any pair of numbers whose sum is equal to
 * value, otherwise, it returns false.
 */
package com.problem.solving.leetcode.problems.hashtable;

import java.util.HashMap;
import java.util.Map;

public class TwoSumIII {

  private final Map<Integer, Integer> numbers;

  public TwoSumIII() {
    numbers = new HashMap<>();
  }

  public void add(int number) {

    if (numbers.containsKey(number)) {
      int availableNumbers = numbers.get(number) + 1;
      numbers.put(number, availableNumbers);
    }

    numbers.put(number, 1);
  }

  public boolean find(int value) {
    boolean found = true;

    for (Map.Entry<Integer, Integer> entry : numbers.entrySet()) {
      int complement = value - entry.getKey();

      if (complement != entry.getKey()) {
        if (numbers.containsKey(complement)) {
          return found;
        }
      }

      else if (numbers.get(complement) > 1) {
        return found;
      }
    }

    return !found;
  }
}
