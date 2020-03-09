package BT;

import java.util.Stack;

public class InorderTraversalWithoutRecursion {

  public static void main(String args[]) {
    BinaryTreeNode root = new BinaryTreeNode(1);
    root.left = new BinaryTreeNode(2);
    root.right = new BinaryTreeNode(3);
    root.left.left = new BinaryTreeNode(4);
    root.left.right = new BinaryTreeNode(5);

    inorderTraversal(root);
  }

  private static void inorderTraversal(BinaryTreeNode root) {
    if (root == null) {
      return;
    }

    Stack<BinaryTreeNode> st = new Stack<BinaryTreeNode>();
    BinaryTreeNode current = root;
    while (current != null || st.size() > 0) {
      while (current!= null) {
        st.push(current);
        current = current.left;
      }
      current = st.pop();
      System.out.print(current.data+" ");
      current = current.right;
    }
  }
}
