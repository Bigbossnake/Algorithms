/**
 * Given an array of unique integers preorder, return true if it is the correct preorder traversal
 * sequence of a binary search tree.
 */
package com.problem.solving.leetcode.problems.stacks;

import java.util.Stack;

public class VerifyPreOrderSequence {

  public boolean verifyPreorder(int[] preorder) {
    int minLimit = Integer.MIN_VALUE;
    Stack<Integer> stack = new Stack<>();

    for (int num : preorder) {

      while (!stack.isEmpty() && stack.peek() < num) {
        minLimit = stack.pop();
      }

      if (num <= minLimit) {
        return false;
      }

      stack.push(num);
    }

    return true;
  }

  public static void main(String args[]) {
    VerifyPreOrderSequence verifyPreOrder = new VerifyPreOrderSequence();
    int[] preorder = {5, 2, 6, 1, 3};

    System.out.println(verifyPreOrder.verifyPreorder(preorder));
  }
}
