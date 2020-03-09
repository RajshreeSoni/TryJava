package Arrays;

public class EquilibriumIndexOfArray {

  public static void main(String args[]) {
    int arr[] = {-7, 1, 5, 2, -4, 3, 0};
    int n = arr.length;
    System.out.println("First equilibrium index is " +
        equilibrium(arr, n));
  }

  static int equilibrium(int arr[],int n) {
    int sum = 0;
    int leftSum =0;
    for(int i=0;i<n;i++) {
      sum=sum+arr[i];
    }

    for(int i=0;i<n;i++) {
      sum = sum-arr[i];
      if (leftSum==sum) {
        return i;
      }
      leftSum=leftSum+arr[i];
    }
    return -1;
  }
}
