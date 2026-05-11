/**
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * <p>The expression string contains only non-negative integers, '+', '-', '*', '/' operators, and
 * open '(' and closing parentheses ')'. The integer division should truncate toward zero.
 *
 * <p>You may assume that the given expression is always valid. All intermediate results will be in
 * the range of [-231, 231 - 1].
 *
 * <p>Note: You are not allowed to use any built-in function which evaluates strings as mathematical
 * expressions, such as eval().
 */
package com.problem.solving.leetcode.problems.stacks;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class BasicCalculatorIII {

  private static final char DELMITER          = '@';
  private static final char SUM               = '+';
  private static final char SUBSTRACTION      = '-';
  private static final char MULTIPLICATION    = '*';
  private static final char DIVISION          = '/';
  private static final char OPEN_PARENTHESIS  = '(';
  private static final char CLOSE_PARENTHESIS = ')';

  private static final Set<String> operators = new HashSet<>(List.of(
          String.valueOf(SUM),
          String.valueOf(SUBSTRACTION),
          String.valueOf(MULTIPLICATION),
          String.valueOf(DIVISION))
  );

  private int evaluate(char operator, int number1, int number2) {
    return switch (operator) {
      case SUM -> number1;
      case SUBSTRACTION -> -number1;
      case MULTIPLICATION -> number1 * number2;
      case DIVISION -> number1 / number2;
      default -> throw new IllegalArgumentException("Illegal operator: " + operator);
    };
  }

  public int calculate(String s) {
    int operationResult   = 0;
    int currentNumber     = 0;
    char previousOperator = SUM;
    Stack<String> tokens  = new Stack<>();

    s+=DELMITER;
    for (int i = 0; i < s.length(); i++) {
      char currentToken = s.charAt(i);

      if (Character.isDigit(currentToken)) {
        currentNumber = (currentNumber * 10) + Character.getNumericValue(currentToken);
      }

      else if (currentToken == OPEN_PARENTHESIS) {
        tokens.add(String.valueOf(previousOperator));
        previousOperator = SUM;
      }

      else {

        if (previousOperator == MULTIPLICATION ||  previousOperator == DIVISION) {
          int number1     = Integer.parseInt(tokens.pop());
          operationResult = evaluate(previousOperator, number1, currentNumber);

          tokens.push(String.valueOf(operationResult));
        }

        else {
          int number2     = 0;
          operationResult = evaluate(previousOperator, currentNumber, number2);

          tokens.push(String.valueOf(operationResult));
        }

        operationResult  = 0;
        currentNumber    = 0;
        previousOperator = currentToken;

        if (currentToken == CLOSE_PARENTHESIS) {

          while (!operators.contains(tokens.peek())) {
            operationResult += Integer.parseInt(tokens.pop());
          }

          currentNumber    = operationResult;
          previousOperator = tokens.pop().charAt(0);
        }
      }
    }

    operationResult = 0;
    while(!tokens.isEmpty()) {
      operationResult = operationResult + Integer.parseInt(tokens.pop());
    }

    return operationResult;
  }

  public static void main(String[] args) {
    BasicCalculatorIII basicCalculator = new BasicCalculatorIII();
    String mathExpression = "2*(5+5*2)/3+(6/2+8)";

    System.out.println(basicCalculator.calculate(mathExpression));
  }
}
