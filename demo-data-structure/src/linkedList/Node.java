package linkedList;

// ArrayList -> undelying array memory location -> 又加又殺會唔穩定
// This Node.class presents LinkedList -> undelying object location -> 穩定
public class Node {
  private String value;
  private Node nextNode;

  public Node(String value) {
    this.value = value;
  }

  public Node(String value, Node node) {
    this.value = value;
    this.nextNode = node;
  }

  public Node next(Node node) { // setter
    this.nextNode = node;
    return node;
  }

  public Node getNext() {
    return this.nextNode;
  }

  public String getValue() {
    return this.value;
  }

  public static void main(String[] args) {
    Node node = new Node("node");
    Node node2 = node.next(new Node("node2"));
    node2.next(new Node("node3"));
    System.out.println(node);

    // 要由頭loop到落尾先get到最後嘅value
    Node head = node;
    while (head != null) {
      System.out.println(head.getValue());
      head = head.getNext();
    }
  }
}
