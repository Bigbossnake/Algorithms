/**
 * You are given two non-empty linked lists representing two non-negative integers. The most
 * significant digit comes first and each of their nodes contains a single digit. Add the two
 * numbers and return the sum as a linked list.
 *
 * <p>You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
package com.problem.solving.leetcode.companies.microsoft.list;

public class AddTwoNumbers_II {

  public ListNode reverseList(ListNode list) {
    ListNode prev    = null;
    ListNode current = list;
    ListNode next    = null;

    while (current != null) {
      next         = current.next;
      current.next = prev;
      prev         = current;
      current      = next;
    }

    return prev;
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode reverseList1 = reverseList(l1);
    ListNode reverseList2 = reverseList(l2);
    ListNode result       = new ListNode();

    int totalSum = 0;
    int carry    = 0;

    while (reverseList1 != null || reverseList2 != null) {

      if (reverseList1 != null) {
        totalSum += reverseList1.val;
        reverseList1 = reverseList1.next;
      }

      if (reverseList2 != null) {
        totalSum += reverseList2.val;
        reverseList2 = reverseList2.next;
      }

      result.val    = totalSum % 10;
      carry         = totalSum / 10;
      ListNode node = new ListNode(carry);
      node.next     = result;
      result        = node;
      totalSum      = carry;
    }

    return carry == 0 ? result.next : result;
  }
}
