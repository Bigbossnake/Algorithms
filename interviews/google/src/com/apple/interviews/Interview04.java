package com.apple.interviews;

/*
 * Given the head of a linked list, rotate the list to the right by k places.
 *
 * eg 1:
 *
 * Input: head = [1, 2, 3, 4, 5], k=2
 * Output: [4, 5, 1, 2, 3]
 *
 * 1 -> 2 -> 3 -> 4 -> 5
 * 4 -> 5 -> 1 -> 2 -> 3
 *
 * eg 2:
 *
 * Input: head = [0, 3, 4], k=4
 * Output: [4, 0, 3]
 */

import java.util.LinkedList;
import java.util.Queue;

class ListNode {
    int val;
    ListNode next;

    ListNode() {

    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Interview04 {

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null) {
            return head;
        }

        if (head.next == null || k == 0) {
            return head;
        }

        int sizeList         = 0;
        ListNode currentNode = head;
        ListNode lastNode    = null;

        while (currentNode != null) {

            if (currentNode.next == null) {
                lastNode = currentNode;
            }

            sizeList++;
            currentNode = currentNode.next;
        }

        int index          = 0;
        int offsetPosition = 0 + k;
        ListNode rotatedHead = null;

        if (offsetPosition > sizeList) {
            offsetPosition = k % sizeList;
        }

        currentNode = head;
        Queue<ListNode> pendingNodes = new LinkedList<>();

        while (rotatedHead == null) {

            pendingNodes.add(currentNode);
            currentNode = currentNode.next;
            index++;

            if (index == offsetPosition) {
                rotatedHead = currentNode == null ? head.next : currentNode.next;
                break;
            }
        }

        while (!pendingNodes.isEmpty()) {
            ListNode pendingNode = pendingNodes.poll();
            pendingNode.next     = null;

            lastNode.next = pendingNode;
            lastNode      = pendingNode;
        }

        return rotatedHead;
    }

    public static void main (String args[]) {
        Interview04 rotateList = new Interview04();

        int k = 2;
        ListNode head;

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        head = node1;
        ListNode rotatedHead = rotateList.rotateRight(head, k);

        while (rotatedHead != null) {
            System.out.print(rotatedHead.val + " ,");
            rotatedHead = rotatedHead.next;
        }
    }
}

