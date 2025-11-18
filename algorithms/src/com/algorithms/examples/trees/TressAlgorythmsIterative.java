package com.algorithms.examples.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TressAlgorythmsIterative {

  public void BFS(TreeNodeDef root) {
    Queue<TreeNodeDef> pendingNodes = new LinkedList<>();
    pendingNodes.add(root);

    while (!pendingNodes.isEmpty()) {

      TreeNodeDef currentNode = pendingNodes.poll();

      if (currentNode != null) {
        System.out.print(currentNode.val + " , ");
      }

      if (currentNode != null && currentNode.left != null) {
        pendingNodes.add(currentNode.left);
      }

      if (currentNode != null && currentNode.right != null) {
        pendingNodes.add(currentNode.right);
      }
    }
  }

  public void DFS(TreeNodeDef root) {
    Stack<TreeNodeDef> pendingNodes = new Stack<>();
    pendingNodes.push(root);

    while (!pendingNodes.isEmpty()) {
      TreeNodeDef currentNode = pendingNodes.pop();

      if (currentNode != null) {
        System.out.println(currentNode.val);
      }

      if (currentNode != null && currentNode.left != null) {
        pendingNodes.push(currentNode.left);
      }

      if (currentNode != null && currentNode.right != null) {
        pendingNodes.push(currentNode.right);
      }
    }
  }
}
