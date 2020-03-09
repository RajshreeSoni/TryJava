package BST;

import BT.BinaryTreeNode;

public class IsBST {

  public static void main(String args[]) {
    BinaryTreeNode root = new BinaryTreeNode(4);
    root.left = new BinaryTreeNode(2);
    root.right = new BinaryTreeNode(5);
    root.left.left = new BinaryTreeNode(1);
    root.left.right = new BinaryTreeNode(3);

    if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
      System.out.println("IS BST");
    } else {
      System.out.println("Not a BST");
    }
  }

  static boolean isBST(BinaryTreeNode root, int min, int max) {
    if (root == null) {
      return true;
    }
    if (root.data < min || root.data > max) {
      return false;
    }

    return isBST(root.left, min, root.data-1)
        && isBST(root.right, root.data+1, max);
  }
}
