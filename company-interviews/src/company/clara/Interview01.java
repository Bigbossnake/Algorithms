package company.clara;

import java.util.Deque;
import java.util.LinkedList;

class Interview01 {

  private static final char SUM            = '+';
  private static final char SUBSTRACTION   = '-';
  private static final char MULTIPLICATION = '*';
  private static final char DIVISION       = '/';

  public static int getPrecedence(char operator) {

    if (operator == SUM || operator == SUBSTRACTION) {
      return 1;
    }

    else if (operator == MULTIPLICATION || operator == DIVISION) {
      return 2;
    }

    else {
      return -1;
    }
  }

  public static String processPolishNotation(String reversePolishNotation) {

    Deque<Integer> numberStack = new LinkedList<>();

    int index = 0;
    while (index < reversePolishNotation.length()) {
      char numberOrOperator = reversePolishNotation.charAt(index);

      if (Character.isDigit(numberOrOperator)) {
        numberStack.push(Integer.parseInt(Character.toString(numberOrOperator)));
      }

      else {
        int operand1 = numberStack.pop();
        int operand2 = numberStack.pop();

        int result = switch (numberOrOperator) {
            case SUM -> operand1 + operand2;
            case SUBSTRACTION -> operand2 - operand1;
            case MULTIPLICATION -> operand1 * operand2;
            case DIVISION -> operand2 / operand1;
            default -> 0;
        };

        numberStack.push(result);
      }

      index++;
    }

    return numberStack.pop().toString();
  }

  public static String expressionParser(String expression) {

    if (expression == null || expression.isBlank()) {
      return null;
    }

    Deque<Character> operators          = new LinkedList<>();
    StringBuilder reversePolishNotation = new StringBuilder();

    for (int i = 0; i < expression.length(); i++) {
      char numberOrOperator = expression.charAt(i);

      if (Character.isLetterOrDigit(numberOrOperator)) {
        reversePolishNotation.append(numberOrOperator);

      } else if (numberOrOperator == '(') {
        operators.push(numberOrOperator);

      } else if (numberOrOperator == ')') {

        while (!operators.isEmpty() && operators.peek() != '(') {
          reversePolishNotation.append(operators.pop());
        }

        operators.pop();
      }

      else {
        while (!operators.isEmpty()
            && getPrecedence(numberOrOperator) <= getPrecedence(operators.peek())) {
          reversePolishNotation.append(operators.pop());
        }

        operators.push(numberOrOperator);
      }
    }

    while (!operators.isEmpty()) {
      reversePolishNotation.append(operators.pop());
    }

    return processPolishNotation(reversePolishNotation.toString());
  }

  public static String calculator(String expression) {
    return expressionParser(expression);
  }

  public static void main(String[] args) {
    String expression = "(2+5*4)+(4+5)";
    System.out.println(Interview01.calculator(expression));
  }
}
