package com.algorithms.examples.trees.DFS;

import com.algorithms.examples.trees.TreeNodeDef;

import java.util.Stack;

public class DFS_III {
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
