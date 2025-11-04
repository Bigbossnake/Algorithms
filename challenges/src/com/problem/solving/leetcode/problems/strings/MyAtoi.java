package com.problem.solving.leetcode.problems.strings;

public class MyAtoi {

    public int myAtoi(String input) {
        int index          = 0;
        boolean isNegative = false;
        Long integerValue  = 0L;
        input              = input.trim();

        if (input == null || input.isBlank()) {
            return integerValue.intValue();
        }

        if (input.length() == 1 && Character.isDigit(input.charAt(0))) {
            return Integer.parseInt(input);
        }

        if (input.charAt(index) == '+' || input.charAt(index) == '-') {

            if (input.charAt(index) == '-') {
                isNegative = true;
            }

            index++;
        }

        int length = input.length();
        while (index < length) {

            char digit = input.charAt(index);

            if (Character.isDigit(digit)) {
                int digitValue = (digit - '0');
                integerValue = integerValue * 10;

                if (isNegative) {
                    integerValue = integerValue - digitValue;

                    if (integerValue < Integer.MIN_VALUE) {
                        return Integer.MIN_VALUE;
                    }

                }

                else {
                    integerValue = integerValue + digitValue;

                    if (integerValue > Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    }
                }
            }

            else {
                return integerValue.intValue();
            }

            index++;
        }

        return integerValue.intValue();
    }

    public static void main(String[] args) {
        MyAtoi myAtoi = new MyAtoi();
        String myNumber = " 12   4";

        System.out.println(myAtoi.myAtoi(myNumber));
    }

}
