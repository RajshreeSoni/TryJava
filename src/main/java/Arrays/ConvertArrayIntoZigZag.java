package Arrays;

import java.util.Arrays;

public class ConvertArrayIntoZigZag {

  public static void main(String args[]) {
    int arr[] = {4, 3, 7, 8, 6, 2, 1};
    System.out.print(Arrays.toString(zigZag(arr)));
  }

  static int[] zigZag(int[] arr) {

    boolean flag = true;

    int temp = 0;
    for (int i=0;i<=arr.length-2;i++) {
      if (flag) {
        if (arr[i] > arr[i+1]) {
          temp = arr[i];
          arr[i] = arr[i+1];
          arr[i+1] = temp;
        }
      } else {
        if (arr[i] < arr[i+1]) {
          temp = arr[i];
          arr[i] = arr[i+1];
          arr[i+1] = temp;
        }
      }
      flag = !flag;
    }
    return arr;
  }
}
