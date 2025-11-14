/**
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two
 * lists intersect. If the two linked lists have no intersection at all, return null.
 */
package com.problem.solving.leetcode.companies.microsoft.list;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfLists {

    /** Note: In the case lists do not intersect, the pointers for A and B
     * will still line up in the 2nd iteration, just that here won't be
     * a common node down the list and both will reach their respective ends
     * at the same time: So pA will be NULL in that case.
     */
  public ListNode getIntersectionNode_II(ListNode headA, ListNode headB) {
    ListNode pA = headA;
    ListNode pB = headB;

    while (pA != pB) {
      pA = (pA == null) ? headB : pA.next;
      pB = (pB == null) ? headA : pB.next;
    }

    return pA;
  }

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode intersection       = null;
    Set<ListNode> intersections = new HashSet<>();

    while (headA != null) {
      intersections.add(headA);
      headA = headA.next;
    }

    while (headB != null) {
      if (intersections.contains(headB)) {
        intersection = headB;
        break;
      }

      headB = headB.next;
    }

    return intersection;
  }
}
