/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its
 * head.
 */
package com.problem.solving.leetcode.problems.list;

public class RemoveNthNode {

    public ListNode removeNthFromEnd_II(ListNode head, int n) {
        ListNode fakeHead  = new ListNode(0);
        fakeHead.next      = head;
        ListNode first     = fakeHead;
        ListNode second    = fakeHead;

        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }

        while  (first != null) {
            first  = first.next;
            second = second.next;
        }

        second.next = second.next.next;

        return fakeHead.next;
    }

  public ListNode removeNthFromEnd(ListNode head, int n) {

    ListNode current = head;
    ListNode prev = head;

    int size = 0;
    while (current != null) {
      size++;
      current = current.next;
    }

    int index = 0;
    int target = size - n;
    current = head;

    if (size == 1) {
      return null;
    }

    while (current != null) {

      if (index == target && target > 0) {
        prev.next = current.next;
        break;
      } else if (index == target && target == 0) {
        current.val = current.next.val;
        current.next = current.next.next;

        break;
      }

      index++;
      prev = current;
      current = current.next;
    }

    return head;
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

    RemoveNthNode removeNthNode = new RemoveNthNode();
    ListNode input1 = new ListNode(1);
    ListNode input2 = new ListNode(2);
    ListNode input3 = new ListNode(3);
    ListNode input4 = new ListNode(4);
    ListNode input5 = new ListNode(5);

    input1.next                = input2;
    input1.next.next           = input3;
    input1.next.next.next      = input4;
    input1.next.next.next.next = input5;

    int nthNode = 2;

    removeNthNode.showList(input1);
    removeNthNode.removeNthFromEnd_II(input1, nthNode);
    removeNthNode.showList(input1);
  }
}
