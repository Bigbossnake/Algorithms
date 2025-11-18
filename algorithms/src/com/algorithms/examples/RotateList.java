package com.algorithms.examples;

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
import java.util.Objects;
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

class RotateList {

  public ListNode rotateRight(ListNode head, int k) {

    int rotationCounter  = 0;
    ListNode currentNode = head;
    ListNode rotatedHead = null;
    ListNode lastNode    = null;

    Queue<ListNode> pendingNodes = new LinkedList<>();

    while (currentNode != null) {

      if (rotationCounter == k && rotatedHead == null) {
        pendingNodes.add(currentNode);
        rotatedHead = Objects.requireNonNullElse(currentNode.next, head);
      }

      if (rotatedHead == null) {
        pendingNodes.add(currentNode);
        rotationCounter++;
      }

      if (currentNode.next == null) {
          lastNode = currentNode;
      }

      currentNode = currentNode.next;

      if (currentNode == null && rotatedHead == null) {
        currentNode = head;
        pendingNodes.clear();
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
    RotateList rotateList = new RotateList();

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

