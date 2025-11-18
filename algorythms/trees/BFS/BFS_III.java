import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS_III {

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
}
