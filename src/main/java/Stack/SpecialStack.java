package Stack;

import java.util.Stack;

public class SpecialStack extends Stack<Integer>{

  Stack<Integer> min = new Stack<Integer>();
  public void push(int x) {
    if (isEmpty() == true) {
      super.push(x);
      min.push(x);
    } else {
      super.push(x);
      int y = min.peek();
      if (x < y) {
        min.push(x);
      }
    }
  }

  public Integer pop() {
    int x = super.pop();
    int y = min.peek();
    if (x == y) {
      min.pop();
    }
    return x;
  }

  public Integer getMin() {
    return min.peek();
  }
  public static void main(String args[]) {
    SpecialStack st = new SpecialStack();
    st.push(10);
    st.push(20);
    st.push(30);
    System.out.println(st.getMin());
    st.push(5);
    System.out.println(st.getMin());
  }
}
