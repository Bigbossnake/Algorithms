package com.algorithms.examples.trees.DFS;

import com.algorithms.examples.trees.definitions.TreeNodeDef;

import java.util.Objects;
import java.util.Stack;

public class DFS_II {

  public boolean isSameTree(TreeNodeDef p, TreeNodeDef q) {

    boolean isTheSameTree = true;

    if (Objects.isNull(p) && Objects.isNull(q)) {
      return true;
    }

    if (Objects.isNull(p) || Objects.isNull(q)) {
      return false;
    }

    Stack<TreeNodeDef> pendingNodes = new Stack<>();
    pendingNodes.push(p);
    pendingNodes.push(q);

    while (!pendingNodes.isEmpty()) {

      TreeNodeDef currentNodeP = pendingNodes.pop();
      TreeNodeDef currentNodeQ = pendingNodes.pop();

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
