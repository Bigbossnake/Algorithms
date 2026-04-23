package com.problem.solving.leetcode.problems.strings;

public class ExcelSheetColumnNumber {

  public int titleToNumber(String columnTitle) {

    int columnNumber = 0;
    int base26       = 26;
    int powerOf26    = columnTitle.length() - 1;

    for (int i = 0; i < columnTitle.length(); i++) {
      char currentChar     = columnTitle.charAt(i);
      int currentCharValue = currentChar - 'A' + 1;

      columnNumber = (int) (columnNumber + currentCharValue * Math.pow(base26, powerOf26));
      powerOf26--;
    }

    return columnNumber;
  }

  public static void main(String[] args) {
    ExcelSheetColumnNumber excelSheetColumnNumber = new ExcelSheetColumnNumber();
    String columnTitle = "A";
    int result = excelSheetColumnNumber.titleToNumber(columnTitle);

    System.out.println("Excel column number for '" + columnTitle + "': " + result);
  }

}
