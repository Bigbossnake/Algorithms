/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are
 * stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and
 * return the sum as a linked list.
 *
 * <p>You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
package com.problem.solving.leetcode.companies.microsoft.list;

class ListNode {
  int val;
  ListNode next;

  ListNode() {}

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

public class AddTwoNumbers {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode result  = new ListNode(0);
      ListNode current = result;
      int carry        = 0;

      while (l1 != null || l2 != null || carry != 0) {
          int x   = (l1 != null) ? l1.val : 0;
          int y   = (l2 != null) ? l2.val : 0;
          int sum = carry + x + y;

          carry        = sum / 10;
          current.next = new ListNode(sum % 10);
          current      = current.next;

          if (l1 != null) {
              l1 = l1.next;
          }
          if (l2 != null) {
              l2 = l2.next;
          }
      }

    return result.next;
  }

}
