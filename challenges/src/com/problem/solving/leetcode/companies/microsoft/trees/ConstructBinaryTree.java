package com.problem.solving.leetcode.companies.microsoft.trees;

import com.problem.solving.leetcode.problems.definitions.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTree {
  int preorderIndex;
  Map<Integer, Integer> inorderIndexMap;

  // build a hashmap to store value -> its index relations
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    preorderIndex   = 0;
    inorderIndexMap = new HashMap<>();

    for (int i = 0; i < inorder.length; i++) {
      inorderIndexMap.put(inorder[i], i);
    }

    return arrayToTree(preorder, 0, preorder.length - 1);
  }

  private TreeNode arrayToTree(int[] preorder, int left, int right) {

    // if there are no elements to construct the tree
    if (left > right) {
      return null;
    }

    // select the preorder_index element as the root and increment it
    int rootValue = preorder[preorderIndex++];
    TreeNode root = new TreeNode(rootValue);

    // build left and right subtree
    // excluding inorderIndexMap[rootValue] element because it's the root
    root.left = arrayToTree(
            preorder,
            left,
            inorderIndexMap.get(rootValue) - 1
    );

    root.right = arrayToTree(
            preorder,
            inorderIndexMap.get(rootValue) + 1,
            right
    );
    return root;
  }
}
