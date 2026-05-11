package com.problem.solving.leetcode.problems.stacks;

import java.util.Map;
import java.util.Stack;

public class BaseBasicCalculator {

  private static final char SUM            = '+';
  private static final char SUBSTRACTION   = '-';
  private static final char MULTIPLICATION = '*';
  private static final char DIVISION       = '/';

  private static final int LOW_PRIORITY  = 0;
  private static final int HIGH_PRIORITY = 1;

  private static final Map<Character, Integer> isOperator = Map.of(
          SUM, LOW_PRIORITY,
          SUBSTRACTION, LOW_PRIORITY,
          MULTIPLICATION, HIGH_PRIORITY,
          DIVISION, HIGH_PRIORITY
  );

  public void calculateOperation(Stack<Integer> numbers, char operation) {
    int result;
    int number1 = numbers.pop(); // operando derecho (último en entrar)
    int number2 = numbers.pop(); // operando izquierdo

    result = switch (operation) {
          case SUM -> number2 + number1;
          case SUBSTRACTION -> number2 - number1;
          case MULTIPLICATION -> number2 * number1;
          case DIVISION -> number2 / number1;
          default -> 0;
    };

    numbers.push(result);
  }

  public int calculate(String s) {
    Stack<Character> operands   = new Stack<>();
    Stack<Integer> numbers      = new Stack<>();
    int expressionSize          = s.length();
    StringBuilder currentNumber = new StringBuilder();

    for (int i = 0; i < expressionSize; i++) {
      char currentToken = s.charAt(i);

      if (Character.isDigit(currentToken)) {
        currentNumber.append(currentToken);
      }

      else if (isOperator.containsKey(currentToken)) {
        numbers.push(Integer.parseInt(currentNumber.toString()));
        currentNumber = new StringBuilder();

        // Mientras haya un operador en el stack con prioridad >= a la del actual,
        // lo resolvemos. Esto respeta tanto la precedencia como la asociatividad
        // izquierda de +, -, *, /.
        while (!operands.isEmpty()
            && isOperator.get(operands.peek()) >= isOperator.get(currentToken)) {
          calculateOperation(numbers, operands.pop());
        }

        operands.push(currentToken);
      }
      // Cualquier otro carácter (espacios) se ignora.
    }

    // Empujamos el último número parseado.
    if (currentNumber.length() > 0) {
      numbers.push(Integer.parseInt(currentNumber.toString()));
    }

    // Drenamos los operadores que quedaron pendientes.
    while (!operands.isEmpty()) {
      calculateOperation(numbers, operands.pop());
    }

    return numbers.pop();
  }

  public static void main(String[] args) {
      BaseBasicCalculator calculator = new BaseBasicCalculator();
      String mathExpression = "1+1*5+1";
      System.out.println(calculator.calculate(mathExpression));
  }
}
