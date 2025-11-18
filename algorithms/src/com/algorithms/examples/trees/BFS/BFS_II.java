package com.algorithms.examples.trees.BFS;

import com.algorithms.examples.trees.TreeNodeDef;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class BFS_II {

  public boolean isSameTree(TreeNodeDef p, TreeNodeDef q) {

    boolean isTheSameTree = true;

    if (Objects.isNull(p) && Objects.isNull(q)) {
      return true;
    }

    if (Objects.isNull(p) || Objects.isNull(q)) {
      return false;
    }

    Queue<TreeNodeDef> pendingNodes = new LinkedList<>();
    pendingNodes.add(p);
    pendingNodes.add(q);

    while (!pendingNodes.isEmpty()) {

      TreeNodeDef currentNodeP = pendingNodes.poll();
      TreeNodeDef currentNodeQ = pendingNodes.poll();

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
