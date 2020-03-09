package BT;

public class LeftViewOfBT {

  static int max_level = 0;

  public static void main(String args[]) {
    BinaryTreeNode root = new BinaryTreeNode(12);
    root.left = new BinaryTreeNode(10);
    root.right = new BinaryTreeNode(30);
    root.right.left = new BinaryTreeNode(25);
    root.right.right = new BinaryTreeNode(40);
    leftView(root, 1);
  }

  static void leftView(BinaryTreeNode root, int level) {
    if (root == null)
      return;
    if (max_level < level) {
      System.out.print(" " + root.data);
      max_level = level;
    }

    leftView(root.left, level+1);
    leftView(root.right, level+1);
  }
}
