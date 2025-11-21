package com.algorithms.examples.trees;

import com.algorithms.examples.trees.definitions.TreeNodeDef;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeByDepth {

  public void transverseTreeByDepth(TreeNodeDef root) {
    Stack<TreeNodeDef> pendingNodes = new Stack<>();
    List<TreeNodeDef> verticalNodes = new ArrayList<>();

    pendingNodes.push(root);
    pendingNodes.add(null);

    System.out.println("#########################################");
    System.out.println("#         PROCESS TREE BY DEPTH         #");
    System.out.println("#########################################");

    while (!pendingNodes.isEmpty()) {
      TreeNodeDef currentNode = pendingNodes.pop();

      if (currentNode != null) {
        verticalNodes.add(currentNode);

        if (currentNode.right != null) {
          pendingNodes.push(currentNode.right);
        }

        if (currentNode.left != null) {
          pendingNodes.push(currentNode.left);
        }

        if (currentNode.left == null && currentNode.right == null) {
          pendingNodes.push(null);
        }

      } else {
        if (!verticalNodes.isEmpty()) {
          for (int i = 0; i < verticalNodes.size(); i++) {
            System.out.print(verticalNodes.get(i).val + " ,");
          }

          System.out.println();
          verticalNodes = new ArrayList<>();
        }
      }
    }

    System.out.println("\n");
  }

  public static void main(String[] args) {
    TreeByDepth treeByDepth = new TreeByDepth();

    TreeNodeDef root = new TreeNodeDef(10);
    TreeNodeDef left = new TreeNodeDef(9);
    TreeNodeDef right = new TreeNodeDef(20);

    root.left = left;
    root.right = right;

    root.right.right = new TreeNodeDef(21);
    root.right.left = new TreeNodeDef(17);

    root.left.right = new TreeNodeDef(7);
    root.left.left = new TreeNodeDef(8);

    treeByDepth.transverseTreeByDepth(root);
  }
}
