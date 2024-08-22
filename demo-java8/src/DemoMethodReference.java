import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class DemoMethodReference {
  public static void main(String[] args) {
    // Example 1
    List<Integer> integers = Arrays.asList(3, 7, -5, 100);
    // Lambda
    integers.stream().forEach(i -> System.out.println(i));
    // Method Reference: input = methed parameter -> output
    integers.stream().forEach(System.out::println);

    // Lambda
    integers.stream().forEach(i -> System.out.println(i + 1));
    // Method Reference cannot support

    // Example 2
    String name = "Vincent";
    // Lambda
    Supplier<Integer> nameLength = () -> name.length();
    // Method Reference
    Supplier<Integer> nameLength2 = name::length;

    // Example 3 - Instance method with 2 parameters
    // Lambda
    Comparator<Integer> sortByDesc = (i1, i2) -> i1.compareTo(i2); // i2 > i1 ? 1 : -1;
    // Method Reference
    Comparator<Integer> sortByDesc2 = Integer::compareTo; // 永遠都淨係 i1.compareTo(i2), 做唔到 i2.compareTo(i1)

    // Example 4 - Constructor
    // Lambda
    Function<String, String> constructString = s -> new String(s);
    // Method Reference
    Function<String, String> constructString2 = String::valueOf;
    Function<String, String> constructString3 = String::new;
    System.out.println(constructString3.apply("hello")); // hello
  }
}
