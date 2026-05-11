/**
 * Given a string s which represents an expression, evaluate this expression and return its value.
 *
 * <p>The integer division should truncate toward zero.
 *
 * <p>You may assume that the given expression is always valid. All intermediate results will be in
 * the range of [-231, 231 - 1].
 *
 * <p>Note: You are not allowed to use any built-in function which evaluates strings as mathematical
 * expressions, such as eval().
 */
package com.problem.solving.leetcode.problems.stacks;

import java.util.Stack;

public class BasicCalculator {

  private static final char SUM               = '+';
  private static final char SUBSTRACTION      = '-';
  private static final char OPEN_PARENTHESIS  = '(';
  private static final char CLOSE_PARENTHESIS = ')';

  public int calculate(String s) {

    int number  = 0;
    int result  = 0;

    // 1 for positive, -1 for negative
    int sign = 1;

    Stack<Integer> stack = new Stack<Integer>();

    for (int i = 0; i < s.length(); i++) {
      char currentToken = s.charAt(i);

      if (Character.isDigit(currentToken)) {
        number = (number * 10) + Character.getNumericValue(currentToken);
      }

      else if (currentToken == SUM) {
        result += sign * number;
        sign   = 1;
        number = 0;

      }

      else if (currentToken == SUBSTRACTION) {
        result += sign * number;
        sign   = -1;
        number = 0;
      }

      else if (currentToken == OPEN_PARENTHESIS) {
        stack.push(result);
        stack.push(sign);

        sign   = 1;
        result = 0;

      }

      else if (currentToken == CLOSE_PARENTHESIS) {

        result += sign * number;
        result *= stack.pop();
        result += stack.pop();

        number = 0;
      }
    }
    return result + (sign * number);
  }

  public static void main(String[] args) {
    BasicCalculator calculator = new BasicCalculator();
    String mathExpression = "1-(-2)";

    System.out.println(calculator.calculate(mathExpression));
  }

}
