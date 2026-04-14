/**
 * Given two binary strings a and b, return their sum as a binary string.
 */
package com.problem.solving.leetcode.problems.strings;

public class AddBinary {

  public String addBinary(String a, String b) {
    String num1 = a;
    String num2 = b;

    if (a.length() < b.length()) {
      num1 = b;
      num2 = a;
    }

    int carry = 0;
    int num1Index = num1.length() - 1;
    int num2Index = num2.length() - 1;
    StringBuilder result = new StringBuilder("");

    while (num1Index >= 0 || num2Index >= 0) {
      char currentChar1 = (num1Index >= 0) ? num1.charAt(num1Index) : '0';
      char currentChar2 = (num2Index >= 0) ? num2.charAt(num2Index) : '0';

      int sum = (currentChar1 - '0') + (currentChar2 - '0') + carry;

      if (sum == 0) {
        result.append('0');
        carry = 0;
      }

      else if (sum == 1) {
        result.append('1');
        carry = 0;
      }

      else if (sum == 2) {
        result.append('0');
        carry = 1;
      }

      else if (sum == 3) {
        result.append('1');
        carry = 1;
      }

      num1Index--;
      num2Index--;
    }

    if (carry > 0) {
      result.append('1');
    }

    return result.reverse().toString();
  }

  public static void main(String[] args) {
    AddBinary addBinary = new AddBinary();
    String a = "1010";
    String b = "1";

    System.out.println(addBinary.addBinary(a, b));
  }
}
