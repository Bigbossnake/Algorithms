package com.problem.solving.leetcode.problems.trees;

import com.problem.solving.leetcode.problems.definitions.TreeNode;

public class sortedArrayToBST {

    public void showInOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        showInOrder(root.left);
        System.out.print(root.val + " ");
        showInOrder(root.right);
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        }

        else {
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {

        if (nums == null || nums.length == 0) {
            return null;
        }

        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }

        int treeIndex = (nums.length - 1) / 2;
        TreeNode root = new TreeNode(nums[treeIndex]);

        for (int i = 0; i <= nums.length; i++) {
            if (i != treeIndex) {
                insertIntoBST(root, nums[i]);
            }
        }

        return root;
    }

    public static void main(String[] args) {
        sortedArrayToBST sortedArrayToBST = new sortedArrayToBST();

        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);

        root.left = left;
        root.right = right;

        root.right.right = new TreeNode(15);
        root.right.left = new TreeNode(7);

        sortedArrayToBST.showInOrder(root);
    }

}
