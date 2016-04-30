import java.util.Random;

public class Grid {
  int x;
  int y;
  int[][] data;
  int[][] pathLens;
  int maxPathLen = 0;
  static Random random;

  public Grid(int x, int y) {
    this.x = x;
    this.y = y;
    this.data = new int[x][y];
    this.pathLens = new int[x][y];
    this.random = new Random();
    generateGrid();
  }

  public void generateGrid() {
    int maxValue = x * y;
    int count = maxValue;
    int[] newVals = new int[maxValue];
    for (int i = 0; i < maxValue; i++) {
      newVals[i] = i;
    }

    for (int i = 0; i < x; i++) {
      for (int j = 0; j < y; j++) {
        // When adding a new value to the grid
        // Get a random index between 0 and count
        // take the value that index points to as the new value in teh grid
        // Swap it with the last valid element in teh array
        // decrease the count so the element at the end of the array is now "out of the array"
        // I'm doing all this cause avoiding importing an arraylist for no reason

        int index = random.nextInt(count);
        data[i][j] = newVals[index];
        newVals[index] = newVals[count - 1];
        count--;
      }
    }

    getPaths(); // whatevs tack that shit on to the constructor chain;
  }

  public void getPaths() {
    int max = 0;

    for (int i = 0; i < x; i++) {
      for (int j = 0; j < y; j++) {
        pathLens[i][j] = chain(i, j);
        max = max > pathLens[i][j] ? max : pathLens[i][j];
      }
    }

    this.maxPathLen = max;
  }

  public int chain(int i, int j) {
    int l = 0;
    int r = 0;
    int a = 0;
    int b = 0;
    int chainLen = 1;
    int val = data[i][j];

    if (i - 1 >= 0 && val < data[i-1][j]) {
      l = chain(i - 1, j);
    }
    if (i + 1 < x && val < data[i+1][j]) {
      r = chain(i + 1, j);
    }
    if (j - 1 >= 0 && val < data[i][j-1]) {
      l = chain(i, j - 1);
    }
    if (j + 1 < y && val < data[i][j+1]) {
      l = chain(i, j + 1);
    }

    int m1 = a > b ? a : b;
    int m2 = l > r ? l : r;
    int max = m1 > m2 ? m1 : m2;

    return chainLen + max;
  }

  public String printArr(int[][] arr) {
    String result = "";
    int maxLen = String.valueOf(x * y).length();

    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        String numWithPad = " ";
        String num = String.valueOf(arr[i][j]);
        int padSize = maxLen - num.length();

        for (int pad = 0; pad < padSize; pad++) {
          numWithPad += " ";
        }

        numWithPad = num + numWithPad;
        result += numWithPad;
      }

      result += "\n";
    }

    return result;
  }

  public String toString() {
    String result = "";

    result += printArr(data);
    result += "\n";
    result += printArr(pathLens);
    result += "\n";
    result += "Max Path Length: " + maxPathLen;

    return result;
  }
}