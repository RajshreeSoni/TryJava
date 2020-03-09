package BT;

public class PrintAncestorsOfANodeInBT {

  public static void main(String args[]) {
    BinaryTreeNode root = new BinaryTreeNode(1);
    root.left = new BinaryTreeNode(2);
    root.right = new BinaryTreeNode(3);
    root.left.left = new BinaryTreeNode(4);
    root.left.right = new BinaryTreeNode(5);
    root.left.left.left = new BinaryTreeNode(7);

    printAncestors(root, 7);
  }

  static boolean printAncestors(BinaryTreeNode root, int target){
    if (root == null) {
      return false;
    }
    if (root.data == target) {
      //System.out.print(root.data+ " ");
      return true;
    }

    if (printAncestors(root.left, target) || printAncestors(root.right, target)) {
      System.out.print(root.data+" ");
      return true;
    }

    return false;
  }
}
