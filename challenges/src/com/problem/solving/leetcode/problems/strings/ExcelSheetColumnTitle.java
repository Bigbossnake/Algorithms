/**
 * Given an integer columnNumber, return its corresponding column title as it appears in an Excel
 * sheet.
 */
package com.problem.solving.leetcode.problems.strings;

public class ExcelSheetColumnTitle {

  private static final char[] ALPHABET = {
    'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
    'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
  };

  private static final int ALPHABET_SIZE = ALPHABET.length;

  public String convertToTitle(int columnNumber) {
    StringBuilder columnTitle = new StringBuilder();

    int alphabetIndex;
    while (columnNumber > 0) {
      alphabetIndex = columnNumber % ALPHABET_SIZE;

      if (alphabetIndex > 0 && alphabetIndex <= ALPHABET_SIZE) {
        alphabetIndex = alphabetIndex - 1;

        columnTitle.append(ALPHABET[alphabetIndex]);
        columnNumber = columnNumber / ALPHABET_SIZE;
        continue;
      }

      alphabetIndex = ALPHABET_SIZE - 1;
      columnTitle.append(ALPHABET[alphabetIndex]);
      columnNumber = columnNumber / ALPHABET_SIZE - 1;
    }

    return columnTitle.reverse().toString();
  }

  public static void main(String[] args) {
    ExcelSheetColumnTitle excelSheetColumnTitle = new ExcelSheetColumnTitle();

    System.out.println(excelSheetColumnTitle.convertToTitle(701));
  }
}
