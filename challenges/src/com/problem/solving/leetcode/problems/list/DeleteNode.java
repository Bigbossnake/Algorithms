/**
 * There is a singly-linked list head and we want to delete a node node in it.
 *
 * <p>You are given the node to be deleted node. You will not be given access to the first node of
 * head.
 *
 * <p>All the values of the linked list are unique, and it is guaranteed that the given node node is
 * not the last node in the linked list.
 *
 * <p>Delete the given node. Note that by deleting the node, we do not mean removing it from memory.
 * We mean:
 *
 * <p>- The value of the given node should not exist in the linked list. - The number of nodes in
 * the linked list should decrease by one. - All the values before node should be in the same order.
 * - All the values after node should be in the same order.
 */
package com.problem.solving.leetcode.problems.list;

public class DeleteNode {

  public void deleteNode_II(ListNode node) {
      node.val  = node.next.val;
      node.next = node.next.next;
  }

  public void deleteNode(ListNode node) {

    ListNode current = node;

    while (current != null) {

      if (current.next != null) {
        current.val = current.next.val;

        if (current.next.next == null) {
          current.next = null;
        }
      }

      current = current.next;
    }
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

    DeleteNode deleteNode = new DeleteNode();
    ListNode input = new ListNode(1);
    ListNode input2 = new ListNode(2);
    ListNode input3 = new ListNode(3);
    ListNode input4 = new ListNode(4);
    ListNode input5 = new ListNode(5);

    input.next = input2;
    input.next.next = input3;
    input.next.next.next = input4;
    input.next.next.next.next = input5;

    deleteNode.showList(input);
    deleteNode.deleteNode_II(input2);
    deleteNode.showList(input);
  }
}
