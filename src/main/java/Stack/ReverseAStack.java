package Stack;

import java.util.Stack;

public class ReverseAStack {

  static void printStack(Stack<Integer> st) {
    if (st.isEmpty()) {
      return;
    }
    while (!st.isEmpty()) {
      System.out.print(st.pop() + "  ");
    }
    System.out.println();
  }

  static Stack<Integer> reverse(Stack<Integer> st) {
    if (st.size() > 0) {
      int x = st.pop();
      st = reverse(st);
      st = insetAtBottom(x, st);
    }
    return st;
  }

  private static Stack<Integer> insetAtBottom(int x, Stack<Integer> st) {
    if (st.isEmpty()) {
      st.push(x);
    } else {
      int a = st.pop();
      insetAtBottom(x, st);
      st.push(a);
    }
    return st;
  }

  public static void main(String args[]) {
    Stack<Integer> st = new Stack<Integer>();
    st.push(1);
    st.push(2);
    st.push(3);
    st.push(4);
    st.push(5);

    System.out.println("Reversed Stack");
    printStack(reverse(st));
  }
}
