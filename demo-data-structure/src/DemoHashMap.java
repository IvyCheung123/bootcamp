import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class DemoHashMap {
  public static void main(String[] args) {
    // Key & Value pair (Key + Value -> Entry)
    // A map consists of many entries
    HashMap<Integer, String> nameMap = new HashMap<>(); // key -> Integer, value -> String
    nameMap.put(100, "Vincent");

    // You can get value by key
    System.out.println(nameMap.get(100)); // Vincent

    // You CANNOT get key by value
    System.out.println(nameMap.get("Vincent")); // null

    // No ordering
    nameMap.put(1010, "Cindy");
    nameMap.put(-45, "Sally");
    System.out.println(nameMap.get(-45)); // Sally

    // for loop -> HashMap.class
    // loop ketSet()
    for (Integer i : nameMap.keySet()) {
      System.out.println("Key: " + i);
    } // Key: 1010 Key: 100 Key: -45

    // loop value
    for (String s : nameMap.values()) {
      System.out.println("Value: " + s);
    } // Value: Cindy Value: Vincent Value: Sally

    // loop for entries
    for (Map.Entry<Integer, String> enrty : nameMap.entrySet()) {
      System.out.println("Key: " + enrty.getKey() + ", Value: " + enrty.getValue());
    }
    // Key: 1010, Value: Cindy
    // Key: 100, Value: Vincent
    // Key: -45, Value: Sally

    // Handle duplicated key -> overwrite the value if the key exists
    nameMap.put(1010, "Peter");
    System.out.println(nameMap); // {1010=Peter, 100=Vincent, -45=Sally}

    // null key
    nameMap.put(null, "Oscar");
    System.out.println(nameMap); // {null=Oscar, 1010=Peter, 100=Vincent, -45=Sally}

    // null value
    nameMap.put(-45, null);
    System.out.println(nameMap); // {null=Oscar, 1010=Peter, 100=Vincent, -45=null}

    // remove entry by key
    String oldValue = nameMap.remove(1010);
    System.out.println(nameMap); // {null=Oscar, 100=Vincent, -45=null}
    System.out.println(oldValue); // Peter

    System.out.println(nameMap.containsKey(null)); // true
    System.out.println(nameMap.containsValue("null")); // false
    System.out.println(nameMap.containsValue(null)); // true
  }
}
