package com.algorithms.examples.permutation;

import java.util.ArrayList;

public class ParenthesisCombination {

  private int numberOfParenthesis;
  private ArrayList<String> parenthesisCombinations;

  public ParenthesisCombination(int numberOfParenthesis) {
    this.numberOfParenthesis = numberOfParenthesis;
    parenthesisCombinations  = new ArrayList<String>();
  }

  public void generateParenthesis(ArrayList<String> parenthesisCombinations,
                                  String parenthesisCombination,
                                  int openParenthesis,
                                  int closedParenthesis) {

    if (openParenthesis > closedParenthesis) {
        return;
    }

    if (openParenthesis == 0 && closedParenthesis == 0) {
      parenthesisCombination += "\n";
      parenthesisCombinations.add(parenthesisCombination);
      return;
    }

    if (openParenthesis > 0) {
        generateParenthesis(
                parenthesisCombinations,
                parenthesisCombination += "(",
                openParenthesis - 1,
                closedParenthesis);
    }

    if (closedParenthesis > 0) {
        generateParenthesis(
                parenthesisCombinations,
                parenthesisCombination += ")",
                openParenthesis,
                closedParenthesis - 1);
    }

  }

  public void startGenerateParenthesis(int numberOfParenthesis) {
    System.out.println("Calling startGenerateParenthesis...");

    if (numberOfParenthesis > 0)
      generateParenthesis(parenthesisCombinations, "", numberOfParenthesis, numberOfParenthesis);
  }

  public static void main(String args[]) {
    System.out.println("*******************************************\n"
                     + "* AMAZON TEST #01 Combination Parenthesis *\n"
                     + "*******************************************\n");

    // Write Code Here
    ParenthesisCombination parenthesisGenerator = new ParenthesisCombination(5);
    parenthesisGenerator.startGenerateParenthesis(parenthesisGenerator.numberOfParenthesis);

    for (String parenthesisCombination : parenthesisGenerator.parenthesisCombinations)
      System.out.print(parenthesisCombination);

    System.out.println("END PROGRAM EXECUTION...");
  }
}
