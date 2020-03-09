package BT;

public class DiameterOfBT {

  static class Height {
    int h;
  }

  public static void main(String args[]) {
    BinaryTreeNode root = new BinaryTreeNode(1);
    root.left = new BinaryTreeNode(2);
    root.right = new BinaryTreeNode(3);
    root.left.left = new BinaryTreeNode(4);
    root.left.right = new BinaryTreeNode(5);
    Height height = new Height();
    System.out.println("The diameter of given binary tree is : "+ getDiameter(root, height));
  }

  static int getDiameter(BinaryTreeNode root, Height height) {
    Height lh = new Height();
    Height rh = new Height();
    if (root == null) {
      height.h = 0;
      return 0;
    }

    int ldiameter = getDiameter(root.left, lh);
    int rdiameter = getDiameter(root.right, rh);

    height.h = Math.max(lh.h, rh.h) + 1;
    return Math.max(lh.h + rh.h + 1, Math.max(ldiameter, rdiameter));
  }
}
