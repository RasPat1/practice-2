public class GridDSSpec {
  public static void main(String[] args) {
    System.out.println("Start Tests");

    int size1 = 80;
    int cacheSize = 17;
    GridDS g1 = new GridDS(size1, cacheSize);
    System.out.println(g1.printData());
    System.out.println(g1.printCache());

    int x1 = 0;
    int y1 = 1;
    int x2 = 5;
    int y2 = 5;

    int sum = g1.sum(x1, y1, x2, y2);
    System.out.println("Sum:" + sum);

    int cacheSum = g1.cacheSum(x1, y1, x2, y2);
    System.out.println("Cache Sum:" + cacheSum);

    int successCount = 0;
    int failCount = 0;

    long totalSumTime = 0;
    long totalCacheTime = 0;

    for (int i = 0; i < size1 - 1; i++) {
      for (int j = 0; j < size1 - 1; j++) {
        // point 2
        for (int i2 = i; i2 < size1; i2++) {
          for (int j2 = j; j2 < size1; j2++) {
            long start = System.currentTimeMillis();
            int sum1 = g1.sum(i, j, i2, j2);
            long end1 = System.currentTimeMillis();
            int cacheSum1 = g1.cacheSum(i, j, i2, j2);
            long end2 = System.currentTimeMillis();
            totalSumTime += (end1 - start);
            totalCacheTime += (end2 - end1);

            if (sum1 != cacheSum1) {
              String testName = "(" + i +  "," + j + ")->(" + i2 + "," + j2 + ")";
              System.out.println("test failed for: " + testName);
              System.out.println(sum1 + " != " + cacheSum1);
              failCount++;
            } else {
              successCount++;
            }
          }
        }
      }
    }

    System.out.println("successCount: " + successCount);
    System.out.println("failCount" + failCount);

    System.out.println("sumTime: " + totalSumTime);
    System.out.println("cacheSumTime: " + totalCacheTime);


  }
}

