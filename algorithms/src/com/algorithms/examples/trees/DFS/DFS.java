package com.algorithms.examples.trees.DFS;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.*;

public class DFS {

  private static String SPACE = " ";

  private static void cleanPath(
      Hashtable<String, String> graph,
      Hashtable<String, Boolean> visitedNodes,
      Stack<String> pendingNodes,
      Stack<String> path) {

    boolean nodeHasNeighbors = true;
    int stackCounter = 0;
    boolean readOnly = true;

    while (stackCounter < path.size()) {

      String currentNode = path.pop();
      boolean isVisited =
          finAdditionalNeighbors(graph, visitedNodes, pendingNodes, currentNode, readOnly);

      if (!isVisited) {
        path.push(currentNode);
        break;
      }

      stackCounter++;
    }
  }

  private static boolean finAdditionalNeighbors(
      Hashtable<String, String> graph,
      Hashtable<String, Boolean> visitedNodes,
      Stack<String> pendingNodes,
      String currentNode,
      boolean readOnly) {

    AtomicBoolean endOfTheRoad = new AtomicBoolean(true);
    String neighborsInfo = graph.get(currentNode);

    if (neighborsInfo != null) {

      String[] neighbors = neighborsInfo.split(SPACE);

      Arrays.stream(neighbors)
          .forEach(
              neighbor -> {
                if (!visitedNodes.containsKey(neighbor)) {

                  if (!readOnly) {
                    pendingNodes.push(neighbor);
                  }

                  endOfTheRoad.set(false);
                }
              });
    }

    return endOfTheRoad.get();
  }

  private static void DFS(Hashtable<String, String> graph, String fromNode, String toNode) {

    Hashtable<String, Boolean> visitedNodes = new Hashtable<String, Boolean>();
    Stack<String> pendingNodes = new Stack<String>();
    Stack<String> path = new Stack<String>();

    pendingNodes.push(fromNode);

    while (!pendingNodes.empty()) {

      String currentNode = pendingNodes.pop();

      if (!visitedNodes.containsKey(currentNode)) {
        visitedNodes.put(currentNode, true);
        path.push(currentNode);

        if (currentNode.equalsIgnoreCase(toNode)) {
          break;
        }
      }

      boolean readOnly = false;
      boolean endOfTheRoad =
          finAdditionalNeighbors(graph, visitedNodes, pendingNodes, currentNode, readOnly);

      if (endOfTheRoad) {
        cleanPath(graph, visitedNodes, pendingNodes, path);
      }
    }

    List<String> result = new ArrayList<String>(path);

    result.forEach(node -> System.out.print(node));
  }

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    String graphDetails = input.nextLine();
    String problemDeatils = input.nextLine();

    String[] graphInfo = graphDetails.split(SPACE);
    int numberOfNodes = Integer.parseInt(graphInfo[0]);
    int numberOfEdges = Integer.parseInt(graphInfo[1]);

    String[] problemInfo = problemDeatils.split(SPACE);
    String fromNode = problemInfo[0];
    String toNode = problemInfo[1];

    Hashtable<String, String> graph = new Hashtable<String, String>();
    String neighbors;

    for (int i = 0; i < numberOfEdges; i++) {

      String nodeInfo = input.nextLine();
      String[] nodeDetails = nodeInfo.split(SPACE);

      String node = nodeDetails[0];
      String neighbor = nodeDetails[1];

      if (!graph.containsKey(node)) {
        graph.put(node, neighbor);
      } else {
        neighbors = graph.get(node);
        neighbors = neighbors + SPACE + neighbor;
        graph.replace(node, neighbors);
      }

      if (!graph.containsKey(neighbor)) {
        graph.put(neighbor, node);
      } else {
        neighbors = graph.get(neighbor);
        neighbors = neighbors + SPACE + node;
        graph.replace(neighbor, neighbors);
      }
    }

    DFS(graph, fromNode, toNode);
  }
}
