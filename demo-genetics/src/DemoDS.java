import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import shape3.Circle3;
import shape3.Shape3;

public class DemoDS {
  public static void main(String[] args) {
    List<String> strings = new ArrayList<>();
    strings.add("abc");
    strings.add("def");
    strings.add("ghi");
    strings.add("jkl");
    strings.add("mno");
    System.out.println(strings);

    List<Customer> customers = new ArrayList<>();
    // ArrayList.class has Generics Design

    // convert List to Queue
    Queue<String> strings2 = new PriorityQueue<>();
    for (String s : strings) {
      strings2.add(s);
    }
    System.out.println(strings2);

    
    Map<Integer, String> map = new HashMap<>();
    map.put(1, "a");
    map.put(2, "b");
    map.put(3, "c");
    map.put(4, "d");
    map.put(5, "e");
    System.out.println(map); // {1=a, 2=b, 3=c, 4=d, 5=e}

    // convert Map to List
    List<Integer> mapKeyList = new ArrayList<>();
    for (Integer key : map.keySet()) {
      mapKeyList.add(key);
    }
    System.out.println(mapKeyList); // [1, 2, 3, 4, 5]

    List<String> mapValueList = new ArrayList<>();
    for (String value : map.values()) {
      mapValueList.add(value);
    }
    System.out.println(mapValueList); // [a, b, c, d, e]

    Deque<String> strings3 = new ArrayDeque<>();
    strings3.add("aaa");
    strings3.add("bbb");
    strings3.add("ccc");
    strings3.add("ddd");
    strings3.add("eee");
    System.out.println(strings3); // [aaa, bbb, ccc, ddd, eee]

    // convert Deque to Set (order will change)
    Set<String> sets = new HashSet<>();
    for (String s : strings3) {
      sets.add(s);
    }
    System.out.println(sets); // [aaa, ccc, bbb, eee, ddd]
  }
}
