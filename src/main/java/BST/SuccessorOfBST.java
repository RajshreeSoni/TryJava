package BST;


public class SuccessorOfBST {

  static class Node {
    int data;
    Node left, right, parent;
    Node(int data) {
      this.data = data;
      left=right=parent =null;
    }
  }
  public static Node insert(Node node, int data) {
    if (node == null) {
      node = new Node(data);
      return node;
    }

    if (data < node.data) {
      node.left = insert(node.left, data);
    } else {
      node.right = insert(node.right, data);
    }
    return node;
  }

  public static Node deleteRec(Node root, int key) {
    if (root == null) return null;

    if (key<root.data) {
      root.left = deleteRec(root.left, key);
    } else if (key > root.data) {
      root.right = deleteRec(root.right, key);
    } else {
      if (root.left == null) {
        return root.right;
      } else if (root.right == null){
        return root.left;
      } root.data = minValue(root.right);
      root.right = deleteRec(root.right, root.data);
    }
    return root;
  }

  public static int minValue(Node root) {
    if (root == null) return 0;
    int minv = root.data;
    while (root.left != null) {
      minv = root.left.data;
      root = root.left;
    }
    return minv;
  }

  public static void inorderRec(Node root){
    if (root!= null) {
      inorderRec(root.left);
      System.out.print(root.data+"  ");
      inorderRec(root.right);
    }
  }

  public static void main(String args[]) {
    Node root = new Node(50);

    insert(insert(root,30),20);
    insert(root,40);
    insert(root,70);
    insert(root,60);
    insert(root,80);

    System.out.println("Inorder traversal of the given tree");
    inorderRec(root);
    System.out.println("\nDelete 20");
    deleteRec(root, 20);
    System.out.println("Inorder traversal of the modified tree");
    inorderRec(root);

    System.out.println("\nDelete 30");
    deleteRec(root, 30);
    System.out.println("Inorder traversal of the modified tree");
    inorderRec(root);

    System.out.println("\nDelete 50");
    deleteRec(root, 50);
    System.out.println("Inorder traversal of the modified tree");
    inorderRec(root);
  }
}
