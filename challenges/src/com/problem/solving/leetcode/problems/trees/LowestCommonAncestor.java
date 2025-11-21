/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes
 * in the BST.
 *
 * <p>According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined
 * between two nodes p and q as the lowest node in T that has both p and q as descendants (where we
 * allow a node to be a descendant of itself).”
 */
package com.problem.solving.leetcode.problems.trees;

import com.problem.solving.leetcode.problems.definitions.TreeNode;

public class LowestCommonAncestor {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    int pVal = p.val;
    int qVal = q.val;

    while (root != null) {
      int parentVal = root.val;

      if (pVal > parentVal && qVal > parentVal) {
        root = root.right;
      }

      else if (pVal < parentVal && qVal < parentVal) {
        root = root.left;
      }

      else {
        return root;
      }

    }

    return null;
  }
}
