/**
 * You are given the heads of two sorted linked lists list1 and list2. Merge the two lists in a one
 * sorted list. The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 */
package com.problem.solving.leetcode.problems.list;

import com.problem.solving.leetcode.problems.definitions.ListNode;

public class Merge2List {

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

    ListNode prehead = new ListNode(-1);
    ListNode head = prehead;

    while (list1 != null && list2 != null) {

      if (list1.val <= list2.val) {
        head.next = list1;
        list1 = list1.next;
      }

      else {
        head.next = list2;
        list2 = list2.next;
      }

      head = head.next;
    }

    head.next = list1 == null ? list2 : list1;

    return prehead.next;
  }

  public static void main(String args[]) {
    Merge2List solution = new Merge2List();

    /*ListNode list1 = new ListNode(1);
    list1.next = new ListNode(2);
    list1.next.next = new ListNode(4);

    ListNode list2 = new ListNode(1);
    list2.next = new ListNode(3);
    list2.next.next = new ListNode(4);
    */

    ListNode list1 = new ListNode(2);
    list1.next = null;
    ListNode list2 = new ListNode(1);
    list2.next = null;

    ListNode result = solution.mergeTwoLists(list1, list2);

    while(result != null) {
      System.out.print(result.val + ", ");
      result = result.next;
    }
  }
}
