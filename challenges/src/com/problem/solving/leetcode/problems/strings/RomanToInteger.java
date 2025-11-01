package com.problem.solving.leetcode.problems.strings;

import java.util.HashMap;
import java.util.Optional;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, two is written as II in Roman numeral, just two one's added together.
 * Twelve is written as, XII, which is simply X + II. The number twenty seven is written
 * as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However,
 * the numeral for four is not IIII. Instead, the number four is written as IV.
 * Because the one is before the five we subtract it making four. The same principle
 * applies to the number nine, which is written as IX. There are six instances
 * where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 *
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the
 * range from 1 to 3999.
 */
public class RomanToInteger {

    public int romanToInt(String input) {

        HashMap<String, Integer> romanNumbers = new HashMap();

        romanNumbers.put("I", 1);
        romanNumbers.put("II", 2);
        romanNumbers.put("III", 3);
        romanNumbers.put("IV", 4);
        romanNumbers.put("V", 5);
        romanNumbers.put("VI", 6);
        romanNumbers.put("VII", 7);
        romanNumbers.put("VIII", 8);
        romanNumbers.put("IX", 9);
        romanNumbers.put("X", 10);
        romanNumbers.put("XX", 20);
        romanNumbers.put("XXX", 30);
        romanNumbers.put("XL", 40);
        romanNumbers.put("L", 50);
        romanNumbers.put("LX", 60);
        romanNumbers.put("LXX", 70);
        romanNumbers.put("LXXX", 80);
        romanNumbers.put("XC", 90);
        romanNumbers.put("C", 100);
        romanNumbers.put("CC", 200);
        romanNumbers.put("CCC", 300);
        romanNumbers.put("CD", 400);
        romanNumbers.put("D", 500);
        romanNumbers.put("DC", 600);
        romanNumbers.put("DCC", 700);
        romanNumbers.put("DCCC", 800);
        romanNumbers.put("CM", 900);
        romanNumbers.put("M", 1000);
        romanNumbers.put("MM", 2000);
        romanNumbers.put("MMM", 3000);

        int result = 0;
        char currentChar;
        char previousChar  = input.charAt(0);
        String romanNumber = "";

        for (int i = 0; i < input.length(); i++) {

            currentChar = input.charAt(i);
            romanNumber += currentChar;

            if (currentChar != previousChar) {

                if (Optional.ofNullable(romanNumbers.get(romanNumber)).isPresent()) {
                    result = result + romanNumbers.get(romanNumber);
                    romanNumber  = "";

                    if (i+1 < input.length()) {
                        previousChar = input.charAt(i+1);
                    }

                    continue;
                }

                result = result + romanNumbers.get(romanNumber.substring(0, romanNumber.length() - 1));
                romanNumber = "" + currentChar;
            }

            previousChar = currentChar;
        }

        if (!romanNumber.isEmpty()) {
            result = result + romanNumbers.get(romanNumber);
        }

        return result;
    }

    public static void main (String args[]) {
        RomanToInteger converter = new RomanToInteger();

        System.out.println(converter.romanToInt("XXXIV"));
    }

}
