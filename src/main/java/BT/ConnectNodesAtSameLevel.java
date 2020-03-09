package BT;

public class ConnectNodesAtSameLevel {

  static class Node {
    int data;
    Node left, right, nextRight;
    Node (int data) {
      this.data = data;
      left=right=nextRight=null;
    }
  }

  static void connectRecur(Node p) {
    if (p == null)
      return;

    if (p.left != null) {
      if (p.right != null) {
        p.left.nextRight = p.right;
      } else {
        p.left.nextRight = getNextRight(p);
      }
    }

    if (p.right != null) {
     if (p.nextRight != null && p.nextRight.left != null) {
       p.right.nextRight = p.nextRight.left;
     } else if (p.nextRight != null && p.nextRight.right != null) {
       p.right.nextRight = p.nextRight.right;
     }
     else {
       p.right.nextRight = null;
     }
    }

    connectRecur(p.left);
    connectRecur(p.right);
  }

  static Node getNextRight(Node p) {
    Node temp = p.nextRight;
    while (temp != null){
      if (temp.left != null)
        return temp.left;
      if (temp.right != null)
        return temp.right;
    }

    return null;
  }

  public static void main(String args[])
  {

    Node root = new Node(10);
    root.left = new Node(8);
    root.right = new Node(2);
    root.left.left = new Node(3);
    root.right.right = new Node(9);

    // Populates nextRight pointer in all nodes
    connectRecur(root);

    // Let us check the values of nextRight pointers
    int a = root.nextRight != null ?
        root.nextRight.data : -1;
    int b = root.left.nextRight != null ?
        root.left.nextRight.data : -1;
    int c = root.right.nextRight != null ?
        root.right.nextRight.data : -1;
    int d = root.left.left.nextRight != null ?
        root.left.left.nextRight.data : -1;
    int e = root.right.right.nextRight != null ?
        root.right.right.nextRight.data : -1;

    // Now lets print the values
    System.out.println("Following are populated nextRight pointers in "
        + " the tree(-1 is printed if there is no nextRight)");
    System.out.println("nextRight of " + root.data + " is " + a);
    System.out.println("nextRight of " + root.left.data + " is " + b);
    System.out.println("nextRight of " + root.right.data + " is " + c);
    System.out.println("nextRight of " + root.left.left.data +
        " is " + d);
    System.out.println("nextRight of " + root.right.right.data +
        " is " + e);
  }

}
