package com.problem.solving.leetcode;

import com.problem.solving.leetcode.definitions.TreeNode;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class SameTreeBfs {

  public boolean isSameTree(TreeNode p, TreeNode q) {

    boolean isTheSameTree = true;

    if (Objects.isNull(p) && Objects.isNull(q)) {
      return true;
    }

    if (Objects.isNull(p) || Objects.isNull(q)) {
      return false;
    }

    Queue<TreeNode> pendingNodes = new LinkedList<>();
    pendingNodes.add(p);
    pendingNodes.add(q);

    while (!pendingNodes.isEmpty()) {

      TreeNode currentNodeP = pendingNodes.poll();
      TreeNode currentNodeQ = pendingNodes.poll();

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

      pendingNodes.add(currentNodeP.left);
      pendingNodes.add(currentNodeQ.left);
      pendingNodes.add(currentNodeP.right);
      pendingNodes.add(currentNodeQ.right);
    }

    return isTheSameTree;
  }
}
