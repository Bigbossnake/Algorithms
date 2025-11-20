/**
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has
 * two children. The binary tree has the following definition:
 *
 * <p>struct Node { int val; Node *left; Node *right; Node *next; }
 *
 * <p>Populate each next pointer to point to its next right node. If there is no next right node,
 * the next pointer should be set to NULL.
 *
 * <p>Initially, all next pointers are set to NULL.
 */
package com.problem.solving.leetcode.companies.microsoft.trees;

import com.problem.solving.leetcode.companies.definitions.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PopulatingNextRightPointers {

  public Node connect_II(Node root) {

    if (root == null) {
      return root;
    }

    Queue<Node> pendingNodes = new LinkedList<Node>();
    pendingNodes.add(root);

    while (!pendingNodes.isEmpty()) {

      int size = pendingNodes.size();

      for (int i = 0; i < size; i++) {
        Node node = pendingNodes.poll();

        if (i < size - 1) {
          node.next = pendingNodes.peek();
        }

        if (node.left != null) {
          pendingNodes.add(node.left);
        }
        if (node.right != null) {
          pendingNodes.add(node.right);
        }
      }
    }

    return root;
  }

  public Node connect(Node root) {

    if (root == null) {
      return root;
    }

    List<Node> levelNodes    = new ArrayList<>();
    Queue<Node> pendingNodes = new LinkedList<>();

    pendingNodes.add(root);
    pendingNodes.add(null);

    while (!pendingNodes.isEmpty()) {
      Node currentNode = pendingNodes.poll();

      if (currentNode != null) {
        levelNodes.add(currentNode);

        if (currentNode.left != null) {
          pendingNodes.add(currentNode.left);
        }

        if (currentNode.right != null) {
          pendingNodes.add(currentNode.right);
        }
      } else {
        Node node      = null;
        Node rightNode = null;

        for (int i = 0; i < levelNodes.size() - 1; i++) {
          node      = levelNodes.get(i);
          rightNode = levelNodes.get(i + 1);
          node.next = rightNode;
        }

        levelNodes.get(levelNodes.size() - 1).next = null;
        levelNodes = new ArrayList<>();

        if (!pendingNodes.isEmpty()) {
          pendingNodes.add(null);
        }
      }
    }

    return root;
  }
}
