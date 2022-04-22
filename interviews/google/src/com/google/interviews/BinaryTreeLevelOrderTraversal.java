package com.google.interviews;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

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

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> levelsValues = new ArrayList<>();

        if (root == null) {
            return levelsValues;
        }

        int level = 0;
        Queue<TreeNode> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);

        while (!pendingNodes.isEmpty() ) {
            levelsValues.add(new ArrayList<>());
            int levelSize = pendingNodes.size();

            for(int i = 0; i < levelSize; ++i) {
                TreeNode node = pendingNodes.remove();
                levelsValues.get(level).add(node.val);

                if (node.left != null) {
                    pendingNodes.add(node.left);
                }

                if (node.right != null) {
                    pendingNodes.add(node.right);
                }
            }

            level++;
        }

        return levelsValues;
    }

}
