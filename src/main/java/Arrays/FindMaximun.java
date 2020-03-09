package Arrays;

public class FindMaximun {

  static int maxIndexDiff(int arr[],int n) {
    int maxDiff;
    int i,j;
    int RMax[] = new int[n];
    int LMin[] = new int[n];

    LMin[0] = arr[0];
    for(i=1;i<n;i++) {
      LMin[i] = Math.min(arr[i], LMin[i-1]);
    }

    RMax[n-1] = arr[n-1];
    for(j=n-2;j>=0;j--) {
      RMax[j] = Math.max(RMax[j+1],arr[j]);
    }

    i=0;
    j=0;
    maxDiff = -1;
    while (j<n && i<n) {
      if (LMin[i] < RMax[j]) {
        maxDiff = Math.max(maxDiff, j-i);
        j = j+1;
      } else i = i+1;
    }
    return maxDiff;
  }

  public static void main(String[] args)
  {

    int arr[] = {9, 2, 3, 4, 5, 6, 7, 8, 18, 0};
    int n = arr.length;
    int maxDiff = maxIndexDiff(arr, n);
    System.out.println(maxDiff);
  }
}
