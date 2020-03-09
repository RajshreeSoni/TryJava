package LL;

public class ReverseLLInGroups {

  public static void main(String args[]) {
    LinkedListNode head = new LinkedListNode(1);
    head.next = new LinkedListNode(2);
    head.next.next = new LinkedListNode(3);
    head.next.next.next = new LinkedListNode(4);
    head.next.next.next.next = new LinkedListNode(5);
    head.next.next.next.next.next = new LinkedListNode(6);

    LinkedListNode.printList(head);

    LinkedListNode.printList(reverseListInGroups(head, 3));
  }

  private static LinkedListNode reverseListInGroups(LinkedListNode head, final int k) {
    LinkedListNode current = head;
    LinkedListNode next = null;
    LinkedListNode prev = null;

    int count = 0;
    while (count < k && current!= null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
      count++;
    }

    if (next != null) {
      head.next = reverseListInGroups(next, k);
    }

    return prev;
  }
}
