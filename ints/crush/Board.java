import java.util.Random;
import java.util.ArrayList;

public class Board {
  int width;
  int height;
  int colorCount;
  String[] colorList;
  Gem[][] data;
  static Random random = new Random();
  static String[] allColors = {"Red", "Green", "Blue", "Purple", "Yellow"};

  public Board(int width, int height, int colorCount) {
    this.width = width;
    this.height = height;
    this.colorCount = colorCount;
    this.colorList = new String[colorCount];

    for (int i = 0; i < colorCount; i++) {
      this.colorList[i] = allColors[i];
    }

    this.data = new Gem[width][height];

    generateBoard();
  }

  public void generateBoard() {


    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {

        String color = getNextColor(i, j);
        //String color = getRandomColor();

        data[i][j] = new Gem(color);
      }
    }
  }

  public String getNextColor(int x, int y) {
    String selectedColor;
    ArrayList<String> invalidColors = new ArrayList<String>();

    if (x > 1 && colorAt(x - 1, y) == colorAt(x - 2, y)) {
      invalidColors.add(colorAt(x - 1, y));
    }

    if (y > 1 && colorAt(x, y-1) == colorAt(x, y-2)) {
      invalidColors.add(colorAt(x, y-1));
    }

    ArrayList<String> validColors = new ArrayList<String>();
    for (int i = 0; i < colorCount; i++) {
      String color = colorList[i];
      if (!invalidColors.contains(color)) {
        validColors.add(color);
      }
    }

    int size = validColors.size();

    if (size == 0) {
      System.out.println("NO COLORS LEFT");
    }

    int randomIndex = random.nextInt(size);
    selectedColor = validColors.get(randomIndex);

    return selectedColor;
  }

  public String getNextRandomColor() {
    int colorIndex = random.nextInt(colorCount);
    String color = colorList[colorIndex];
    return color;
  }

  public String colorAt(int x, int y) {
    return data[x][y].color;
  }

  public String toString() {
    String result = "";
    for (int j = 0; j < height; j++) {
      for (int i = 0; i < width; i++) {
        Gem gem = data[i][j];
        String gemRep = gem.color.substring(0, 1);
        if (i != height - 1) {
          gemRep += " ";
        }
        result += gemRep;
      }

      result += "\n";
    }

    result += "Width: " + width + "\n";
    result += "Height: " + height + "\n";
    result += "Colors:";

    for (int i = 0; i < colorList.length; i++) {
      result += " " + colorList[i];
    }
    result += "\n";

    return result;
  }



  class Gem {
    String color;

    public Gem(String color) {
      this.color = color;
    }
  }
}