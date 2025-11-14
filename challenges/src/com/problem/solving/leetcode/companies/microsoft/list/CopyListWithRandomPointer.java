/**
 * A linked list of length n is given such that each node contains an additional random pointer,
 * which could point to any node in the list, or null.
 *
 * <p>Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes,
 * where each new node has its value set to the value of its corresponding original node. Both the
 * next and random pointer of the new nodes should point to new nodes in the copied list such that
 * the pointers in the original list and copied list represent the same list state. None of the
 * pointers in the new list should point to nodes in the original list.
 *
 * <p>For example, if there are two nodes X and Y in the original list, where X.random --> Y, then
 * for the corresponding two nodes x and y in the copied list, x.random --> y.
 *
 * <p>Return the head of the copied linked list.
 *
 * <p>The linked list is represented in the input/output as a list of n nodes. Each node is
 * represented as a pair of [val, random_index] where:
 *
 * <p>- val: an integer representing Node.val - random_index: the index of the node (range from 0 to
 * n-1) that the random pointer points to, or null if it does not point to any node.
 *
 * <p>Your code will only be given the head of the original linked list.
 */
package com.problem.solving.leetcode.companies.microsoft.list;

import java.util.HashMap;
import java.util.Map;

class Node {
  int val;
  Node next;
  Node random;

  public Node(int val) {
    this.val    = val;
    this.next   = null;
    this.random = null;
  }
}

public class CopyListWithRandomPointer {

  public Node copyNode(Node node) {
    Node newNode = null;

    if (node != null) {
      newNode        = new Node(node.val);
      newNode.next   = null;
      newNode.random = null;
    }

    return newNode;
  }

  public Node copyRandomList(Node head) {
    Node oldHead = head;
    Node newHead = copyNode(oldHead);
    Node result  = newHead;

    if (head != null) {
      Map<Node, Node> indexedCopiedNodes = new HashMap<>();
      indexedCopiedNodes.put(oldHead, newHead);

      oldHead = oldHead.next;

      while (oldHead != null) {
        Node newNode = copyNode(oldHead);
        indexedCopiedNodes.put(oldHead, newNode);

        newHead.next = newNode;
        newHead      = newHead.next;
        oldHead      = oldHead.next;
      }

      oldHead = head;
      newHead = result;

      while (oldHead != null) {
        newHead.random = null;

        if (oldHead.random != null) {
          newHead.random = indexedCopiedNodes.get(oldHead.random);
        }

        oldHead = oldHead.next;
        newHead = newHead.next;
      }
    }

    return result;
  }
}
