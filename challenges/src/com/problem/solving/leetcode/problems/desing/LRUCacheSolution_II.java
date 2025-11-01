/**
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 *
 * Implement the LRUCache class:
 *
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 */

package com.problem.solving.leetcode.problems.desing;

import java.util.HashMap;
import java.util.Map;

class ListNode {
    int key;
    int val;
    ListNode next;
    ListNode prev;

    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCacheSolution_II {
    int capacity;
    Map<Integer, ListNode> dic;
    ListNode head;
    ListNode tail;

    public LRUCacheSolution_II(int capacity) {
        this.capacity = capacity;

        dic  = new HashMap<>();
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!dic.containsKey(key)) {
            return -1;
        }

        ListNode node = dic.get(key);
        remove(node);
        add(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (dic.containsKey(key)) {
            ListNode oldNode = dic.get(key);
            remove(oldNode);
        }

        ListNode node = new ListNode(key, value);
        dic.put(key, node);
        add(node);

        if (dic.size() > capacity) {
            ListNode nodeToDelete = head.next;
            remove(nodeToDelete);
            dic.remove(nodeToDelete.key);
        }
    }

    public void add(ListNode node) {
        ListNode previousEnd = tail.prev;
        previousEnd.next = node;
        node.prev = previousEnd;
        node.next = tail;
        tail.prev = node;
    }

    public void remove(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
