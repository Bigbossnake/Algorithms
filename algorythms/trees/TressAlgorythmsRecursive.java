import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TressAlgorythmsRecursive {

  public static void breadthFirstSearch(Queue queue) {

    if (queue.isEmpty()) {
      return;
    }

    Node node = (Node) queue.poll();

    System.out.println(node + " ");

    if (node.right != null) {
      queue.offer(node.right);
    }

    if (node.left != null) {
      queue.offer(node.left);
    }

    breadthFirstSearch(queue);
  }

  public static void depthFirstSearch(Stack stack) {

    if (stack.isEmpty()) {
      return;
    }

    Node node = (Node) stack.pop();

    System.out.println(node + " ");

    if (node.right != null) {
      stack.push(node.right);
    }

    if (node.left != null) {
      stack.push(node.left);
    }

    depthFirstSearch(stack);
  }
}
