package Stack;

import java.util.Stack;

public class NextGreaterElement {

  public static void main(String args[]) {
    int arr[] = {11,13,21,3};
    int n = arr.length;
    printNGE(arr, n);
  }

  private static void printNGE(int[] arr, int n) {
    int i=0;
    Stack<Integer> st = new Stack<Integer>();
    st.push(arr[0]);
    int element, next;
    for (i=1; i<n;i++){
      next = arr[i];
      if (!st.isEmpty()) {
        element = st.pop();
        while (element < next) {
          System.out.println(element + " --> " + next);
          if (st.isEmpty()) {
            break;
          }
          element = st.pop();
        }

        if (element > next) {
          st.push(element);
        }
      }
      st.push(next);
    }
    while (!st.isEmpty()) {
      element = st.pop();
      next = -1;
      System.out.println(element + " -- " + next);
    }
  }
}
