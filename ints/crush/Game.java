public class Game {
  public static void main(String[] args) {
    System.out.println("Start Game");

    int boardSizeX = 10;
    int boardSizeY = 30;
    int colorCount = 3;

    Board board = new Board(boardSizeX, boardSizeY, colorCount);
    System.out.println(board);
  }
}