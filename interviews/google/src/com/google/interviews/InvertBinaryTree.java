package com.google.interviews;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class InvertBinaryTree {

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

    public TreeNode invertTree(TreeNode root) {

        Queue<TreeNode> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);

        if (!Optional.ofNullable(root).isPresent()) {
            return root;
        }

        while (!pendingNodes.isEmpty()) {

            TreeNode currentNode   = pendingNodes.poll();
            TreeNode nodeValueTemp = currentNode.left;

            currentNode.left  = currentNode.right;
            currentNode.right = nodeValueTemp;

            if (Optional.ofNullable(currentNode.left).isPresent()) {
                pendingNodes.add(currentNode.left);
            }

            if (Optional.ofNullable(currentNode.right).isPresent()) {
                pendingNodes.add(currentNode.right);
            }
        }

        return root;
    }

}
