package com.problem.solving.leetcode.problems.trees;

import com.problem.solving.leetcode.definitions.TreeNode;

import java.util.Objects;
import java.util.Stack;

public class SameTreeDfs {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        boolean isTheSameTree = true;

        if (Objects.isNull(p) && Objects.isNull(q)) {
            return true;
        }

        if (Objects.isNull(p) || Objects.isNull(q)) {
            return false;
        }

        Stack<TreeNode> pendingNodes = new Stack<>();
        pendingNodes.push(p);
        pendingNodes.push(q);

        while (!pendingNodes.isEmpty()) {

            TreeNode currentNodeP = pendingNodes.pop();
            TreeNode currentNodeQ = pendingNodes.pop();

            if (currentNodeP == null && currentNodeQ != null) {
                isTheSameTree = false;
                break;
            }

            if (currentNodeP != null && currentNodeQ == null) {
                isTheSameTree = false;
                break;
            }

            if (currentNodeP == null && currentNodeQ == null) {
                continue;
            }

            if (currentNodeP.val != currentNodeQ.val) {
                isTheSameTree = false;
                break;
            }

            pendingNodes.push(currentNodeP.left);
            pendingNodes.push(currentNodeQ.left);
            pendingNodes.push(currentNodeP.right);
            pendingNodes.push(currentNodeQ.right);
        }

        return isTheSameTree;
    }
}
