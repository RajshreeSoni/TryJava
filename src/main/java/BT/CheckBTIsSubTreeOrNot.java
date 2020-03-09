/*
package BT;

public class CheckBTIsSubTreeOrNot {

  static Passing p = new Passing();

  static class Passing {
    int i;
    int m = 0;
    int n = 0;
  }

  public static void main(String args[]) {
    BinaryTreeNode T = new BinaryTreeNode('a');
    T.left = new BinaryTreeNode('b');
    T.right = new BinaryTreeNode('d');
    T.left.left = new BinaryTreeNode('c');
    T.right.right = new BinaryTreeNode('e');

    BinaryTreeNode S = new BinaryTreeNode('a');
    S.left = new BinaryTreeNode('b');
    S.right = new BinaryTreeNode('d');
    S.left.left = new BinaryTreeNode('c');

    if (isSubtree(T, S)) {
      System.out.println("Yes, S is a subtree of T");
    }
    else {
      System.out.println("No, S is not a subtree of T");
    }
  }

  private static boolean isSubtree(BinaryTreeNode T, BinaryTreeNode S) {
    if (S == null) {
      return true;
    }
    if (T == null) {
      return false;
    }

    char inT[] = new char[100];
    String op1 = String.valueOf(inT);
    char inS[] = new char[100];
    String op2 = String.valueOf(inS);
    storeInorder(T, inT, p);
    storeInorder(S, inS, p);
    inT[p.m] = '\0';
    inS[p.m] = '\0';

    if (strstr(op1, op2) != null) {
      return false;
    }

    p.m = 0;
    p.n = 0;
    char preT[] = new char[100];
    char preS[] = new char[100];
    String op3 = String.valueOf(preT);
    String op4 = String.valueOf(preS);
  }
}
*/
