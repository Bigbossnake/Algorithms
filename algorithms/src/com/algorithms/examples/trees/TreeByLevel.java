package com.algorithms.examples.trees;

import com.algorithms.examples.trees.definitions.TreeNodeDef;

import java.util.*;

public class TreeByLevel {

  public void transverseTreeByLevel(TreeNodeDef root) {
    Queue<TreeNodeDef> pendingNodes = new LinkedList<>();

    pendingNodes.add(root);
    pendingNodes.add(null);

    System.out.println("#########################################");
    System.out.println("#         TRANSVERSE TREE BY LEVEL      #");
    System.out.println("#########################################");

    while (!pendingNodes.isEmpty()) {
      TreeNodeDef currentNode = pendingNodes.poll();

      if (currentNode != null) {
        System.out.print(currentNode.val + " ");

        if (currentNode.left != null) {
          pendingNodes.add(currentNode.left);
        }

        if (currentNode.right != null) {
          pendingNodes.add(currentNode.right);
        }
      } else {
        System.out.println();

        if (!pendingNodes.isEmpty()) {
          pendingNodes.add(null);
        }
      }
    }
  }

  public void processTreeByLevel(TreeNodeDef root) {
    Queue<TreeNodeDef> pendingNodes = new LinkedList<>();
    List<TreeNodeDef> levelNodes    = new ArrayList<>();

    pendingNodes.add(root);
    pendingNodes.add(null);

    System.out.println("#########################################");
    System.out.println("#         PROCESS TREE BY LEVEL         #");
    System.out.println("#########################################");

    while (!pendingNodes.isEmpty()) {
      TreeNodeDef currentNode = pendingNodes.poll();

      if (currentNode != null) {
        levelNodes.add(currentNode);

        if (currentNode.left != null) {
          pendingNodes.add(currentNode.left);
        }

        if (currentNode.right != null) {
          pendingNodes.add(currentNode.right);
        }
      } else {

        for (int i = 0; i < levelNodes.size(); i++) {
          System.out.print(levelNodes.get(i).val + " ");
        }

        System.out.println();
        levelNodes = new ArrayList<>();

        if (!pendingNodes.isEmpty()) {
          pendingNodes.add(null);
        }
      }
    }
  }

  public static void main(String[] args) {
    TreeByLevel treeByLevel = new TreeByLevel();

    TreeNodeDef root  = new TreeNodeDef(10);
    TreeNodeDef left  = new TreeNodeDef(9);
    TreeNodeDef right = new TreeNodeDef(20);

    root.left  = left;
    root.right = right;

    root.right.right = new TreeNodeDef(21);
    root.right.left  = new TreeNodeDef(17);

    root.left.right = new TreeNodeDef(7);
    root.left.left  = new TreeNodeDef(8);

    treeByLevel.transverseTreeByLevel(root);
    treeByLevel.processTreeByLevel(root);
  }
}
