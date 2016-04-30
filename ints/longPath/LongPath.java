public class LongPath {
  public static void main(String[] args) {
    System.out.println("Path Started");
    long start = System.currentTimeMillis();
    Grid g1 = new Grid(400, 400);
    long end = System.currentTimeMillis();

    System.out.println(g1);

    System.out.println("Time Taken: " + (end - start) + "ms");
  }

}