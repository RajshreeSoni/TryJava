package Arrays;

public class TrappingRainWater {

  static int arr[] = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
  public static void main(String[] args)
  {

    System.out.println("Maximum water that can be accumulated is " + findWater(arr.length));
  }

  private static int findWater(int length) {
    int left[] = new int[length];
    int right[] = new int[length];

    int water = 0;

    left[0] = arr[0];
    for(int i=1;i<length;i++) {
      left[i] = Math.max(left[i-1], arr[i]);
    }

    right[length-1] = arr[length-1];
    for (int i = length-2;i>=0;i--) {
      right[i] = Math.max(right[i+1], arr[i]);
    }
    for(int i=0;i<length;i++) {
      water = water + (Math.min(left[i],right[i])-arr[i]);
    }
    return water;
  }

}
