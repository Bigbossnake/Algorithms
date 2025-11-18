/**
 * Given the root of a binary tree, return its maximum depth.
 *
 * <p>A binary tree's maximum depth is the number of nodes along the longest path from the root node
 * down to the farthest leaf node.
 */
package com.problem.solving.leetcode.problems.trees;

import com.problem.solving.leetcode.problems.definitions.TreeNode;

import java.util.Stack;

public class MaximumDepth {

  public int maxDepth_recursive(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int leftDepth  = maxDepth_recursive(root.left);
    int rightDepth = maxDepth_recursive(root.right);

    return Math.max(leftDepth, rightDepth) + 1;
  }

  public int maxDepth(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    Stack<Integer> depths = new Stack<>();

    if (root == null) {
      return 0;
    }

    stack.add(root);
    depths.add(1);

    int level_depth = 0;
    int currentDepth = 0;

    while (!stack.isEmpty()) {
      TreeNode currentNode = stack.pop();
      currentDepth = depths.pop();

      if (currentNode != null) {
        level_depth = Math.max(level_depth, currentDepth);

        stack.add(currentNode.left);
        stack.add(currentNode.right);

        depths.add(currentDepth + 1);
        depths.add(currentDepth + 1);
      }
    }
    return level_depth;
  }
}
