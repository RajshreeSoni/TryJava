package LL;

public class AddTwoNumbers {

  public static void main(String args[]) {
    LinkedListNode head1 = new LinkedListNode(7);
    head1.next = new LinkedListNode(5);
    head1.next.next = new LinkedListNode(9);
    head1.next.next.next = new LinkedListNode(4);
    head1.next.next.next.next = new LinkedListNode(6);

    System.out.print("First List is = ");
    LinkedListNode.printList(head1);

    LinkedListNode head2 = new LinkedListNode(8);
    head2.next = new LinkedListNode(4);

    System.out.print("Second List is = ");
    LinkedListNode.printList(head2);

    System.out.print("Resultant List is = ");
    LinkedListNode.printList(addTwoLists(head1, head2));

  }

  private static LinkedListNode addTwoLists(LinkedListNode first, LinkedListNode second) {
    LinkedListNode res = null;
    LinkedListNode prev = null;
    LinkedListNode temp = null;
    int carry = 0, sum;
    while (first != null || second != null) {
      sum = carry + (first != null ? first.data : 0) + (second != null ? second.data : 0);
      carry = sum/10;
      sum = sum%10;
      temp = new LinkedListNode(sum);
      if (res == null) {
        res = temp;
      } else {
        prev.next = temp;
      }
      prev = temp;
      if (first!=null) {
        first = first.next;
      }
      if (second != null) {
        second = second.next;
      }
    }
    if (carry > 0) {
      temp.next = new LinkedListNode(carry);
    }
    return res;
  }
}
