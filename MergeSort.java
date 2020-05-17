import java.util.List;

public class MergeSort {
  public static void main(String[] args) {
    int[] test1 = {2,1,3,56,3,12};
    System.out.println("Before:");
    printArray(test1);

    sort(test1);

    System.out.println("After:");
    printArray(test1);

  }

  // mergeSort
  public static void sort(int[] data) {



  }

  public static sortSubSection() {

  }






  public static void printArray(int[] data) {
    String result = "[";

    for (int i = 0; i < data.length; i++) {
      result += i;
      if (i == data.length - 1) {
        result += "]";
      } else {
        result += ", ";
      }
    }

    System.out.println(result);
  }
}