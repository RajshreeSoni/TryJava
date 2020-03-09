package BST;

import BST.SuccessorOfBST.Node;
import java.util.Stack;

public class KthSmallestElementInBST {

  static Node kSmallestNode(Node root, int k) {
    Stack<Node> st = new Stack<Node>();
    if (root == null) {
      return null;
    }
    Node current = root;
    int count = 0;
    while (current != null || st.size() > 0) {
      while (current != null) {
        st.push(current);
        current = current.left;
      }
      current = st.pop();
      count++;
      if (count == k) {
        return current;
      }
      current = current.right;
    }
    return null;
  }

  public static void main(String args[]) {
    Node root = new Node(50);
    SuccessorOfBST.insert(root, 30);
    SuccessorOfBST.insert(root, 20);
    SuccessorOfBST.insert(root, 40);
    SuccessorOfBST.insert(root, 70);
    SuccessorOfBST.insert(root, 60);
    SuccessorOfBST.insert(root, 80);

    System.out.print(kSmallestNode(root, 3).data);
  }
}
