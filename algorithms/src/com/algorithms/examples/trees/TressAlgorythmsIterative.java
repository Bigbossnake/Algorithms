package com.algorithms.examples.trees;

import com.algorithms.examples.trees.definitions.TreeNodeDef;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TressAlgorythmsIterative {

  public void BFS(TreeNodeDef root) {
    Queue<TreeNodeDef> pendingNodes = new LinkedList<>();
    pendingNodes.add(root);

    System.out.println("#########################################");
    System.out.println("#             BFS TRANSVERSAL           #");
    System.out.println("#########################################");

    while (!pendingNodes.isEmpty()) {

      TreeNodeDef currentNode = pendingNodes.poll();

      if (currentNode != null) {
        System.out.print(currentNode.val + " , ");

        if (currentNode.left != null) {
          pendingNodes.add(currentNode.left);
        }

        if (currentNode.right != null) {
          pendingNodes.add(currentNode.right);
        }
      }
    }

    System.out.println("\n");
  }

  public void DFS(TreeNodeDef root) {
    Stack<TreeNodeDef> pendingNodes = new Stack<>();
    pendingNodes.push(root);

    System.out.println("#########################################");
    System.out.println("#             DFS TRANSVERSAL           #");
    System.out.println("#########################################");

    while (!pendingNodes.isEmpty()) {
      TreeNodeDef currentNode = pendingNodes.pop();

      if (currentNode != null) {
        System.out.print(currentNode.val + " , ");

        if (currentNode.right != null) {
          pendingNodes.push(currentNode.right);
        }

        if (currentNode.left != null) {
          pendingNodes.push(currentNode.left);
        }
      }
    }

    System.out.println("\n");
  }

  public static void main(String[] args) {
    TressAlgorythmsIterative tressAlgorythmsIterative = new TressAlgorythmsIterative();

    TreeNodeDef root  = new TreeNodeDef(10);
    TreeNodeDef left  = new TreeNodeDef(9);
    TreeNodeDef right = new TreeNodeDef(20);

    root.left  = left;
    root.right = right;

    root.right.right = new TreeNodeDef(21);
    root.right.left  = new TreeNodeDef(17);

    root.left.right = new TreeNodeDef(8);
    root.left.left  = new TreeNodeDef(7);

    tressAlgorythmsIterative.BFS(root);
    tressAlgorythmsIterative.DFS(root);
  }
}
