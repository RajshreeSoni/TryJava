package BT;

public class MorrisTraversalOfBT {

  static void MorrisTraversal(BinaryTreeNode root) {
    BinaryTreeNode current, pre;

    if (root == null) {
      return;
    }

    current = root;
    while (current != null) {
      if (current.left == null) {
        System.out.print(current.data+" ");
        current = current.right;
      }
      else {
        pre = current.left;
        while (pre.right != null && pre.right != current) {
          pre = pre.right;
        }
        if (pre.right == null){
          pre.right = current;
          current = current.left;
        }
        else {
          pre.right = null;
          System.out.print(current.data+" ");
          current = current.right;
        }
      }
    }
  }

  public static void main(String args[]) {
    BinaryTreeNode root = new BinaryTreeNode(1);
    root.left = new BinaryTreeNode(2);
    root.right = new BinaryTreeNode(3);
    root.left.left = new BinaryTreeNode(4);
    root.left.right = new BinaryTreeNode(5);
    MorrisTraversal(root);
  }
}
