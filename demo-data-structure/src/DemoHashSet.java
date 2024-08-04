import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DemoHashSet {
  public static void main(String[] args) {
    HashSet<String> strings = new HashSet<>();
    strings.add("hello");
    strings.add("abc");
    strings.add("world");
    System.out.println(strings); // [abc, world, hello]
    // ordering is not determined by insertion order

    ArrayList<String> strings2 = new ArrayList<>();
    strings2.add("hello");
    strings2.add("abc");
    strings2.add("world");
    System.out.println(strings2); // [hello, abc, world]
    // ordering follows the insertion order

    boolean hsResult = strings.add("hello");
    System.out.println(strings); // [abc, world, hello]
    System.out.println(hsResult); // false
    // not adding duplicate value

    boolean alResult = strings2.add("hello");
    System.out.println(strings2); // [hello, abc, world, hello]
    System.out.println(alResult); // true
    // adding duplicate string value

    System.out.println(strings.size()); // 3
    System.out.println(strings.remove("abc")); // true
    System.out.println(strings.contains("hello")); // true
    System.out.println(strings.isEmpty()); // false
    strings.addAll(strings2);
    System.out.println(strings); // [world, abc, hello]

    // Question 1: Remove duplicated value
    String[] arr = new String[] {"abc", "def", "xyz", "def"};
    HashSet<String> result = new HashSet<>();
    // loop
    for (String s : arr) {
      result.add(s);
    }
    System.out.println(result); // [abc, def, xyz]

    // Question 2: Find all duplicated value
    HashSet<String> result2 = new HashSet<>();
    ArrayList<String> arr2 = new ArrayList<>();
    for (String s : arr) {
      if (!result2.add(s)) {
        arr2.add(s);
      }
    }
    System.out.println(arr2); // [def]
  }
}
