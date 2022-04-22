package com.google.interviews;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {
    private static final boolean IS_VALID = true;
    private final List<Integer> binaryTreeList  = new ArrayList<>();

    // Definition for a binary tree node.
    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private void toArrayList(TreeNode root) {

        if (root == null) {
            return;
        }

        toArrayList(root.left);
        binaryTreeList.add(root.val);
        toArrayList(root.right);

    }

    public boolean isValidBST(TreeNode root) {

        toArrayList(root);

        for (int i = 0; i < binaryTreeList.size(); i++) {

            if (i + 1 < binaryTreeList.size()) {
                int current = binaryTreeList.get(i);
                int next = binaryTreeList.get(i + 1);

                if (current >= next) {
                    return !IS_VALID;
                }
            }

        }

        return IS_VALID;
    }

    public static void main(String args[]) {
        ValidateBinarySearchTree treeValidator = new ValidateBinarySearchTree();

        TreeNode root      = new TreeNode(2);
        TreeNode leftNode  = new TreeNode(1);
        TreeNode rightNode = new TreeNode(3);

        root.left  = leftNode;
        root.right = rightNode;

        System.out.println(treeValidator.isValidBST(root));
    }

}
