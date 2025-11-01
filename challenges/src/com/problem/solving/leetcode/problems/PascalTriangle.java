/**
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 */
package com.problem.solving.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {

  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> pascalTriangle = new ArrayList<>();
    int pascalRowSize = 1;

    Integer[] currentPascalRow  = new Integer[pascalRowSize];
    Integer[] previousPascalRow = new Integer[pascalRowSize];
    currentPascalRow[0] = 1;

    if (numRows > 0) {

      for (int i = 0; i < numRows; i++) {

        if (i > 1) {
          int currentPascalRowIndex = 1;
          for (int j = 0; j < previousPascalRow.length - 1; j++) {
            currentPascalRow[currentPascalRowIndex] = previousPascalRow[j] + previousPascalRow[j + 1];
            currentPascalRowIndex++;
          }
        }

        pascalTriangle.add(Arrays.asList(currentPascalRow));
        pascalRowSize++;
        previousPascalRow = currentPascalRow;
        currentPascalRow  = new Integer[pascalRowSize];
        currentPascalRow[0] = 1;
        currentPascalRow[currentPascalRow.length - 1] = 1;
      }
    }

    return pascalTriangle;
  }

  public static void main(String args[]) {
    PascalTriangle pascalTriangleGenerator = new PascalTriangle();
    pascalTriangleGenerator.generate(4);
  }

}
