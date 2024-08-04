package linkedList;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import cat.Cat;

public class DemoLinkedList {
  public static void main(String[] args) {
    // Array vs ArrayList
    // 1. Underlying structure of ArrayList is array
    // 2. array -> fixed length -> a range of continous memory locations

    Cat3 cat = new Cat3(Color.BLUE);
    // Heap
    // 1. Three enum Eye objects (run-time)
    // 2. Cat object
    // 3. Eye[] object
    // 4. Two Eye objects

    cat.getEyes(); // Cat object -> get Eye[] object
    cat.getLeftEye(); // Cat object -> get Eye[] object -> Eye object

    Eye[] eyes = cat.getEyes(); // use obj ref to backup Eye[] object memory location
    Eye rightEye = eyes[1];
    System.out.println(rightEye); // linkedList.Eye@8bcc55f

    // What is the relationship between memory location of cat, eyes, rightEye?
    // 1. leftEye vs rightEye -> Eye[] -> array neightbour
    // 2. Cat object vs Eye[] object -> obj ref & getter
    // 3. Cat object vs Eye object -> obj ref & getter

    String[] strings = new String[5]; // 5 null memories if don't use -> why not use ArrayList to handle add & remove automatically?

    // ArrayList & LinkedList: same interface
    // ArrayList -> 知道location就即刻locate到 get到value
    ArrayList<String> strings2 = new ArrayList<>();
    strings2.add("node");
    strings2.add("node2");
    strings2.add("node3");
    strings2.add("node4");
    strings2.add("node5");
    strings2.remove("node5");
    strings2.remove(0); // remove index
    for (String s : strings2) {
      System.out.println(s); // node2 node3 node4
    }

    System.out.println(strings2.get(0)); // node2
    System.out.println(strings2.get(strings2.size() - 1)); // node4

    // LinkedList
    // Adv: 要經常remove head -> 用LinkedList -> 直接replace old head to new head -> get new head value
    LinkedList<String> strings3 = new LinkedList<>();
    strings3.add("node");
    strings3.add("node2");
    strings3.add("node3");
    strings3.add("node4");
    strings3.add("node5");
    strings3.remove("node5");
    strings3.remove(0); // remove index
    for (String s : strings3) {
      System.out.println(s); // node2 node3 node4
    }

    System.out.println(strings3.get(0)); // node2
    System.out.println(strings3.get(strings3.size() - 1)); // node4

    System.out.println(strings3.isEmpty()); // false

    // ArrayList vs LinkedList
    // 1. Underlying Data Structure
    // 2. Method difference (i.e. LinkedList -> addFirst(), removeFirst())

    LinkedList<String> strings4 = new LinkedList<>();
    strings4.add("world");
    strings4.addFirst("hello");
    strings4.add("!!!");
    for (String s : strings4) {
      System.out.println(s);
    } // hello world !!!

    strings4.removeFirst();
    for (String s : strings4) {
      System.out.println(s);
    } // world !!!

    System.out.println(strings4.indexOf("world")); // 0

    strings4.add("world");
    System.out.println(strings4.lastIndexOf("world")); // 2
    // Difference of method implementation:
    // LinkedList.lastIndexOf() -> loop all
    // ArrayList.lastIndexOf() -> ArrayList.add()每次都係add去最後

    System.out.println(strings4.containsAll(strings4)); // true
    System.out.println(strings4.removeAll(strings4)); // true

    // Polymorphism
    List<String> strings5 = new LinkedList<>();
    // strings4.addFirst();
    // strings4.removeFirst();
    // List.interface doesn't have addFirst() and removeFirst()

    ArrayList<String> al = new ArrayList<>();
    LinkedList<String> ll = new LinkedList<>();
    // al = ll; // cannot convert from LinkedList<String> to ArrayList<String>
    // al = new LinkedList(); // cannot convert from LinkedList<String> to ArrayList<String>

    // List: has ordering, can get value by index
    List<String> al2 = new ArrayList<>();
    List<String> ll2 = new LinkedList<>();
    al2 = ll2;
    al2 = new LinkedList<>();

    System.out.println();
    // Queue.interface         interface cannot create object
    // Queue usage: will not get the object in the middle
    Queue<String> emails = new LinkedList<>();
    emails.add("aaa@gmail.com");
    emails.add("bbb@gmail.com");
    emails.add("ccc@gmail.com");
    emails.add("ddd@gmail.com");
    emails.add("ddd@gmail.com");
    System.out.println(emails.size()); // 5, calling Collection.size()
    System.out.println(emails); // [aaa@gmail.com, bbb@gmail.com, ccc@gmail.com, ddd@gmail.com, ddd@gmail.com]

    List<String> ls = new LinkedList<>();

    String head = emails.poll(); // remove and return the first element in queue
    System.out.println(head); // aaa@gmail.com

    String lookup = emails.peek(); // return the first element in queue
    System.out.println(lookup); // bbb@gmail.com

    System.out.println();
    System.out.println(emails); // [bbb@gmail.com, ccc@gmail.com, ddd@gmail.com, ddd@gmail.com]
    // remove() similar to poll() -> remove() is calling equals()???????
    emails.remove(new String("ddd@gmail.com"));
    // Here: LinkedList.remove(Object) -> LinkedList for loop
    // But: ArrayList.remove -> difference????????????????????????
    System.out.println(emails); // [bbb@gmail.com, ccc@gmail.com, ddd@gmail.com]

    // Not common use for loop in Queue -> use while loop
    for (String s : emails) {
      System.out.println(s);
    }
    // bbb@gmail.com
    // ccc@gmail.com
    // ddd@gmail.com
    System.out.println(emails.poll()); // bbb@gmail.com

    // while (!emails.isEmpty()) {
    //   System.out.println(emails.poll());
    // }
    // // ccc@gmail.com
    // // ddd@gmail.com

    // convert Queue<String> to List<String>
    List<String> strings6 = new ArrayList<>();
    while (!emails.isEmpty()) {
      strings6.add(emails.poll());
    }
    System.out.println(strings6); // [ccc@gmail.com, ddd@gmail.com]
    System.out.println(emails); // []

    // clear()
    strings6.clear(); // clear all the objects inside the ArrayList object
    strings6.add("abc");
    strings6 = null; // remove the ArrayList object
    // strings6.add("def"); // Null pointer exception (NPE)
  }
}
