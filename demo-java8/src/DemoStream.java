import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DemoStream {
  public static void main(String[] args) {
    List<String> strings = new LinkedList<>();
    strings.add("A");
    strings.add("B");
    strings.add("C");

    // Lamdba forEach
    strings.forEach(s -> System.out.println(s)); // A B C

    for (int i = 0; i < strings.size(); i++) {
      strings.set(i, strings.get(i).toLowerCase());
    }
    System.out.println(strings); // [a, b, c]

    List<String> capStrings = strings.stream() // List<String> -> new Stream<String> (Stream is a new DS out of Collection)
        .map(s -> {
          if ("a".equals(s))
            return s.toUpperCase();
          return s;
        }) // Stream<String>
        .collect(Collectors.toList()); // new List<String>
    System.out.println(strings); // [a, b, c]
    System.out.println(capStrings); // [A, b, c]

    capStrings.add("c");
    System.out.println(capStrings); // [A, b, c, c]

    Set<String> capStrings2 = capStrings.stream().map(s -> {
      String newStr = s.toLowerCase() + s.toUpperCase();
      return newStr + "!";
    }).collect(Collectors.toSet()); // new List<String>
    System.out.println(capStrings2); // [bB!, cC!, aA!]

    // Stream Method Tools
    // 1. collect()
    // 2. filter()
    // 3. map()
    List<Customer> customers = new LinkedList<>();
    customers.add(new Customer("a", 10));
    customers.add(new Customer("b", 20));
    customers.add(new Customer("c", 30));

    List<Customer> customersAfterFilter = customers.stream()
      .filter(customer -> customer.getAge() >= 20)
      .collect(Collectors.toList());
    System.out.println(customersAfterFilter); // [Customer(name=b, age=20), Customer(name=c, age=30)]

    List<String> customersNameAfterFilter = customers.stream() // Stream<Customer>
      .filter(c -> c.getName().length() >= 1) // Stream<Customer>
      .map(c -> c.getName()) // Stream<String>
      .collect(Collectors.toList()); // List<String>
    System.out.println(customersNameAfterFilter); // [a, b, c]

    List<String> customersNameList = new ArrayList<>();
    for (Customer c : customers) {
      if (c.getName().length() >= 1) {
        customersNameList.add(c.getName());
      }
    }
    System.out.println(customersNameList); // [a, b, c]

    // 先filter後map 快過 先map後filter
    customers.stream()
      .map(c -> c.getName())
      .filter(str -> str.length() >= 1)
      .collect(Collectors.toList());

    customers.stream()
      .filter(c -> c.getName().length() >= 1) // filter() return Stream
      .map(c -> c.getName()) // map() return Stream
      // so we can .method() in Stream to convert from <Customer> to <String>
      .forEach(name -> System.out.println(name));

    // 4. count()
    customers.stream()
    .filter(c -> c.getAge() < 20)
      .count();

    customers.add(new Customer("c", 12));

    // 5. distinct(): remove duplicate by equals() & hashCode()
    List<Customer> customersAfterDistinct = customers.stream()
      .distinct() // Stream<Customer>
      .collect(Collectors.toList());
    System.out.println(customersAfterDistinct); // [a 10, b 20, c 30]

    // 6. sorted()
    Comparator<Customer> sortByAge = (c1, c2) -> c1.getAge() < c2.getAge() ? -1 : 1; // Lambda (skip Class implements Comparator.interface)

    List<String> customersAfterSorted = customers.stream()
      .filter(c -> c.getAge() < 40)
      .sorted((c1, c2) -> c1.getAge() < c2.getAge() ? -1 : 1) // sort by age ascending order
      .map(c -> c.getName())
      .collect(Collectors.toList());
    System.out.println(customersAfterSorted); // [a, c, b, c] -> 10, 12, 20, 30

    // Terminal Operation: collect(), count(), etc -> return non-Stream
    // Interminate Operation: filter(), map(), sorted(), distinct() -> return Stream
    Stream<Customer> customersStream = customers.stream() // Stream<Customer>
      .filter(c -> (!("a".equals(c.getName())))); // Stream<Customer>
    System.out.println(customersStream.count()); // 3
    // System.out.println(customersStream.collect(Collectors.toList())); // run-time error
    // java.lang.IllegalStateException: stream has already been operated upon or closed
    // You cannot perform 2 terminal operation on a Stream object (obj ref)

    // Map -> key=name, value=name.length()
    List<String> animals = Arrays.asList("Lion", "Tiger", "Bear");
    // Convert from List to Stream to Map
    Map<String, Integer> animalsMap = animals.stream()
      .collect(Collectors.toMap(s -> s, s -> s.length()));
    System.out.println(animalsMap); // {Lion=4, Bear=4, Tiger=5}

    // 7. Collectors.groupingBy()
    List<Staff> staffs = Arrays.asList(new Staff("HR", "John"), 
      new Staff("IT", "Peter"), new Staff("MKT", "Sally"), new Staff("IT", "Vincent"));
    Map<String, List<Staff>> staffsMap = staffs.stream()
      .collect(Collectors.groupingBy(staff -> staff.getDepartment()));
    System.out.println(staffsMap.get("IT")); // [Staff(dept=IT, name=Peter), Staff(dept=IT, name=Vincent)]
    // Convert from List<Staff> to Map<String, List<Staff>>
    // contains -> get -> List.add() -> put
    // !contains -> new ArrayList -> add() -> put
    // for loop

    // 8. Collectors.summingInt()
    List<Staff> staffsList = Arrays.asList(new Staff("HR", "John", 30_000), 
    new Staff("IT", "Peter", 40_000), new Staff("MKT", "Sally", 25_000), 
    new Staff("IT", "Vincent", 20_000));
    Map<String, Integer> deptMap = staffsList.stream()
      .collect(Collectors.groupingBy(s -> s.getDepartment(),
        Collectors.summingInt(s -> s.getSalary())));
    System.out.println(deptMap.get("HR")); // 30000
    System.out.println(deptMap.get("IT")); // 60000
    System.out.println(deptMap.get("MKT")); // 25000

    // Construct Stream object by initial values
    Stream<Integer> integers = Stream.of(4, 1, 2, 3);

    Stream<Staff> staffsStream = Stream.empty(); // Stream Empty Constructor

    // filter(): reduce <E>
    // map(), sorted(): revise object definition but no change on <E> count()
    // distinct(): revise object definition and reduce <E>
    // count(), groupingBy(), summingInt(): summarize <E>
    // Stream: no add <E>

    // Special case
    List<Integer> integers2 = Stream.of(2, 3, 4)
      .map(i -> i + 1)
      .collect(Collectors.toList()); // [3, 4, 5]
    
    List<Integer> integers3 = Stream.of(2, 3, 4)
      .map(i -> { // map (interminate operation)
        System.out.println(i);
        // sysout not working -> not perform terminal operation -> not execute
        return i + 1;
      }).collect(Collectors.toList()); // collect (terminal operation) -> execute & close Stream
    System.out.println(integers3);
    // 2
    // 3
    // 4
    // [3, 4, 5]

    Stream<Integer> integers4 = Stream.of(2, 3, 4)
      .map(i -> { // map (interminate operation)
        System.out.println(i);
        return i + 1;
      });
    System.out.println(integers4.count()); // 3, but not sysout 2 3 4
    // terminal operation observes interminate operations, check if they will make impact or not
    // so, finally map() won't execute, it will not affect the result of count()
  }
}
