package com.problem.solving.leetcode.problems.bitmanipulation;

public class DivideToIntegers {

  private static int HALF_INT_MIN = Integer.MIN_VALUE / 2;

  public int divide(int dividend, int divisor) {

    if (dividend == Integer.MIN_VALUE && divisor == -1) {
      return Integer.MAX_VALUE;
    }

    int negatives = 2;
    if (dividend > 0) {
      negatives--;
      dividend = -dividend;
    }

    if (divisor > 0) {
      negatives--;
      divisor = -divisor;
    }

    int highestDouble     = divisor;
    int highestPowerOfTwo = -1;
    while (highestDouble >= HALF_INT_MIN && dividend <= highestDouble + highestDouble) {
      highestPowerOfTwo = highestPowerOfTwo << 1;
      highestDouble     = highestDouble << 1;
    }

    int quotient = 0;
    while (dividend <= divisor) {
      if (dividend <= highestDouble) {
        quotient += highestPowerOfTwo;
        dividend -= highestDouble;
      }

      highestPowerOfTwo = highestPowerOfTwo >> 1;
      highestDouble     = highestDouble >> 1;
    }

    return (negatives != 1) ? -quotient : quotient;
  }

  public static void main(String args[]) {
    DivideToIntegers divider = new DivideToIntegers();

    int dividend = 10;
    int divisor = 2;

    System.out.println(divider.divide(dividend, divisor));
  }
}
