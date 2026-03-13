package company.microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MS365_Q1 {

  public static List<Integer> countReverseEdges(int gNodes, List<Integer> gFrom, List<Integer> gTo) {
    int nodeCount = gNodes;
    int edgeCount = gFrom.size();
    if (nodeCount <= 1) return Collections.singletonList(0);

    /*
     * We treat the graph as an undirected tree, but keep the original direction as a "cost":
     * If the original edge is a -> b:
     *   - traveling a -> b costs 0 reversals
     *   - traveling b -> a costs 1 reversal (we would need to flip the edge)
     */
    int[] firstEdgeIndexByNode = new int[nodeCount + 1];
    Arrays.fill(firstEdgeIndexByNode, -1);

    int[] neighborNode = new int[2 * edgeCount];
    int[] nextEdgeIndex = new int[2 * edgeCount];
    byte[] reversalCost = new byte[2 * edgeCount]; // 0 or 1
    int edgeIndex = 0;

    for (int i = 0; i < edgeCount; i++) {
      int fromNode = gFrom.get(i);
      int toNode = gTo.get(i);

      // Direction: fromNode -> toNode (no reversal needed if we go this way)
      neighborNode[edgeIndex] = toNode;
      reversalCost[edgeIndex] = 0;
      nextEdgeIndex[edgeIndex] = firstEdgeIndexByNode[fromNode];
      firstEdgeIndexByNode[fromNode] = edgeIndex;
      edgeIndex++;

      // Reverse direction: toNode -> fromNode (would require reversing the original edge)
      neighborNode[edgeIndex] = fromNode;
      reversalCost[edgeIndex] = 1;
      nextEdgeIndex[edgeIndex] = firstEdgeIndexByNode[toNode];
      firstEdgeIndexByNode[toNode] = edgeIndex;
      edgeIndex++;
    }

    int[] parentNode = new int[nodeCount + 1];
    int[] reversalsNeededFromRoot = new int[nodeCount + 1];

    // -----------------------------
    // Pass 1: pick node 1 as root, count reversals needed so all edges point away from 1
    // -----------------------------
    int reversalsForNode1 = 0;
    int[] dfsStack = new int[nodeCount];
    int stackSize = 0;

    parentNode[1] = 0;
    dfsStack[stackSize++] = 1;

    while (stackSize > 0) {
      int currentNode = dfsStack[--stackSize];

      for (int currentEdge = firstEdgeIndexByNode[currentNode];
           currentEdge != -1;
           currentEdge = nextEdgeIndex[currentEdge]) {

        int nextNode = neighborNode[currentEdge];
        if (nextNode == parentNode[currentNode]) continue;

        parentNode[nextNode] = currentNode;

        // If this edge goes "toward" the root (cost=1 in this traversal direction),
        // we must reverse it when root is 1.
        reversalsForNode1 += reversalCost[currentEdge];
        dfsStack[stackSize++] = nextNode;
      }
    }

    reversalsNeededFromRoot[1] = reversalsForNode1;

    // -----------------------------
    // Pass 2: re-root DP
    // If we move the root across an edge, the answer changes by +/- 1 depending on direction:
    // - original direction currentNode -> nextNode  (cost 0): becomes wrong for nextNode as root => +1
    // - original direction nextNode -> currentNode  (cost 1): becomes right for nextNode as root  => -1
    // -----------------------------
    stackSize = 0;
    dfsStack[stackSize++] = 1;

    while (stackSize > 0) {
      int currentNode = dfsStack[--stackSize];

      for (int currentEdge = firstEdgeIndexByNode[currentNode];
           currentEdge != -1;
           currentEdge = nextEdgeIndex[currentEdge]) {

        int nextNode = neighborNode[currentEdge];
        if (nextNode == parentNode[currentNode]) continue;

        int delta = (reversalCost[currentEdge] == 0) ? 1 : -1;
        reversalsNeededFromRoot[nextNode] = reversalsNeededFromRoot[currentNode] + delta;

        dfsStack[stackSize++] = nextNode;
      }
    }

    // Build result for nodes 1..n
    List<Integer> result = new ArrayList<>(nodeCount);
    for (int node = 1; node <= nodeCount; node++) {
      result.add(reversalsNeededFromRoot[node]);
    }
    return result;
  }

  public static void main(String[] args) {
    MS365_Q1 question = new MS365_Q1();
  }
}
