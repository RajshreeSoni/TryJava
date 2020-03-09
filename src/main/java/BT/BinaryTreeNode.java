package BT;

public class BinaryTreeNode {

  public int data;
  public BinaryTreeNode left, right;

  public BinaryTreeNode(int data) {
    this.data = data;
    left = right = null;
  }

  public static void printTreeInPreorder(BinaryTreeNode root){
    if (root!= null) {
      System.out.print(root.data+" ");
      printTreeInPreorder(root.left);
      printTreeInPreorder(root.right);
    }
  }
}
