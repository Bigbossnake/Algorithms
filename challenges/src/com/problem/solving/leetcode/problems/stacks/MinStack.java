/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * <p>Implement the MinStack class:
 *
 * <p>MinStack() initializes the stack object. void push(int val) pushes the element val onto the
 * stack. void pop() removes the element on the top of the stack. int top() gets the top element of
 * the stack. int getMin() retrieves the minimum element in the stack. You must implement a solution
 * with O(1) time complexity for each function.
 */
package com.problem.solving.leetcode.problems.stacks;

import java.util.Stack;

public class MinStack {

  private static class MinStackElement {
    int value;
    int min;

    public MinStackElement(int value, int min) {
      this.value = value;
      this.min = min;
    }
  }

  private final Stack<MinStackElement> minStack;

  public MinStack() {
    minStack = new Stack<>();
  }

  public void push(int val) {
    MinStackElement minStackElement;

    if (minStack.isEmpty()) {
      minStackElement = new MinStackElement(val, val);
      minStack.push(minStackElement);
      return;
    }

    int minElement  = Math.min(minStack.peek().min, val);
    minStackElement = new MinStackElement(val, minElement);
    minStack.push(minStackElement);
  }

  public void pop() {
    minStack.pop();
  }

  public int top() {
    return (!minStack.isEmpty()) ? minStack.peek().value : Integer.MIN_VALUE;
  }

  public int getMin() {
    return (!minStack.isEmpty()) ? minStack.peek().min : Integer.MIN_VALUE;
  }
}
