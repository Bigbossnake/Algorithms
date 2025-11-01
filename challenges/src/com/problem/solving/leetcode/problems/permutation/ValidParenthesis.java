/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 */
package com.problem.solving.leetcode.problems.permutation;

import java.util.Stack;

public class ValidParenthesis {

  public boolean isValid(String input) {

    Stack<Character> parenthesis = new Stack<>();

    if (input == null || input.isEmpty() || input.isBlank() || input.length() < 2) {
      return false;
    }

    for (int i = 0; i < input.length(); i++) {
        char currentChar = input.charAt(i);

        if (!parenthesis.isEmpty() && parenthesis.peek() == '[' && currentChar ==  ']' ||
            !parenthesis.isEmpty() && parenthesis.peek() == '{' && currentChar ==  '}' ||
            !parenthesis.isEmpty() && parenthesis.peek() == '(' && currentChar ==  ')') {
            parenthesis.pop();
            continue;
        }

      parenthesis.push(currentChar);
    }

    return parenthesis.isEmpty();
  }

  public static void main(String args[]) {
    ValidParenthesis solution = new ValidParenthesis();

    String input = "()";
    System.out.println(solution.isValid(input));
  }
}
