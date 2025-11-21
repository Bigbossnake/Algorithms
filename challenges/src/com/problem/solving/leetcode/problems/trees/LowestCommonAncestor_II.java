package com.problem.solving.leetcode.problems.trees;

import com.problem.solving.leetcode.problems.definitions.TreeNode;

public class LowestCommonAncestor_II {

  private TreeNode lowestCommonAncestor;

  private boolean findLowestCommonAncestor(TreeNode currentNode, TreeNode p, TreeNode q) {

    if (currentNode == null) {
      return false;
    }

    int left  = findLowestCommonAncestor(currentNode.left, p, q) ? 1 : 0;
    int right = findLowestCommonAncestor(currentNode.right, p, q) ? 1 : 0;
    int mid   = (currentNode == p || currentNode == q) ? 1 : 0;

    if (mid + left + right >= 2) {
      this.lowestCommonAncestor = currentNode;
    }

    return (mid + left + right > 0);
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    findLowestCommonAncestor(root, p, q);
    return lowestCommonAncestor;
  }
}
