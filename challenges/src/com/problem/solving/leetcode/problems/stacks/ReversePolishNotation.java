/**
 * You are given an array of strings tokens that represents an arithmetic expression in a Reverse
 * Polish Notation.
 *
 * <p>Evaluate the expression. Return an integer that represents the value of the expression.
 *
 * <p>Note that:
 *
 * <p>The valid operators are '+', '-', '*', and '/'. - Each operand may be an integer or another
 * expression. - The division between two integers always truncates toward zero. - There will not be
 * any division by zero. - The input represents a valid arithmetic expression in a reverse polish
 * notation. - The answer and all the intermediate calculations can be represented in a 32-bit
 * integer.
 */
package com.problem.solving.leetcode.problems.stacks;

import java.util.Map;
import java.util.Stack;

public class ReversePolishNotation {

  private static final String SUM = "+";
  private static final String SUBSTRACTION = "-";
  private static final String MULTIPLICATION = "*";
  private static final String DIVISION = "/";

  private static final Map<String, Boolean> isOperator = Map.of(
          SUM, Boolean.TRUE,
          SUBSTRACTION, Boolean.TRUE,
          MULTIPLICATION, Boolean.TRUE,
          DIVISION, Boolean.TRUE
      );

  public int evalRPN(String[] tokens) {
    int result = 0;
    Stack<String> operands = new Stack<>();

    if (tokens.length == 1) {
      return Integer.parseInt(tokens[0]);
    }

    for (int i = 0; i < tokens.length; i++) {
      String currentOperand = tokens[i];

      if (!isOperator.containsKey(currentOperand)) {
        operands.push(currentOperand);
      }

      else {
        int operand1 = Integer.parseInt(operands.pop());
        int operand2 = Integer.parseInt(operands.pop());

        result = switch (currentOperand) {
              case SUM -> operand1 + operand2;
              case SUBSTRACTION -> operand2 - operand1;
              case MULTIPLICATION -> operand1 * operand2;
              case DIVISION -> operand2 / operand1;
              default -> 0;
            };

        operands.push(String.valueOf(result));
      }
    }

    return result;
  }

  public static void main(String[] args) {
    ReversePolishNotation reversePolishNotation = new ReversePolishNotation();
    String[] tokens = new String[] {"4", "13", "5", "/", "+"};

    int result = reversePolishNotation.evalRPN(tokens);
    System.out.println("Result: " + result);
  }
}
