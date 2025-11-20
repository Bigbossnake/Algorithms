package com.algorithms.examples.trees.BFS;

import com.algorithms.examples.trees.definitions.TreeNodeDef;

import java.util.LinkedList;
import java.util.Queue;

public class BFS_III {
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
}
