import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TressAlgorythmsIterative {

  public void BFS(TreeNode root) {
    Queue<TreeNode> pendingNodes = new LinkedList<>();
    pendingNodes.add(root);

    while (!pendingNodes.isEmpty()) {

      TreeNode currentNode = pendingNodes.poll();

      if (currentNode != null) {
        System.out.print(currentNode.val + " , ");
      }

      if (currentNode != null && currentNode.left != null) {
        pendingNodes.add(currentNode.left);
      }

      if (currentNode != null && currentNode.right != null) {
        pendingNodes.add(currentNode.right);
      }
    }
  }

  public void DFS(TreeNode root) {
    Stack<TreeNode> pendingNodes = new Stack<>();
    pendingNodes.push(root);

    while (!pendingNodes.isEmpty()) {
      TreeNode currentNode = pendingNodes.pop();

      if (currentNode != null) {
        System.out.println(currentNode.val);
      }

      if (currentNode != null && currentNode.left != null) {
        pendingNodes.push(currentNode.left);
      }

      if (currentNode != null && currentNode.right != null) {
        pendingNodes.push(currentNode.right);
      }
    }
  }

}
