package com.problem.solving.leetcode.companies.microsoft.list;

public class MergekSortedLists_II {

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    int val1 = 0;
    int val2 = 0;

    ListNode head   = new ListNode();
    ListNode result = head;

    while (list1 != null || list2 != null) {

      val1 = (list1 != null) ? list1.val : Integer.MAX_VALUE;
      val2 = (list2 != null) ? list2.val : Integer.MAX_VALUE;

      if (val1 <= val2) {
        head.next = list1;
        head = head.next;

        list1 = list1.next;
      }

      if (val2 <= val1) {
        head.next = list2;
        head = head.next;

        list2 = list2.next;
      }
    }

    return result.next;
  }

  public ListNode mergeKLists(ListNode[] lists) {
    ListNode head = new ListNode(Integer.MIN_VALUE);

    for (ListNode list : lists) {
      head = mergeTwoLists(head, list);
    }

    return head.next;
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
    System.out.println();
  }

  public static void main(String[] args) {

    ListNode listNode1 = new ListNode(1);

    ListNode input1 = new ListNode(2);
    ListNode input2 = new ListNode(4);

    listNode1.next = input1;
    listNode1.next.next = input2;

    ListNode listNode2 = new ListNode(1);
    input1 = new ListNode(3);
    input2 = new ListNode(4);

    listNode2.next = input1;
    listNode2.next.next = input2;

    ListNode listNode3 = new ListNode(3);
    input1 = new ListNode(4);
    input2 = new ListNode(5);

    listNode3.next = input1;
    listNode3.next.next = input2;

    ListNode[] lists = {listNode1, listNode2, listNode3};

    MergekSortedLists_II merger = new MergekSortedLists_II();
    merger.showList(listNode1);
    merger.showList(listNode2);
    merger.showList(listNode3);

    ListNode mergedList = merger.mergeKLists(lists);
    merger.showList(mergedList);
  }
}
