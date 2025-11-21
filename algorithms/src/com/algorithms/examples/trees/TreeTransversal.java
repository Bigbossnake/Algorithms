package com.algorithms.examples.trees;

import com.algorithms.examples.trees.definitions.TreeNodeDef;

public class TreeTransversal {

  public void inOrder(TreeNodeDef root) {
    if (root == null) {
      return;
    }

    inOrder(root.left);
    System.out.print(root.val + " ,");
    inOrder(root.right);
  }

  public void preOrder(TreeNodeDef root) {
    if (root == null) {
      return;
    }

    System.out.print(root.val + " ,");
    preOrder(root.left);
    preOrder(root.right);
  }

  public void postOrder(TreeNodeDef root) {
    if (root == null) {
      return;
    }

    postOrder(root.left);
    postOrder(root.right);
    System.out.print(root.val + " ,");
  }

  public static void main(String[] args) {
    TreeTransversal treeTransversal = new TreeTransversal();

    TreeNodeDef root  = new TreeNodeDef(10);
    TreeNodeDef left  = new TreeNodeDef(9);
    TreeNodeDef right = new TreeNodeDef(20);

    root.left  = left;
    root.right = right;

    root.right.right = new TreeNodeDef(21);
    root.right.left  = new TreeNodeDef(17);

    root.left.right = new TreeNodeDef(8);
    root.left.left  = new TreeNodeDef(7);

    System.out.println("#########################################");
    System.out.println("#          IN-ORDER TRANSVERSAL          #");
    System.out.println("#########################################");
    treeTransversal.inOrder(root);
    System.out.println("\n");

    System.out.println("#########################################");
    System.out.println("#          PRE-ORDER TRANSVERSAL        #");
    System.out.println("#########################################");
    treeTransversal.preOrder(root);
    System.out.println("\n");

    System.out.println("#########################################");
    System.out.println("#         POST-ORDER TRANSVERSAL        #");
    System.out.println("#########################################");
    treeTransversal.postOrder(root);
    System.out.println("\n");
  }
}
