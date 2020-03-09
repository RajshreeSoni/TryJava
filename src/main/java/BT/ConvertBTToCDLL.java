package BT;

import LL.LinkedListNode;

public class ConvertBTToCDLL {

  public static void main(String args[]) {
    BinaryTreeNode root = new BinaryTreeNode(10);
    root.left = new BinaryTreeNode(12);
    root.right = new BinaryTreeNode(15);
    root.left.left = new BinaryTreeNode(25);
    root.left.right = new BinaryTreeNode(30);
    root.right.left = new BinaryTreeNode(36);

    BinaryTreeNode head = bTreeToCDoublyList(root);
    printLL(head);
  }

  static BinaryTreeNode concatenate(BinaryTreeNode leftList, BinaryTreeNode rightList) {
    if (leftList == null) {
      return rightList;
    }
    if (rightList == null) {
      return leftList;
    }

    BinaryTreeNode leftLast = leftList.left;
    BinaryTreeNode rightLast = rightList.left;

    leftLast.right = rightList;
    rightList.left = leftLast;

    rightLast.right = leftList;
    leftList.left = rightLast;

    return leftList;
  }

  static BinaryTreeNode bTreeToCDoublyList(BinaryTreeNode root) {
    if (root == null) {
      return null;
    }

    BinaryTreeNode left = bTreeToCDoublyList(root.left);
    BinaryTreeNode right = bTreeToCDoublyList(root.right);
    root.left = root.right = root;
    return concatenate(concatenate(left, root), right);
  }

  static void printLL(BinaryTreeNode head) {
    BinaryTreeNode temp = head;
    while (temp.right != head) {
      System.out.print(temp.data + "->");
      temp = temp.right;
    }
    System.out.print(temp.data);
  }
}
