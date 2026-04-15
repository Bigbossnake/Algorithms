package com.algorithms.examples.trees;

import com.algorithms.examples.trees.definitions.TreeNodeDef;

public class TreeTransversal {

  public TreeNodeDef insertNode(TreeNodeDef root, int val) {

    if (root == null) {
      return new TreeNodeDef(val);
    }

    if (val > root.val) {
      root.right = insertNode(root.right, val);
    }

    else {
      root.left = insertNode(root.left, val);
    }

    return root;
  }

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

    TreeNodeDef root = treeTransversal.insertNode(null, 50);
    treeTransversal.insertNode(root,40);
    treeTransversal.insertNode(root, 60);
    treeTransversal.insertNode(root, 30);
    treeTransversal.insertNode(root, 45);
    treeTransversal.insertNode(root, 58);
    treeTransversal.insertNode(root, 70);
    treeTransversal.insertNode(root, 25);
    treeTransversal.insertNode(root, 35);

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
