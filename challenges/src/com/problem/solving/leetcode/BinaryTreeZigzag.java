/**
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes'
 * values. (i.e., from left to right, then right to left for the next level
 * and alternate between).
 */

package com.problem.solving.leetcode;

import com.problem.solving.leetcode.definitions.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzag {

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
          pendingNodes.add(currentNode.left);}

        if (currentNode.right != null ) {
          pendingNodes.add(currentNode.right);
        }
      }

      else {
        if (reverse) {
          Collections.reverse(levelValues);
        }

        zigZagLevelValues.add(levelValues);
        levelValues = new ArrayList<>();
        reverse = !reverse;

        if (!pendingNodes.isEmpty()) {
          pendingNodes.add(null);
        }

      }

    }

    return zigZagLevelValues;
  }

}
