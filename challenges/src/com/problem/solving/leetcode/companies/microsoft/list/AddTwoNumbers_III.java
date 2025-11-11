/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are
 * stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and
 * return the sum as a linked list.
 *
 * <p>You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
package com.problem.solving.leetcode.companies.microsoft.list;

import java.util.Stack;

public class AddTwoNumbers_III {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    Stack<Integer> reverseList1 = new Stack<>();
    Stack<Integer> reverseList2 = new Stack<>();

    while (l1 != null) {
      reverseList1.push(l1.val);
      l1 = l1.next;
    }

    while (l2 != null) {
      reverseList2.push(l2.val);
      l2 = l2.next;
    }

    int totalSum    = 0;
    int carry       = 0;
    ListNode node   = null;
    ListNode result = new ListNode(0);

    while (!reverseList1.isEmpty() || !reverseList2.isEmpty()) {
      if (!reverseList1.isEmpty()) {
        totalSum += reverseList1.pop();
      }

      if (!reverseList2.isEmpty()) {
        totalSum += reverseList2.pop();
      }

      carry      = totalSum / 10;
      totalSum   = totalSum % 10;
      result.val = totalSum;
      node       = new ListNode(carry);
      node.next  = result;
      result     = node;
      totalSum   = carry;
    }

    return carry == 0 ? result.next : result;
  }
}
