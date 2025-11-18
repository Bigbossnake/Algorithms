import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DFS_III {
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
