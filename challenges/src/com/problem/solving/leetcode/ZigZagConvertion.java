package com.problem.solving.leetcode;

import java.util.ArrayList;import java.util.List; /**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 * And then read line by line: "PAHNAPLSIIGYIR"
 */
public class ZigZagConvertion {

  public String convert(String input, int numRows) {

    if (numRows < 2) {
      return input;
    }

    List<List<Character>> rows = new ArrayList<>();

    for (int i = 0; i < numRows; i++) {
      rows.add(new ArrayList<>());
    }

    int rowNumber = 0;
    boolean increase = true;

    for (int index = 0; index < input.length(); index++) {
      rows.get(rowNumber).add(input.charAt(index));

      if (increase) {
        rowNumber+=1;
      }

      else {
        rowNumber-=1;
      }

      if (rowNumber == numRows - 1) {
          increase = false;
          rowNumber = numRows - 1;
      }

      else if (rowNumber == 0) {
          increase = true;
      }
    }

    StringBuilder solution = new StringBuilder();
    for (int i = 0; i < rows.size(); i++) {
        List<Character> rowInfo = rows.get(i);

        for (int j = 0; j < rowInfo.size(); j++) {
          solution.append(rowInfo.get(j));
        }
    }

    return solution.toString();
  }

  public static void main(String args[]) {

    String input = "PAYPALISHIRING";
    int numRows = 2;

    ZigZagConvertion solution = new ZigZagConvertion();
    String result = solution.convert(input, numRows);

    System.out.println(result);
  }
}
