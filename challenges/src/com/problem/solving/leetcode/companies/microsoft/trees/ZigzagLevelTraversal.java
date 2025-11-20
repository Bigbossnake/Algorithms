/**
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e.,
 * from left to right, level by level).
 */
package com.problem.solving.leetcode.companies.microsoft.trees;

import com.problem.solving.leetcode.problems.definitions.TreeNode;

import java.util.*;

public class ZigzagLevelTraversal {

  public void showZigzagLevels(List<List<Integer>> levelVales) {

    if (levelVales == null || levelVales.size() == 0) {
      System.out.println("Empty List");
      return;
    }

    for (int i = 0; i < levelVales.size(); i++) {
      List<Integer> levelList = levelVales.get(i);

      for (int nodeValue : levelList) {
        System.out.print(nodeValue + " ");
      }
      System.out.println();
    }
  }

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> zigZagLevelValues = new ArrayList<>();

    if (root == null) {
      return zigZagLevelValues;
    }

    boolean reverse = false;
    List<Integer> levelValues    = new ArrayList<>();
    Queue<TreeNode> pendingNodes = new LinkedList<>();

    pendingNodes.add(root);
    pendingNodes.add(null);

    while (!pendingNodes.isEmpty()) {

      TreeNode currentNode = pendingNodes.poll();

      if (currentNode != null) {
        levelValues.add(currentNode.val);

        if (currentNode.left != null) {
          pendingNodes.add(currentNode.left);
        }

        if (currentNode.right != null) {
          pendingNodes.add(currentNode.right);
        }
      } else {

        if (reverse) {
          Collections.reverse(levelValues);
        }

        zigZagLevelValues.add(levelValues);
        levelValues = new ArrayList<>();
        reverse     = !reverse;

        if (!pendingNodes.isEmpty()) {
          pendingNodes.add(null);
        }
      }
    }

    return zigZagLevelValues;
  }

  public static void main(String[] args) {
    ZigzagLevelTraversal traversal = new ZigzagLevelTraversal();

    TreeNode root  = new TreeNode(10);
    TreeNode left  = new TreeNode(9);
    TreeNode right = new TreeNode(20);

    root.left  = left;
    root.right = right;

    root.right.right = new TreeNode(21);
    root.right.left  = new TreeNode(17);

    root.left.right = new TreeNode(7);
    root.left.left  = new TreeNode(8);
    
    traversal.showZigzagLevels(traversal.zigzagLevelOrder(root));
  }
}
