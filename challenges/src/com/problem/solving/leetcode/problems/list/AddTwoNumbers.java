package com.problem.solving.leetcode.problems.list;

import java.math.BigInteger;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
   }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result;
        ListNode current;
        BigInteger base10Shift   = BigInteger.valueOf(1);
        BigInteger listSummatory = BigInteger.valueOf(0);

        while (l1 != null) {
            listSummatory = listSummatory.add(BigInteger.valueOf(l1.val).multiply(base10Shift));

            l1 = l1.next;
            base10Shift = base10Shift.multiply(BigInteger.valueOf(10));

        }

        base10Shift = BigInteger.valueOf(1);
        while (l2 != null) {
            listSummatory = listSummatory.add(BigInteger.valueOf(l2.val).multiply(base10Shift));

            l2 = l2.next;
            base10Shift = base10Shift.multiply(BigInteger.valueOf(10));
        }

        StringBuilder totalString = new StringBuilder(listSummatory.toString()).reverse();

        result = new ListNode(Character.getNumericValue(totalString.charAt(0)));
        current = result;

        for (int i = 1; i <totalString.length(); i++) {
            current.next = new ListNode(Character.getNumericValue(totalString.charAt(i)));
            current = current.next;
        }

        current.next = null;

        return result;
    }

}
