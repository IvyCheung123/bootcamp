import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class DemoOptional {
  // Method author
  public static String generate(String s) {
    if (s == null)
      return null;
    return s.replace('a', 'b').toUpperCase();
  }

  // Solution 1. Optional<>: cannot new Optional object -> private constructor
  // Ways to create Optional object
  // 1. Optional.of(nonNullValue);
  // 2. Optional.ofNullable(valueWhetherNullOrNot);
  // 3.
  Optional<String> optString = Optional.empty(); // same as Optional.ofNullable(null)

  public static Optional<String> generate2(String s) {
    if (s == null)
      return Optional.ofNullable(null);
    return Optional.of(s.replace('a', 'b').toUpperCase());
  }

  public static void main(String[] args) {
    String s = "hello";
    s = null;
    System.out.println(generate(s)); // null, OK

    // Method user
    // Solution 1. Optional<>: 做return type
    // generate2() -> return Optional<String> -> the return value can be null or not null
    // java force you to handle potential null scanario during compile-time
    // generate2(s).charAt;
    Optional<String> result = generate2(s);
    char target = ' ';
    if (result.isPresent()) { // is not null
      target = result.get().charAt(0);
    } else { // is null
      target = '-';
    }

    // ifPresent() -> Lambda Expression
    target = ' ';
    int x = 0;
    generate2("abc").ifPresent(str -> {
      // target = str.charAt(0); // Not ok for write variables outside local block
      System.out.println(x); // Ok for read variables outside local block
    });

    // Stream -> findFirst(), findAny()
    List<Customer> customers = Arrays.asList(new Customer("John", 13),
      new Customer("Jenny", 30), new Customer("Peter", 28));

    Optional<Customer> optCustomer = customers.stream()
      .filter(c -> c.getAge() > 20)
      .findFirst(); // return Optional<>, becoz you may or may not find the target element
    optCustomer.ifPresent(c -> System.out.println(c)); // Customer(name=Jenny, age=30)

    customers.stream()
      .filter(c -> c.getAge() > 20)
      .findFirst()
      .ifPresent(c -> System.out.println(c)); // Customer(name=Jenny, age=30)

    // You should not findFirst() and then get()
    // customers.stream()
    //   .filter(c -> c.getAge() > 50)
    //   .findFirst() // Optional.ofNullable(null)
    //   .get(); // run-time error, java.util.NoSuchElementException: No value present

    // Ways to take out <E> from Optional object
    // 1. isPresent()
    // 2. ifPresent()
    // 3. orElse(): Convert from Optional<T> to new T object if is null
    Optional<Customer> optCustomer2 = Optional.of(new Customer("Mary", 21)); // is not null
    Customer customer = optCustomer2.orElse(new Customer("Susan", 20)); // if is null
    System.out.println(customer); // Customer(name=Mary, age=21)

    Optional<String> optString = null;
    // optString.get(); // NPE
    Optional<String> optString2 = Optional.empty(); // same as Optional.ofNullable(null)
    // optString2.get(); // java.util.NoSuchElementException: No value present
    // Box<T> box = null; // NPE
    // Box<T> box = new Box<>(null);

    // 4. orElseThrow()
    Customer customer2 = optCustomer2.orElseThrow(() -> new RuntimeException());
    // 5. orElseGet()
    Customer customer3 = optCustomer2.orElseGet(() -> new Customer("Dummy", -99));


  }
}
