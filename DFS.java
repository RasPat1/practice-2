import java.util.Random;

public class DFS {
  public static void main(String[] args) {
    System.out.println("Start");
    Node n1 = new Node(10);
    System.out.println("Node n1: " + n1);

    Node rTree = getRandomTree();
    System.out.println("rTree: " + rTree);
    System.out.println("rTree Size: " + rTree.size);

    System.out.println("width: " + rTree.getMetaData().leafCount);
    System.out.println("leftSize: " + rTree.left.size);
    System.out.println("rightSize: " + rTree.right.size);
  }

  public static Node getRandomTree() {
    Random random = new Random();
    int nodeCount = 5;
    int maxValue = 25;
    Node root = new Node(11);

    for (int i = 0; i < nodeCount; i++) {
      int rValue = random.nextInt(maxValue);
      root.insert(new Node(rValue));
    }

    return root;
  }
}

class Node {
  int data;
  Node left = null;
  Node right = null;
  Node parent = null;
  int size = 0;

  public Node(int data) {
    this.data = data;
  }

  public void insert(Node n) {
    if (n.data < this.data) {
      if (this.left == null) {
        this.left = n;
        n.parent = this;
        updateSize();
      } else {
        this.left.insert(n);
      }
    } else {
      if (this.right == null) {
        this.right = n;
        n.parent = this;
        updateSize();
      } else {
        this.right.insert(n);
      }
    }
  }

  public void updateSize() {
    size++;
    if (this.parent != null) {
      this.parent.updateSize();
    }
  }

  /**
   * Returns the width of the binary tree
   * This is actually just the number of leaves
  **/
  public NodeData getMetaData() {
    // traverse the tree and count the number of nodes?

    int nodeCount = 0;
    int charCount = 0;
    if (this.left == null && this.right == null) {
      nodeCount++;
    }

    if (this.left != null) {
      nodeCount += this.left.getMetaData().leafCount;
      charCount += this.left.getMetaDataLength();
    }

    if (this.right != null) {
      nodeCount += this.right.getMetaData().leafCount;
      charCount += this.right.getDataLength();
    }

    return new NodeData(nodeCount, charCount);
  }

  /**
   * Number of Characters in the data stored
   * in the node
  **/
  public int getDataLength() {
    return String.valueOf(this.data).length();
  }

  public String getString() {
    NodeData metaData = getMetaData();
    int spacingCount = 2;
    String result = "";
    String spaceBetween = "";
    for (int i = 0; i < spacingCount; i++) {
      spaceBetween += "+";
    }

    int interleafPad = 0;
    if (metaData.leafCount > 1) {
      interleafPad = metaData.leafCount - 1 * spacingCount
    }

    int totalSize = interleafPad + metaData.charCount - this.getDataLength();
    int pad = totalSize / 2;
    String halfPadString = "";
    for (int i = 0; i < pad; i++) {
      halfPadString += "+";
    }

    result += halfPadString + this.data + halfPadString + "\n";

    String leftString = "";
    String rightString = "";

    if (this.left != null) {
      leftString = this.left.toString();
    } else {
      leftString = halfPadString;
    }

    if (this.right != null) {
      rightString = this.right.toString();
    } else {
      rightString = halfPadString;
    }

    result += leftString + spaceBetween + rightString;

    return result;
  }

  @Override
  public String toString() {
    return "\n" + this.getString();
  }

  class NodeData {
    int leafCount;
    int charCount;

    public NodeData(int leafCount, int charCount) {
      this.leafCount = leafCount;
      this.charCount = charCount;
    }
  }
}