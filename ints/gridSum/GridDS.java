import java.util.Random;

public class GridDS {
  int[][] data;
  int[][] cache;
  int size;
  int cacheSize;
  static Random random;

  public GridDS(int size, int cacheSize) {
    this.size = size;
    this.cacheSize = cacheSize;
    data = new int[size][size];
    int cacheDim = (size / cacheSize) + 1;
    this.cache = new int[cacheDim][cacheDim];
    this.random = new Random();
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        insert(i, j, random.nextInt(100));
      }
    }
    generateCache();
  }

  public int sum(int x1, int y1, int x2, int y2) {
    int sum = 0;

    for (int i = x1; i <= x2; i++) {
      for (int j = y1; j <= y2; j++) {
        if (x1 >= 0 && y1 >= 0 && x2 <= data.length - 1 && y2 <= data[0].length - 1) {
          sum += data[i][j];
        }
      }
    }

    return sum;
  }

  public boolean insert(int x, int y, int newValue) {
    boolean success = false;
    if (x >= 0 && y >= 0 && x < size && y < size) {
      int currentValue = data[x][y];
      int change = newValue - currentValue;
      data[x][y] = newValue;
      cache[x / cacheSize][y / cacheSize] += change;

      success = true;
    }

    return success;
  }

  public int cacheSum(int x1, int y1, int x2, int y2) {
    int sum = 0;

    int offsetXStart = x1 % cacheSize == 0 ? 0 : cacheSize - (x1 % cacheSize);
    int offsetXEnd = x2 % cacheSize;
    int offsetYStart = y1 % cacheSize == 0 ? 0 :  cacheSize - (y1 % cacheSize);
    int offsetYEnd = y2 % cacheSize;

    // for the start x offset and the end x offset don't use the cache
    // same for the start and end y offset

    for (int i = x1; i <= x2; i++) {
      for (int j = y1; j <= y2; j++) {
        if (i % cacheSize == 0 && j % cacheSize == 0 && i + cacheSize <= x2 && j + cacheSize <= y2) {
          // System.out.println("Clause 3 " + cache[i / cacheSize][j / cacheSize]);
          sum += cache[i / cacheSize][j / cacheSize];
        } else if (i < (x1 + offsetXStart) || i >= (x2 - offsetXEnd)) {
          // System.out.println("Clause 1 " + data[i][j]);
          sum += data[i][j];
        } else if (j < (y1 + offsetYStart) || j >= (y2 - offsetYEnd)) {
          // System.out.println("Clause 2 " + data[i][j]);
          sum += data[i][j];
        }
      }
    }


    // int i = x1;

    // while (i <= x2) {
    //   int j = y1;

    //   while (i <= x2 && j <= y2) {
    //     if (i % cacheSize == 0 && i + cacheSize <= x2
    //       && j % cacheSize == 0 && j + cacheSize <= y2) {
    //       int cacheX = x1 / cacheSize;
    //       int cacheY = y1 / cacheSize;

    //       sum += cache[cacheX][cacheY];
    //       i += cacheSize;
    //       j += cacheSize;
    //     } else {
    //       sum += data[i][j];
    //       j++;
    //     }
    //   }
    //   i++;
    // }
    return sum;
  }

  public void generateCache() {

    for (int i = 0; i < cache.length; i++) {
      for (int j = 0; j < cache.length; j++) {
        int x1 = i * cacheSize;
        int y1 = j * cacheSize;

        int x2 = x1 + cacheSize - 1 >= size - 1 ? size - 1 : x1 + cacheSize - 1;
        int y2 = y1 + cacheSize - 1 >= size - 1 ? size - 1 : y1 + cacheSize - 1;

        cache[i][j] = sum(x1, y1, x2, y2);
      }
    }
  }

  public String printData() {
    return printArray(data);
  }

  public String printCache() {
    return printArray(cache);
  }

  public String printArray(int[][] arr) {
    String stringRep = "";
    int sizePerEntry = 5;

    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        int val = arr[i][j];
        String valString = String.valueOf(val);
        String padding = "";
        int spacesNeeded = sizePerEntry - valString.length();

        for (int padCount = 0; padCount < spacesNeeded; padCount++) {
          padding += " ";
        }

        valString = padding + valString;
        stringRep += valString;
      }
      stringRep += "\n";
    }

    return stringRep;
  }
}