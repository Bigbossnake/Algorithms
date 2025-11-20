package com.algorithms.examples.trees;

import com.algorithms.examples.trees.definitions.TreeNodeDef;

public class TreeTransversal {

  public void inOrder(TreeNodeDef root) {
    if (root == null) {
      return;
    }

    inOrder(root.left);
    System.out.print(root.val + " ");
    inOrder(root.right);
  }

  public void preOrder(TreeNodeDef root) {
    if (root == null) {
      return;
    }

    System.out.print(root.val + " ");
    preOrder(root.left);
    preOrder(root.right);
  }

  public void postOrder(TreeNodeDef root) {
    if (root == null) {
      return;
    }

    postOrder(root.left);
    postOrder(root.right);
    System.out.print(root.val + " ");
  }
}
