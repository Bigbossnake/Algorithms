package com.problem.solving.leetcode.problems.list;

import java.util.Stack;

public class PalindromeLinkedList {

  private ListNode frontPointer;

  private boolean recursivelyCheck(ListNode currentNode) {

    if (currentNode != null) {
      if (!recursivelyCheck(currentNode.next)) {
          return false;
      }

      if (currentNode.val != frontPointer.val) {
          return false;
      }

      frontPointer = frontPointer.next;
    }

    return true;
  }

  public boolean isPalindrome_II(ListNode head) {
    frontPointer = head;
    return recursivelyCheck(head);
  }

  public boolean isPalindrome(ListNode head) {
    boolean isPalindrome = true;
    Stack<Integer> valuesStack = new Stack<>();

    ListNode dummyHead = head;
    while (dummyHead != null) {
      valuesStack.push(dummyHead.val);
      dummyHead = dummyHead.next;
    }

    dummyHead = head;
    while (dummyHead != null) {

      if (dummyHead.val != valuesStack.pop()) {
        isPalindrome = false;
        break;
      }
      dummyHead = dummyHead.next;
    }

    return isPalindrome;
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

  public void showReverseList(ListNode node) {
    if (node == null) {
      return;
    }

    showReverseList(node.next);
    System.out.println(node.val);
  }

  public static void main(String[] args) {
    PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();

    ListNode input1 = new ListNode(1);
    ListNode input2 = new ListNode(2);
    ListNode input3 = new ListNode(2);
    ListNode input4 = new ListNode(2);
    ListNode input5 = new ListNode(1);

    input1.next = input2;
    input1.next.next = input3;
    input1.next.next.next = input4;
    input1.next.next.next.next = input5;

    palindromeLinkedList.showList(input1);
    System.out.println(palindromeLinkedList.isPalindrome_II(input1));
    palindromeLinkedList.showReverseList(input1);
  }
}
