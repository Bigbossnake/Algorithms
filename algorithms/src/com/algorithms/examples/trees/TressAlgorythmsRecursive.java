package com.algorithms.examples.trees;

import com.algorithms.examples.trees.definitions.TreeNodeDef;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TressAlgorythmsRecursive {

  public static void breadthFirstSearch(Queue<TreeNodeDef> queue) {

    if (queue.isEmpty()) {
      return;
    }

    TreeNodeDef node = queue.poll();

    System.out.print(node.val + " , ");

    if (node.right != null) {
      queue.offer(node.right);
    }

    if (node.left != null) {
      queue.offer(node.left);
    }

    breadthFirstSearch(queue);
  }

  public static void depthFirstSearch(Stack<TreeNodeDef> stack) {

    if (stack.isEmpty()) {
      return;
    }

    TreeNodeDef node = stack.pop();

    System.out.print(node.val + " , ");

    if (node.right != null) {
      stack.push(node.right);
    }

    if (node.left != null) {
      stack.push(node.left);
    }

    depthFirstSearch(stack);
  }

  public static void main(String[] args) {
    TressAlgorythmsRecursive tressAlgorythmsIterative = new TressAlgorythmsRecursive();

    TreeNodeDef root = new TreeNodeDef(10);
    TreeNodeDef left = new TreeNodeDef(9);
    TreeNodeDef right = new TreeNodeDef(20);

    root.left = left;
    root.right = right;

    root.right.right = new TreeNodeDef(21);
    root.right.left = new TreeNodeDef(17);

    root.left.right = new TreeNodeDef(8);
    root.left.left  = new TreeNodeDef(7);

    System.out.println("#########################################");
    System.out.println("#             BFSTRANSVERSAL            #");
    System.out.println("#########################################");
    Queue<TreeNodeDef> queue = new LinkedList<>();
    queue.add(root);
    tressAlgorythmsIterative.breadthFirstSearch(queue);

    System.out.println();
    System.out.println("#########################################");
    System.out.println("#            DFS TRANSVERSAL            #");
    System.out.println("#########################################");
    Stack<TreeNodeDef> stack = new Stack<>();
    stack.add(root);
    tressAlgorythmsIterative.depthFirstSearch(stack);
  }
}
