import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DemoList {
  public static void main(String[] args) {
    List<String> strings = new ArrayList<>(); // ArrayList.class implements List.interface
    strings.add("hello");
    strings.add("abc");
    strings.remove("abc");
    System.out.println(strings.size()); // 1

    // ArrayList.class has ALL methods defined in List.interface
    // ArrayList MAY implemenet more than one interface
    // ArrayList MAY have its own methods, which did not define in interfaces

    // Polymorphism
    // 1. Compile-time: scope of Strings(obj ref)
    // 2. Run-time: method implementation

    // Collection.interface
    Collection<String> strings2 = new ArrayList<>();
    strings2.add("hello");
    System.out.println(strings2.size()); // 1
    // 寬指針可以換object
    strings2 = new HashSet<>();
    System.out.println(strings2.size()); // 0

    // Set.interface
    Set<String> strings3 = new HashSet<>();
    // strings3 = new ArrayList(); // ArrayList.class doesn't implement Set.interface

    strings.add("hello"); // ignore duplicate
    // so, the implementation of ArrayList.add() differ to the implementation of HashSet.add()

    // Map.interface
    Map<String, String> nameMap = new HashMap<>();

    // Data structure of data structure
    List<HashMap<String, String>> mapList = new ArrayList<>();
    HashMap<String, String> nameList = new HashMap<>();
    nameList.put("Alan", "Chan");
    HashMap<String, String> bookList = new HashMap<>();
    bookList.put("Hello", "World");
    mapList.add(nameList);
    mapList.add(bookList);
  }
}
