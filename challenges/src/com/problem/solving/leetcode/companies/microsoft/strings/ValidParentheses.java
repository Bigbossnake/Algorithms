/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the
 * input string is valid.
 *
 * <p>An input string is valid if:
 *
 * <p>Open brackets must be closed by the same type of brackets. Open brackets must be closed in the
 * correct order. Every close bracket has a corresponding open bracket of the same type.
 */
package com.problem.solving.leetcode.companies.microsoft.strings;

import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> parenthesesStack = new Stack<>();

        if (s.length() % 2 != 0) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char currentParentheses = s.charAt(i);

            if (currentParentheses == '(' || currentParentheses == '[' || currentParentheses == '{') {
                parenthesesStack.push(currentParentheses);
                continue;
            }

            if (currentParentheses == ')' && !parenthesesStack.isEmpty() && parenthesesStack.peek() == '('
                    || currentParentheses == ']' && !parenthesesStack.isEmpty() && parenthesesStack.peek() == '['
                    || currentParentheses == '}' && !parenthesesStack.isEmpty() && parenthesesStack.peek() == '{') {
                parenthesesStack.pop();
                continue;
            }

            parenthesesStack.push(currentParentheses);
            break;
        }

        return parenthesesStack.isEmpty();
    }

  public static void main(String[] args) {
    ValidParentheses validator = new ValidParentheses();
    String input = "}}}}}}}}}";

    System.out.println(validator.isValid(input));
  }
}
