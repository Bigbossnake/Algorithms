/**
 * Given the head of a linked list, reverse the nodes of the list k at a time,
 * and return the modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 *
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 */
package com.problem.solving.leetcode;

import com.problem.solving.leetcode.definitions.ListNode;
import java.util.Stack;

public class ReverseKGroup {

  public ListNode reverseKGroup(ListNode head, int k) {

    boolean reverseWasApplied = false;
    ListNode solution         = head;
    ListNode previousKnode    = null;
    Stack<ListNode> kGroup    = new Stack<>();

    while (head != null) {
      kGroup.push(head);

      if (kGroup.size() == k) {

        ListNode kNode;
        ListNode nextKNode = kGroup.peek().next;

        while (!kGroup.isEmpty()) {
          kNode = kGroup.pop();

          if (previousKnode != null) {
            previousKnode.next = kNode;

            if (!reverseWasApplied) {
              solution = previousKnode;
              reverseWasApplied = true;
            }
          }

          previousKnode = kNode;
        }

        previousKnode.next = nextKNode;
        head = nextKNode;

        continue;
      }

      head = head.next;
    }

    return solution;
  }

  public static void main(String args[]) {
    ReverseKGroup solution = new ReverseKGroup();

    ListNode input = new ListNode(1);
    input.next = new ListNode(2);
    input.next.next = new ListNode(3);
    input.next.next.next = new ListNode(4);
    input.next.next.next.next = new ListNode(5);
    input.next.next.next.next.next = null;

    ListNode result = solution.reverseKGroup(input, 3);

    System.out.print("[ ");
    while (result != null) {
      System.out.print(result.val + " , ");
      result = result.next;
    }
    System.out.print("]");
  }

}
