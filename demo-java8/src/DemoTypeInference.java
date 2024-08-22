import java.util.Arrays;
import java.util.List;

public class DemoTypeInference {
  // public static int sum(var x, var y) { // NOT support 'var' for method parameter
  //   return x + y;
  // }

  // public static var sum(int x, int y) { // NOT support 'var' for return type
  //   return x + y;
  // }

  // public class Demo {
  //   private var x; // NOT support 'var' for attribute
  // }

  public static void main(String[] args) {
    // Declaration
    int x;
    // Value assignment
    x = 0;

    var a = 0; // convert to "int a = 0;" during compile-time
    // a = 0.0d; // Type mismatch: cannot convert from double to int
    var b = "hello";
    // b = 0; // Type mismatch: cannot convert from int to String

    List<String> strings = Arrays.asList("a", "b", "c");
    for (var s : strings) {
      System.out.println(s); // a b c
    }

    // NOT Support
    // var age; // Cannot use 'var' on variable without initializer
  }
}
