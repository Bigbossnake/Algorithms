/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

package com.problem.solving.leetcode.problems.list;

import com.problem.solving.leetcode.definitions.ListNode;

public class ReverseList {

  public ListNode reverseList(ListNode input) {

    ListNode current = input;
    ListNode prev    = null;
    ListNode next    = null;

    while (current != null) {
      next         = current.next;
      current.next = prev;
      prev         = current;
      current      = next;
    }

    return prev;
  }


}
