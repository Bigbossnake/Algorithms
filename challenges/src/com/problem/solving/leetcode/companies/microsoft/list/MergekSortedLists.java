/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * <p>Merge all the linked-lists into one sorted linked-list and return it.
 */
package com.problem.solving.leetcode.companies.microsoft.list;

import java.util.HashMap;
import java.util.Map;

public class MergekSortedLists {

  public ListNode mergeKLists(ListNode[] lists) {
    ListNode head   = new ListNode();
    ListNode result = head;
    Map<Integer, ListNode> indexes = new HashMap<>();

    int index = 0;
    for (ListNode node : lists) {
      if (node != null) {
        indexes.put(index++, node);
      }
    }

    if (!indexes.isEmpty()) {
      int minIndex     = 0;
      int minValue     = indexes.get(minIndex).val;
      int indexesSize = indexes.size();
      ListNode minNode = indexes.get(minIndex);

      while (!indexes.isEmpty()) {

        index = 0;
        while (index < indexesSize) {

          if (indexes.get(index) != null) {
            int currentValue = indexes.get(index).val;

            if (currentValue < minValue || minValue == Integer.MIN_VALUE) {
              minValue = currentValue;
              minIndex = index;
              minNode  = indexes.get(minIndex);
            }
          }

          index++;
        }

        if (minNode != null) {
            head.next = minNode;
            head      = head.next;
            minNode   = minNode.next;

            indexes.put(minIndex, minNode);

            if (minNode == null) {
                indexes.remove(minIndex);
            }
        }

        minValue = Integer.MIN_VALUE;
        minIndex = -1;
      }
    }

    return result.next;
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

    listNode1.next      = input1;
    listNode1.next.next = input2;

    ListNode listNode2 = new ListNode(1);
    input1 = new ListNode(3);
    input2 = new ListNode(4);

    listNode2.next      = input1;
    listNode2.next.next = input2;

    ListNode listNode3 = new ListNode(3);
    input1 = new ListNode(4);
    input2 = new ListNode(5);

    listNode3.next      = input1;
    listNode3.next.next = input2;

    ListNode[] lists = {listNode1, listNode2};

    MergekSortedLists merger = new MergekSortedLists();
    merger.showList(listNode1);
    merger.showList(listNode2);
    merger.showList(listNode3);

    ListNode mergedList = merger.mergeKLists(lists);
    merger.showList(mergedList);
  }
}
