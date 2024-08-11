import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class DemoMapLambda {
  public static void main(String[] args) {
    Map<String, Customer> customerMap = new HashMap<>();
    customerMap.put("C1234", new Customer("John"));
    customerMap.put("C1235", new Customer("Sam"));

    if (customerMap.containsKey("C1234")) {
      System.out.println(customerMap.get("C1234").getName()); // John
    }

    Function<String, Customer> defaultCustomer = s -> new Customer("Dummy");
    customerMap.computeIfAbsent("C1236", defaultCustomer);

    for (Map.Entry<String, Customer> entry : customerMap.entrySet()) {
      System.out.println(entry.getKey() + ", " + entry.getValue());
    }
    // C1236, Customer(Name=Dummy)
    // C1235, Customer(Name=Sam)
    // C1234, Customer(Name=John)

    // 2. merge -> BiFunction
    Map<String, Integer> map = new HashMap<>();
    map.put("Peter", 10);
    map.put("Jenny", 2);
    map.put("Vincent", 8);
    map.put("John", 12);

    // All entry value + 2
    map.put("Peter", map.get("Peter") + 2); // 12
    map.put("Jenny", map.get("Jenny") + 2);
    map.put("Vincent", map.get("Vincent") + 2);
    map.put("John", map.get("John") + 2);
    // map.put("John", map.get("Dummy") + 2); // java.lang.NullPointerException
    System.out.println(map.get("Vincent")); // 10

    BiFunction<Integer, Integer, Integer> addValue = (oldValue, newValue) -> oldValue + newValue;
    map.merge("Peter", 3, addValue); // addValue.apply()
    map.merge("Dummy", 3, addValue);
    System.out.println(map.get("Peter")); // 15
    System.out.println(map.get("Dummy")); // 3
  }
}
