/**
 * A valid IP address consists of exactly four integers separated by single dots. Each integer is
 * between 0 and 255 (inclusive) and cannot have leading zeros.
 *
 * <p>For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but - "0.011.255.245", -
 * "192.168.1.312" and - "192.168@1.1"
 *
 * <p>Are invalid IP addresses. Given a string s containing only digits, return all possible valid
 * IP addresses that can be formed by inserting dots into s.
 *
 * <p>You are not allowed to reorder or remove any digits in s. You may return the valid IP
 * addresses in any order.
 */
package com.problem.solving.leetcode.problems.backtracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {

  private static final int IP_SIZE = 4;

  private boolean valid(String ipDigit, int start, int length) {

    return (length == 1 || (ipDigit.charAt(start) != '0' && (length < 3
            || ipDigit.substring(start, start + length).compareTo("255") <= 0))
    );
  }

  private void generateIpAddresses(String input, int startIndex, List<Integer> dots, List<String> ans) {

    int remainingLength           = input.length() - startIndex;
    int remainingNumberOfIntegers = IP_SIZE - dots.size();

    if (remainingLength > remainingNumberOfIntegers * 3 || remainingLength < remainingNumberOfIntegers) {
      return;
    }

    if (dots.size() == 3) {

      if (valid(input, startIndex, remainingLength)) {
        int lastIndex = 0;
        StringBuilder sb = new StringBuilder();

        for (Integer dot : dots) {
          sb.append(input.substring(lastIndex, lastIndex + dot));
          lastIndex += dot;
          sb.append('.');
        }

        sb.append(input.substring(startIndex));
        ans.add(sb.toString());
      }

      return;
    }

    for (int curPos = 1; curPos <= 3 && curPos <= remainingLength; curPos++) {
      dots.add(curPos);

      if (valid(input, startIndex, curPos)) {
        generateIpAddresses(input, startIndex + curPos, dots, ans);
      }

      dots.remove(dots.size() - 1);
    }
  }

  public List<String> restoreIpAddresses(String s) {
    int startIndex = 0;

    List<Integer> ipDots  = new ArrayList<>();
    List<String> restoreIpAddressesList = new ArrayList<>();
    generateIpAddresses(s, startIndex, ipDots, restoreIpAddressesList);

    return restoreIpAddressesList;
  }

  public static void main(String[] args) {
    String rawIpAddress = "25525511135";
    RestoreIPAddresses restoreIPAddresses = new RestoreIPAddresses();

    System.out.println(restoreIPAddresses.restoreIpAddresses(rawIpAddress));
  }
}
