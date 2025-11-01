/**
 * Given the head of a linked list, remove the nth node from the
 * end of the list and return its head.
 */

package com.problem.solving.leetcode.problems.list;

import com.problem.solving.leetcode.definitions.ListNode;

public class RemoveNthNodeList {

  public ListNode removeNthFromEnd(ListNode head, int offset) {

    int size = 0;
    ListNode currentNode  = head;
    ListNode previousNode = null;

    while (currentNode != null) {
      currentNode = currentNode.next;
      size++;
    }

    int index = 0;
    int targetNodePosition = size - offset;

    previousNode = head;
    currentNode = head;

    while (currentNode != null) {

      if (targetNodePosition == 0) {
        head = head.next;
        break;
      }

      if (index == targetNodePosition) {
        previousNode.next = currentNode.next;
        System.out.println(targetNodePosition);
        break;
      }

      index++;
      previousNode = currentNode;
      currentNode = currentNode.next;
    }

    return head;
  }

}
