/**
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 *
 * <p>There is a cycle in a linked list if there is some node in the list that can be reached again
 * by continuously following the next pointer. Internally, pos is used to denote the index of the
 * node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 *
 * <p>Return true if there is a cycle in the linked list. Otherwise, return false.
 */
package com.problem.solving.leetcode.problems.list;

public class LinkedListCycle {

  // Floyd's Cycle Algorithm
  public boolean hasCycle(ListNode head) {
    boolean hasCycle = false;

    if (head == null) {
      return hasCycle;
    }

    ListNode slow = head;
    ListNode fast = head.next;

    while (slow != fast) {
      if (fast == null || fast.next == null) {
        return hasCycle;
      }

      slow = slow.next;
      fast = fast.next.next;
    }

    return !hasCycle;
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

  public static void main(String args[]) {
    LinkedListCycle cycleDetector = new LinkedListCycle();

    ListNode input1 = new ListNode(1);
    ListNode input2 = new ListNode(2);
    ListNode input3 = new ListNode(3);
    ListNode input4 = new ListNode(4);
    ListNode input5 = new ListNode(5);

    input1.next = input2;
    input1.next.next = input3;
    input1.next.next.next = input4;
    input1.next.next.next.next = input1;

    if (!cycleDetector.hasCycle(input1)) {
      cycleDetector.showList(input1);
    } else {
      System.out.println("Cycle found");
    }
  }
}
