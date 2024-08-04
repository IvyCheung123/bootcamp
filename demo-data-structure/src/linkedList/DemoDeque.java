package linkedList;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentHashMap;

public class DemoDeque {
  // Queue -> 淨係頭可以拎野嘅水管, add() to tail only
  // Deque -> 頭尾都可以拎野嘅水管
  // Deque.interface extends Queue.interface
  // so Deque supports add(), remove(), size(), etc
  public static void main(String[] args) {
    Deque<String> strings = new LinkedList<>();
    strings.add("abc"); // add() same as addLast()
    strings.add("def");
    strings.addFirst("hello");
    strings.addLast("world");
    System.out.println(strings); // [hello, abc, def, world]

    System.out.println(strings.peek()); // hello, peek() same as peekFirst()
    System.out.println(strings.peekFirst()); // hello
    System.out.println(strings.peekLast()); // world

    strings.removeFirst();
    strings.removeLast();
    System.out.println(strings); // [abc, def]

    strings.remove(); // remove() same as removeFirst()
    System.out.println(strings); // [def]

    // ArrayDeque.class

    // Coding Presentation
    // 1. ArrayDeque: undelying DS decision -> decide to use Deque[]
    // 2. Deque<>: role decision -> two-way in out
    Deque<String> strings2 = new ArrayDeque<>(); // underlying DS: Array -> fixed length
    strings2.add("abc"); // create new Deque[] object, then put String object into Deque[]
    strings2.add("def");
    strings2.addFirst("hello");
    strings2.addLast("world"); // [hello, abc, def, world]
    strings2.removeFirst();
    strings2.removeLast(); // [abc, def]
    strings2.remove(); // [def]
    
    // 2. Queue<>: role decision -> first-in first-out
    Queue<String> strings3 = new ArrayDeque<>();
    strings3.add("abc");
    strings3.add("def"); // [abc, def]
    strings3.remove(); // [def]

    Collection<String> strings4 = new ArrayDeque<>();
    List<String> strings5 = new ArrayList<>();
    // ArrayList -> get by index -> 要插隊
    // LinkedList -> 放棄index -> 唔可以插隊 -> refer to Node
    strings5.add("abc");
    strings5.add("def");
    strings5.add(1, "hello"); // [abc, hello, def]

    // Insertion
    // 1. 頭尾插入: LinkedList is faster than ArrayList
    // 2. 中間插入: LinkedList is faster than ArrayList
    // Explanation: LinkedList use node pointer (point to the head obj ref -> memory location), then insert

    // Data Structure Tree
    new ConcurrentHashMap<>();
    // new SortedSet<E>() {

    // };
  }
}
