package LL;

public class FlatteningLL {

  static class Node {
    int data;
    Node right, down;
    Node(int data) {
      this.data = data;
      right = down = null;
    }
  }

  static Node merge(Node a, Node b) {
    if (a == null) return b;
    if (b == null) return a;

    Node result;
    if (a.data < b.data) {
      result = a;
      result.down = merge(a.down, b);
    } else {
      result = b;
      result.down = merge(a, b.down);
    }
    return result;
  }

  static Node flatten(Node root) {
    if (root == null || root.right == null) {
      return root;
    }
    root.right = flatten(root.right);
    root = merge(root, root.right);
    return root;
  }

  static void printList(Node head)
  {
    Node temp = head;
    while (temp != null)
    {
      System.out.print(temp.data + " ");
      temp = temp.down;
    }
    System.out.println();
  }

  public static void main(String args[]) {
    Node head = new Node(5);
    head.right = new Node(10);
    head.right.right = new Node(19);
    head.right.right.right = new Node(28);

    head.down = new Node(7);
    head.down.down = new Node(8);
    head.down.down.down = new Node(30);

    head.right.down = new Node(20);

    head.right.right.down = new Node(22);
    head.right.right.down.down = new Node(50);

    head.right.right.right.down = new Node(35);
    head.right.right.right.down.down = new Node(40);
    head.right.right.right.down.down.down = new Node(45);

    flatten(head);
    printList(head);
  }
}
