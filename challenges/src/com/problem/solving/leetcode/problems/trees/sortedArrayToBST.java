package com.problem.solving.leetcode.problems.trees;

import com.problem.solving.leetcode.problems.definitions.TreeNode;

public class sortedArrayToBST {

  public TreeNode buildBST_I(int nums[], int leftIndex, int rightIndex) {

    if (leftIndex > rightIndex) {
      return null;
    }

    // always choose left middle node as a root
    int middleIndex = (leftIndex + rightIndex) / 2;

    // preorder traversal: node -> left -> right
    TreeNode root = new TreeNode(nums[middleIndex]);
    root.left     = buildBST_I(nums, leftIndex, middleIndex - 1);
    root.right    = buildBST_I(nums, middleIndex + 1, rightIndex);

    return root;
  }

  public TreeNode buildBST_II(int nums[], int leftIndex, int rightIndex) {

    if (leftIndex > rightIndex) {
      return null;
    }

    int middleIndex = (leftIndex + rightIndex) / 2;

    // always choose right middle node as a root
    if ((leftIndex + rightIndex) % 2 == 1) {
      ++middleIndex;
    }

    // preorder traversal: node -> left -> right
    TreeNode root = new TreeNode(nums[middleIndex]);
    root.left     = buildBST_II(nums, leftIndex, middleIndex - 1);
    root.right    = buildBST_II(nums, middleIndex + 1, rightIndex);

    return root;
  }

  public TreeNode sortedArrayToBST(int[] nums) {
    return buildBST_I(nums, 0, nums.length - 1);
  }
}
