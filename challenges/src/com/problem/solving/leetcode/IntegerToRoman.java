package com.problem.solving.leetcode;

import java.util.Hashtable;

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
 *
 * For example, two is written as II in Roman numeral, just two one's added together.
 * Twelve is written as, XII, which is simply X + II. The number twenty seven is written
 * as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is written as IV.
 * Because the one is before the five we subtract it making four.
 *
 * The same principle applies to the number nine, which is written as IX.
 * There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 *
 * Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range
 * from 1 to 3999.
 *
 * Example 1:
 *
 * Input: 3
 * Output: "III"
 * Example 2:
 *
 * Input: 4
 * Output: "IV"
 * Example 3:
 *
 * Input: 9
 * Output: "IX"
 * Example 4:
 *
 * Input: 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 * Example 5:
 *
 * Input: 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
public class IntegerToRoman {

    public String intToRoman(int input) {

        Hashtable romanNumbers = new Hashtable<Integer, String>();

        romanNumbers.put(1, "I");
        romanNumbers.put(2, "II");
        romanNumbers.put(3, "III");
        romanNumbers.put(4, "IV");
        romanNumbers.put(5, "V");
        romanNumbers.put(6, "VI");
        romanNumbers.put(7, "VII");
        romanNumbers.put(8, "VIII");
        romanNumbers.put(9, "IX");
        romanNumbers.put(10, "X");
        romanNumbers.put(20, "XX");
        romanNumbers.put(30, "XXX");
        romanNumbers.put(40, "XL");
        romanNumbers.put(50, "L");
        romanNumbers.put(60, "LX");
        romanNumbers.put(70, "LXX");
        romanNumbers.put(80, "LXXX");
        romanNumbers.put(90, "XC");
        romanNumbers.put(100, "C");
        romanNumbers.put(200, "CC");
        romanNumbers.put(300, "CCC");
        romanNumbers.put(400, "CD");
        romanNumbers.put(500, "D");
        romanNumbers.put(600, "DC");
        romanNumbers.put(700, "DCC");
        romanNumbers.put(800, "DCCC");
        romanNumbers.put(900, "CM");
        romanNumbers.put(1000, "M");
        romanNumbers.put(2000, "MM");
        romanNumbers.put(3000, "MMM");

        int unit = 1;

        StringBuilder romeNumber = new StringBuilder();
        StringBuilder result     = new StringBuilder();
        while (input > 0) {

            int digit =  input%10;

            if (digit > 0) {
                romeNumber.append(romanNumbers.get(digit * unit));
                result.append(romeNumber.reverse());

                romeNumber.setLength(0);
            }

            unit  = unit*10;
            input = input/10;
        }

        return result.reverse().toString();
    }

    public static void main (String args[]) {
        IntegerToRoman converter = new IntegerToRoman();

        System.out.println(converter.intToRoman(1989));
    }

}
