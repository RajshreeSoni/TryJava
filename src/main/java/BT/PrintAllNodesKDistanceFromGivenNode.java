package BT;

public class PrintAllNodesKDistanceFromGivenNode {

  static void printKDistanceNodeDown(BinaryTreeNode root, int k) {
    if (root == null || k <0) {
      return;
    }

    if (k==0) {
      System.out.print(root.data+" ");
      return;
    }

    printKDistanceNodeDown(root.left, k-1);
    printKDistanceNodeDown(root.right, k-1);
  }

  static int printKDistanceNode(BinaryTreeNode root, BinaryTreeNode target, int k) {
    if (root == null) {
      return -1;
    }

    if (root == target) {
      printKDistanceNodeDown(root, k);
      return 0;
    }

    int dl = printKDistanceNode(root.left, target, k);

    if (dl != -1) {
      if(dl+1 == k) {
        System.out.print(root.data+" ");
      } else {
        printKDistanceNodeDown(root.right, k-dl-2);
      }
      return 1 + dl;
    }
    int dr = printKDistanceNode(root.right, target,k);

    if (dr != -1) {
      if (dr+1 == k) {
        System.out.print(root.data+" ");
      } else {
        printKDistanceNodeDown(root.left, k-dr-2);
      }
      return 1+dr;
    }
    return -1;
  }

  public static void main(String args[]) {
    BinaryTreeNode root = new BinaryTreeNode(20);
    root.left = new BinaryTreeNode(8);
    root.right = new BinaryTreeNode(22);
    root.left.left = new BinaryTreeNode(4);
    root.left.right = new BinaryTreeNode(12);
    root.left.right.left = new BinaryTreeNode(10);
    root.left.right.right = new BinaryTreeNode(14);
    BinaryTreeNode target = root.left.right;
    printKDistanceNode(root, target, 2);
  }
}
