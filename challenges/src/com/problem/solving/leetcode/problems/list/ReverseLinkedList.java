/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
package com.problem.solving.leetcode.problems.list;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev    = null;
        ListNode current = head;
        ListNode next    = null;

        while (current != null) {
            next         = current.next;
            current.next = prev;
            prev         = current;
            current      = next;
        }

        return prev;
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
        ReverseLinkedList reverse = new ReverseLinkedList();

        ListNode input1 = new ListNode(1);
        ListNode input2 = new ListNode(2);
        ListNode input3 = new ListNode(3);
        ListNode input4 = new ListNode(4);
        ListNode input5 = new ListNode(5);

        input1.next                = input2;
        input1.next.next           = input3;
        input1.next.next.next      = input4;
        input1.next.next.next.next = input5;

        reverse.showList(input1);
        input1 = reverse.reverseList(input1);
        reverse.showList(input1);
    }
}
