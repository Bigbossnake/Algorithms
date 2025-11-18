/** Given the root of a binary tree, return the inorder traversal of its nodes' values. */
package com.problem.solving.leetcode.companies.microsoft.Trees;

import com.problem.solving.leetcode.problems.definitions.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
  List<Integer> inorderTraversalList = new ArrayList<Integer>();

  public List<Integer> inorderTraversal_I(TreeNode root) {
    if (root == null) {
      return inorderTraversalList;
    }

    inorderTraversal_I(root.left);
    inorderTraversalList.add(root.val);
    inorderTraversal_I(root.right);

    return inorderTraversalList;
  }

  public List<Integer> inorderTraversal_II(TreeNode root) {
    List<Integer> inorderTraversalList = new ArrayList<Integer>();
    Stack<TreeNode> pendingNodes = new Stack<>();

    TreeNode currentNode = root;
    while (currentNode != null || !pendingNodes.isEmpty()) {

      while (currentNode != null) {
        pendingNodes.push(currentNode);
        currentNode = currentNode.left;
      }

      currentNode = pendingNodes.pop();
      inorderTraversalList.add(currentNode.val);
      currentNode = currentNode.right;
    }

    return inorderTraversalList;
  }
}
