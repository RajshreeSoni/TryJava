package BT;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLevelOrderTree {

  public static void main(String args[]) {
    BinaryTreeNode root = new BinaryTreeNode(1);
    root.left = new BinaryTreeNode(2);
    root.right = new BinaryTreeNode(3);
    root.left.left = new BinaryTreeNode(4);
    root.left.right = new BinaryTreeNode(5);
    root.right.left = new BinaryTreeNode(6);
    root.right.right = new BinaryTreeNode(7);

    levelOrderTraversalInReverseOrder(root);
  }

  private static void levelOrderTraversalInReverseOrder(final BinaryTreeNode root) {
    Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
    Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
    if (root == null) {
      return;
    }
    queue.add(root);
    while (!queue.isEmpty()) {
      BinaryTreeNode temp = queue.poll();
      if (temp.right != null) {
        queue.add(temp.right);
      }
      if (temp.left != null) {
        queue.add(temp.left);
      }
      stack.push(temp);
    }
    while (!stack.isEmpty()) {
      System.out.print(stack.pop().data + " -> ");
    }
  }
}
