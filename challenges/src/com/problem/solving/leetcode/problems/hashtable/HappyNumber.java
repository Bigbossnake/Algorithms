/**
 * Write an algorithm to determine if a number n is happy.
 *
 * <p>A happy number is a number defined by the following process:
 *
 * <p>Starting with any positive integer, replace the number by the sum of the squares of its
 * digits. Repeat the process until the number equals 1 (where it will stay), or it loops endlessly
 * in a cycle which does not include 1.
 *
 * <p>Those numbers for which this process ends in 1 are happy. Return true if n is a happy number,
 * and false if not.
 */
package com.problem.solving.leetcode.problems.hashtable;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

  public boolean isHappy(int n) {
    int happySum    = 1;
    int currSum     = 0;
    boolean isHappy = true;
    Set<Integer> previousSum = new HashSet<>();

    while (currSum != happySum) {

      currSum = 0;
      while (n > 0) {
        int currentDigit = n % 10;
        currSum = (int) (currSum + Math.pow(currentDigit, 2));

        n = n/10;
      }

      if (previousSum.contains(currSum)) {
        return !isHappy;
      }

      System.out.println(currSum);
      previousSum.add(currSum);
      n = currSum;
    }

    return isHappy;
  }

  public static void main(String[] args) {
    HappyNumber happyNumber = new HappyNumber();
    System.out.println(happyNumber.isHappy(19));
  }
}
