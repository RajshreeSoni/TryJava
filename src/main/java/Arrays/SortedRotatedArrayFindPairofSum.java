package Arrays;

public class SortedRotatedArrayFindPairofSum {

  static int findMin(int arr[], int low, int high) {

    if (high<low) {
      return arr[0];
    }

    if (high == low) {
      return arr[low];
    }

    int mid = low + (high-low)/2;

    if (mid < high && arr[mid+1] < arr[mid]) {
      return arr[mid+1];
    }

    if (mid > low && arr[mid] < arr[mid-1]) {
      return arr[mid];
    }

    if (arr[high] > arr[mid]) {
      return findMin(arr, low, mid-1);
    } else {
      return findMin(arr, mid+1, high);
    }
  }

  public static void main (String[] args) {
    int arr1[] = {5, 6, 1, 2, 3, 4};
    int n1 = arr1.length;
    //System.out.println("The minimum element is " + findMin(arr1, 0, n1 - 1));
    System.out.print(pairsInSortedRotated(arr1, n1, 9));
  }

  static int pairsInSortedRotated(int arr[], int n,int x) {
    int i;
    for (i=0;i<n-1;i++) {
      if (arr[i] > arr[i+1]) {
        break;
      }
    }

    int l = (i+1)%n;
    int r = i;
    int cnt =0;
    while (l!=r) {
      if (arr[l]+arr[r] == x) {
        cnt++;
        if (l == (r-1+n)%n) {
          return cnt;
        }
        l = (l+1)%n;
        r = (r-1+n)%n;
      }
      else if (arr[l] + arr[r] < x) {
        l = (l+1)%n;
      } else {
        r = (n+r-1)%n;
      }
    }
    return cnt;
  }
}
