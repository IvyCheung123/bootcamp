import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import sorting.Ball2;
import sorting.Ball2SortbyNumber;
import sorting.Color2;

public class DemoPriorityQueue {
  public static void main(String[] args) {
    Queue<String> pq = new PriorityQueue<>();
    pq.add("d"); // [d]
    pq.add("a"); // [d, a] -> [a, d]
    pq.add("b"); // [a, d, b] -> [a, b, d]
    System.out.println(pq); // [a, d, b] -> add() does not perform sorting
    pq.add("c");
    System.out.println(pq); // [a, c, b, d]

    while (!(pq.isEmpty())) {
      System.out.println(pq.poll());
    }
    // a b c d
    // complete sorting in natural order by default when you call poll()
    // Queue: 每次都sort -> 有幾多個<E>就sort幾多次

    // PriorityQueue.class add() & poll() differs to LinkedList.class (different implementation)
    Queue<String> pq2 = new LinkedList<>();
    pq2.add("d");
    pq2.add("a");
    pq2.add("b");
    pq2.add("c");
    System.out.println(pq2); // [d, a, b, c]
    // Collections.sort(pq2); // Queue does not implement Comparable.interface
    // 1. Java 8 -> Stream (List)
    // 2. Convert to Array -> Arrays.sort()
    String[] str = new String[pq2.size()]; // 4
    int index = 0;
    while (!pq2.isEmpty()) {
      str[index++] = pq2.poll();
    }
    System.out.println(Arrays.toString(str)); // [d, a, b, c]
    Arrays.sort(str);
    System.out.println(Arrays.toString(str)); // [a, b, c, d]

    // List
    List<String> pq3 = new LinkedList<>();
    pq3.add("def");
    pq3.add("abc");
    pq3.add("bbb");
    pq3.add("aax");
    System.out.println(pq3); // [def, abc, bbb, aax]
    Collections.sort(pq3);
    System.out.println(pq3); // [aax, abc, bbb, def]
    // List: 最後先一次過sort -> 速度based on幾多個<E>

    Queue<Integer> pq4 = new PriorityQueue<>();
    pq4.add(-20);
    pq4.add(100);
    pq4.add(10);
    pq4.add(-200);
    System.out.println(pq4.poll()); // -200
    System.out.println(pq4.poll()); // -20
    pq4.add(-1);
    System.out.println(pq4.poll()); // -1
    System.out.println(pq4.poll()); // 10
    System.out.println(pq4.poll()); // 100

    Queue<Ball2> balls = new PriorityQueue<>(new Ball2SortbyNumber());
    balls.add(new Ball2(1, Color2.RED));
    balls.add(new Ball2(20, Color2.BLACK));
    balls.add(new Ball2(5, Color2.WHITE));
    balls.add(new Ball2(10, Color2.RED));
    System.out.println(balls.poll()); // 1
    System.out.println(balls.poll()); // 5
    System.out.println(balls.poll()); // 10
    System.out.println(balls.poll()); // 20

    // LongDescendingOrder
    // public int compare(Long l1, Long l2) {
    //   return l2.compareTo(l1);
    //   // return l2 > l1 ? -1 : 1; // ">" -> convert Long to long
    // }
  }
}
