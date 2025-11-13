/**
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * <p>Merge the two lists into one sorted list. The list should be made by splicing together the
 * nodes of the first two lists.
 *
 * <p>Return the head of the merged linked list.
 */
package com.problem.solving.leetcode.companies.microsoft.list;

public class MergeTwoSortedLists {

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    int val1 = 0;
    int val2 = 0;

    ListNode head    = new ListNode();
    ListNode result  = head;

    while (list1 != null || list2 != null) {

        val1 = (list1 != null) ? list1.val : Integer.MAX_VALUE;
        val2 = (list2 != null) ? list2.val : Integer.MAX_VALUE;

        if (val1 <= val2) {
            head.next = list1;
            head      = head.next;

            list1 = list1.next;
        }

        if (val2 <= val1) {
            head.next = list2;
            head      = head.next;

            list2 = list2.next;
        }
    }

    return result.next;
  }

  public void showList(ListNode node) {
    System.out.print("[");

    while (node != null) {

      if (node.next != null) {
        System.out.print(node.val + ", ");
        node = node.next;
        continue;
      }

      System.out.print(node.val);
      node = node.next;
    }

    System.out.print("]");
    System.out.println("\n");
  }

  public static void main(String[] args) {

    ListNode input1 = new ListNode(1);
    ListNode input2 = new ListNode(2);
    ListNode input3 = new ListNode(4);

    input1.next                = input2;
    input1.next.next           = input3;

    ListNode input6 = new ListNode(1);
    ListNode input7 = new ListNode(3);
    ListNode input8 = new ListNode(4);

    input6.next      = input7;
    input6.next.next = input8;

    MergeTwoSortedLists merger = new MergeTwoSortedLists();

    ListNode mergedList = merger.mergeTwoLists(input1, input6);
    merger.showList(mergedList);
  }
}
