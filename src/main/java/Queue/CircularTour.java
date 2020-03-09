package Queue;

public class CircularTour {

  static class PetrolPump {
    int petrol;
    int distance;

    public PetrolPump(int petrol, int distance) {
      this.petrol = petrol;
      this.distance = distance;
    }
  }

  static int printTour(PetrolPump arr[], int n) {
    int start = 0;
    int end = 1;
    int currPetrol = arr[start].petrol - arr[start].distance;

    while (end != start || currPetrol < 0) {
      while (currPetrol <0 && end != start) {
        currPetrol = currPetrol - (arr[start].petrol - arr[start].distance);
        start = (start + 1) % n;
        if (start == 0) {
          return -1;
        }
      }
      currPetrol = currPetrol + arr[end].petrol - arr[end].distance;
      end = (end+1) % n;
    }
    return start;
  }

  public static void main(String args[]) {
    PetrolPump[] arr = {
        new PetrolPump(4,6),
        new PetrolPump(6,5),
        new PetrolPump(7,3),
        new PetrolPump(4,5)
    };
    int start = printTour(arr, arr.length);
    System.out.println(start == -1 ? "No Solution" : "Start = " + start);
  }
}
