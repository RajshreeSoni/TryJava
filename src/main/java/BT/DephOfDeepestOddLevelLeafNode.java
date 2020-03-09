package BT;

public class DephOfDeepestOddLevelLeafNode {

  public static void main(String args[]) {
     BinaryTreeNode root = new BinaryTreeNode(1);
     root.left = new BinaryTreeNode(2);
     root.right = new BinaryTreeNode(3);
     root.left.left = new BinaryTreeNode(4);
     root.right.left = new BinaryTreeNode(5);
     root.right.right = new BinaryTreeNode(6);
     root.right.left.right = new BinaryTreeNode(7);
     root.right.right.right = new BinaryTreeNode(8);
     root.right.left.right.left = new BinaryTreeNode(9);
     root.right.right.right.right = new BinaryTreeNode(10);
     root.right.right.right.right.right = new BinaryTreeNode(11);

     System.out.println(depthOfOddLeaf(root, 1));
  }

  private static int depthOfOddLeaf(final BinaryTreeNode root, int level) {
    if (root == null)
      return 0;
    if (root.left == null && root.right == null && (level & 1) != 0) {
      return level;
    }
    return Math.max(depthOfOddLeaf(root.left, level+1),
        depthOfOddLeaf(root.right, level+1));
  }
}
