package Arrays;

public class MaxDiffLeftToRight {

  public static void main(String args[]) {
    int arr[] = {1,2,90,10,110};
    System.out.println("Max diff is - "+ maxDiff(arr));
  }

  static int maxDiff(int arr[]) {
    int maxDiff = arr[1]-arr[0];
    int n = arr.length;
    int minElement = arr[0];
    for (int i=1; i< n ;i++) {
      if (arr[i]-minElement > maxDiff) {
        maxDiff = arr[i]-minElement;
      }
      if (arr[i] < minElement) {
        minElement = arr[i];
      }
    }
    return maxDiff;
  }
}
