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

import java.util.Map;
import java.util.Stack;

public class BasicCalculatorII {

  private static final char SUM            = '+';
  private static final char SUBSTRACTION   = '-';
  private static final char MULTIPLICATION = '*';
  private static final char DIVISION       = '/';

  private static final Map<Character, Boolean> isOperator = Map.of(
          SUM, Boolean.TRUE,
          SUBSTRACTION, Boolean.TRUE,
          MULTIPLICATION, Boolean.TRUE,
          DIVISION, Boolean.TRUE);

  public int calculate(String s) {

    if (s == null || s.isEmpty()) {
      return 0;
    }

    int currentNumber       = 0;
    int expressionSize      = s.length();
    char operation          = SUM;
    Stack<Integer> operands = new Stack<>();

    for (int i = 0; i < expressionSize; i++) {
      char currentToken = s.charAt(i);

      if (Character.isDigit(currentToken)) {
        currentNumber = (currentNumber * 10) + Character.getNumericValue(currentToken);
      }

      if (isOperator.containsKey(currentToken) && !Character.isWhitespace(currentToken)
              || i == expressionSize - 1) {

        switch (operation) {
          case SUM -> operands.push(currentNumber);
          case SUBSTRACTION -> operands.push(-currentNumber);
          case MULTIPLICATION -> operands.push(operands.pop() * currentNumber);
          case DIVISION -> operands.push(operands.pop() / currentNumber);
        }

        operation     = currentToken;
        currentNumber = 0;
      }
    }

    int result = 0;
    while (!operands.isEmpty()) {
      result += operands.pop();
    }

    return result;
  }

  public static void main(String[] args) {
    BasicCalculatorII calculator = new BasicCalculatorII();

    String mathExpression = "3+2*2";
    System.out.println(calculator.calculate(mathExpression));
  }
}
