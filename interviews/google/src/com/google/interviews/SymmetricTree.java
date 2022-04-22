package com.google.interviews;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

    private static final boolean IS_SIMETRIC   = true;

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

    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);
        pendingNodes.add(root);

        while (!pendingNodes.isEmpty()) {
            TreeNode leftNode  = pendingNodes.poll();
            TreeNode rightNode = pendingNodes.poll();

            if (leftNode == null && rightNode == null)  {
                continue;
            }

            if (leftNode == null || rightNode == null) {
                return !IS_SIMETRIC;
            }

            if (leftNode.val != rightNode.val) {
                return !IS_SIMETRIC;
            }

            pendingNodes.add(leftNode.left);
            pendingNodes.add(rightNode.right);
            pendingNodes.add(leftNode.right);
            pendingNodes.add(rightNode.left);
        }

        return IS_SIMETRIC;
    }

}
