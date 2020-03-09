package LL;

public class LinkedListNode {

  public int data;
  public LinkedListNode next;

  public LinkedListNode(int data) {
    this.data = data;
    next = null;
  }

  public static void printList(final LinkedListNode node) {
    LinkedListNode temp = node;
    while (temp!= null) {
      System.out.print(temp.data+ " ");
      temp = temp.next;
    }
    System.out.println();
  }
}
