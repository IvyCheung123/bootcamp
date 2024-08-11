import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class DemoStream {
  public static void main(String[] args) {
    List<String> strings = new LinkedList<>();
    strings.add("John");
    strings.add("Johnny");
    strings.add("Sam");

    // Lamdba forEach
    strings.forEach(s -> System.out.println(s)); // John Johnny Sam

    for (int i = 0; i < strings.size(); i++) {
      strings.set(i, strings.get(i).toLowerCase());
    }
    System.out.println(strings); // [john, johnny, sam]

    List<String> capNames = strings.stream() // List<String> -> Stream<String> (Stream is a new DS out of Collection)
        .map(s -> s.toUpperCase()) // Stream<String>
        .collect(Collectors.toList()); // List<String> (new object)
    System.out.println(strings); // [john, johnny, sam]
    System.out.println(capNames); // [JOHN, JOHNNY, SAM]

    capNames.add("SAM");
    System.out.println(capNames); // [JOHN, JOHNNY, SAM, SAM]

    Set<String> capNames2 = capNames.stream().map(s -> {
      String newStr = s.toLowerCase() + s.toUpperCase();
      return newStr + "!!!";
    }).collect(Collectors.toSet()); // List<String> (new object)
    System.out.println(capNames2); // [samSAM!!!, johnJOHN!!!, johnnyJOHNNY!!!]
  }
}
