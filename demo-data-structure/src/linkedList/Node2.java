package linkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Node2 {
  private String value;
  // private Node2 node; // 唔會套住自己 -> 用ArrayList / LinkedList

  public static void main(String[] args) {
    List<Node2> nodes = new ArrayList<>();
    nodes.add(new Node2());

    // LinkedList runtime is faster than ArrayList
    List<Node2> nodes2 = new LinkedList<>();
    nodes2.add(new Node2());

    // nodes.add() and nodes2.add() are running different implementation

    long before = System.currentTimeMillis();
    for (int i = 0; i < 1_000_000; i++) {
      nodes.add(new Node2());
    }
    long after = System.currentTimeMillis();
    System.out.println(after - before); // 64ms
  }
}
