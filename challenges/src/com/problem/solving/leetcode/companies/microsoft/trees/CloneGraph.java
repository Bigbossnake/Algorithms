package com.problem.solving.leetcode.companies.microsoft.trees;

import com.problem.solving.leetcode.companies.definitions.Tree.Node;

import java.util.ArrayList;
import java.util.HashMap;

public class CloneGraph {

  private final HashMap<Node, Node> visited = new HashMap<>();

  public Node cloneGraph(Node node) {

    if (node == null) {
      return node;
    }

    if (visited.containsKey(node)) {
      return visited.get(node);
    }

    Node cloneNode = new Node(node.val, new ArrayList());
    visited.put(node, cloneNode);

    for (Node neighbor : node.neighbors) {
      cloneNode.neighbors.add(cloneGraph(neighbor));
    }

    return cloneNode;
  }

}
