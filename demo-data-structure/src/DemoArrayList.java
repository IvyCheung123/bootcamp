import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DemoArrayList {
  public static void main(String[] args) throws Exception {
    Integer[] integers = new Integer[] {2, 10, -4};
    // for-each
    int sum = 0;
    for (Integer i : integers) {
      sum += i;
    }
    System.out.println(sum); // 8

    integers[1] = null; // remove 10
    System.out.println(Arrays.toString(integers)); // [2, null, -4]
    // Integer[] arr = new Integer[integers.length - 1];
    // ... -> remove 10 -> [2, -4]

    // ArrayList
    ArrayList<Integer> integers2 = new ArrayList<Integer>(); // call constructor of ArrayList.class
    integers2.add(2);
    integers2.add(10);
    integers2.add(-4);
    sum = 0;
    for (Integer i : integers2) {
      sum += i;
    }
    System.out.println(sum); // 8

    // Difference between Integer[] and ArrayList<Integer>
    // 1. Initialization: Array (fixed length -> need to create new Array) vs ArrayList (variable length)
    // 2. Underlying structure: Array is a raw DS in java vs ArrayList is a class -> ArrayList.equals()

    System.out.println(integers2.size()); // 3
    integers2.remove(1); // remove 10
    System.out.println(integers2); // [2, -4]

    integers2.set(1, -100);
    System.out.println(integers2); // [2, -100]

    System.out.println(integers2.contains(2)); // true

    System.out.println(integers2.indexOf(2)); // 0
    System.out.println(integers2.indexOf(-100)); // 1
    System.out.println(integers2.indexOf(-1000)); // -1

    integers2.add(2);
    System.out.println(integers2); // [2, -100, 2]
    System.out.println(integers2.indexOf(2)); // 0
    System.out.println(integers2.lastIndexOf(2)); // 2

    System.out.println(integers2.subList(1, 3)); // [-100, 2] -> no impact on integer2
    System.out.println(integers2); // [2, -100, 2]

    ArrayList<Integer> integers3 = new ArrayList<Integer>();
    System.out.println(integers3.isEmpty()); // true
    integers3.addAll(integers2);
    System.out.println(integers3); // [2, -100, 2]
    System.out.println(integers3.isEmpty()); // false
    integers3.removeAll(integers2);
    System.out.println(integers3); // []

    ArrayList<String> strings = new ArrayList<>();
    // You can skip the type declaration when you create the ArrayList object
    // by default it follow the type specified at the left hand side

    strings.add("hello");
    strings.add("abc");
    strings.add("world");
    strings.remove(1);
    System.out.println(strings); // [hello, world]

    strings.add("hello");
    System.out.println(strings); // [hello, world, hello]
    strings.remove("hello");
    System.out.println(strings); // [world, hello]

    System.out.println(strings.get(0)); // world

    // Question 1: Given String[], remove those string with length <= 3
    String[] arr = new String[] {"abc", "a", "", null, "aaaa"};
    ArrayList<String> result = new ArrayList<>();
    // loop
    for (String s : arr) {
      if (s != null && s.length() > 3) {
        result.add(s);
      }
    }
    System.out.println(result); // [aaaa]

    // Question 2: Given Customer[], retrieve all customer object with age > 30 or name startsWith "J"
    Customer[] customers = new Customer[] {new Customer(20, "Mary"), new Customer(31, "John"), new Customer(29, "Jason")};
    ArrayList<Customer> customerList = new ArrayList<>();
    for (Customer customer : customers) {
      if (customer.getAge() > 30 || (customer.getName() != null && customer.getName().startsWith("J"))) {
        customerList.add(customer);
      }
    }
    System.out.println(customerList); // [Customer(31, John), Customer(29, Jason)]

    // subList()
    ArrayList<Integer> integers4 = new ArrayList<>();
    integers4.add(10);
    integers4.add(20);
    integers4.add(30);
    List<Integer> subList = integers4.subList(1, 3); // from StartIdx to EndIdx - 1
    System.out.println(subList); // [20, 30]

    System.out.println();
    // toArray()
    List<String> strs = new ArrayList<>();
    strs.add("hello");
    strs.add("world");
    String[] stringsArray = strs.toArray(new String[0]);
    System.out.println(stringsArray);

    ArrayList<Object> objects = new ArrayList<>();
    objects.add(new String("abc"));
    objects.add(1);
    objects.add(LocalDate.of(2000, 01, 01));
    objects.add(new HKID("A1234567"));

    // Polymorphism Part 2: run-time -> implementation
    // print
    // check if the object equals to
    // compare the difference between ArrayList<Object> and ArrayList<String>
    for (Object obj : objects) {
      if (obj.equals(new String("abc"))) { // true, call String.equals()
        System.out.println("String abc");
      } else if (obj.equals(new HKID("A1234567"))) { // true, call HKID.equals()
        System.out.println("HKID A1234567");
      }
    }
  }
}
