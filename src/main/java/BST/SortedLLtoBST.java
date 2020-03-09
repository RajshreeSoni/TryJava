package BST;

import BT.BinaryTreeNode;
import LL.LinkedListNode;

public class SortedLLtoBST {

  static LinkedListNode head;
  static BinaryTreeNode sortedListToBST() {
    int n = countNodes(head);
    return sortedListToBSTRecur(n);
  }

  static int countNodes(LinkedListNode head) {
    LinkedListNode temp = head;
    int count = 0;
    while(temp!=null) {
      count++;
      temp=temp.next;
    }
    return count;
  }

  static BinaryTreeNode sortedListToBSTRecur(int n) {
    if (n <= 0) {
      return null;
    }

    BinaryTreeNode left = sortedListToBSTRecur(n/2);
    BinaryTreeNode root = new BinaryTreeNode(head.data);
    root.left = left;
    head = head.next;
    root.right = sortedListToBSTRecur(n-n/2-1);
    return root;
  }

  public static void main(String args[]) {
    head = new LinkedListNode(1);
    head.next = new LinkedListNode(2);
    head.next.next = new LinkedListNode(3);
    head.next.next.next = new LinkedListNode(4);
    head.next.next.next.next = new LinkedListNode(5);
    head.next.next.next.next.next = new LinkedListNode(6);
    head.next.next.next.next.next.next = new LinkedListNode(7);

    LinkedListNode.printList(head);

    BinaryTreeNode root = sortedListToBST();
    BinaryTreeNode.printTreeInPreorder(root);
  }
}
