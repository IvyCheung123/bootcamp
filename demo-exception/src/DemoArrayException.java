import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DemoArrayException {
  public static String getDescription(int age) {
    // Early return
    if (age < 0)
      throw new IllegalArgumentException("Age should not be < 0"); // invalid parameter
    if (age > 100)
      throw new IllegalArgumentException("Age should not be > 100");
    if (age >= 66)
      return "Elderly";
    if (age >= 18)
      return "Adult";
    return "Children";
  }
  public static void main(String[] args) {
    int[] arr = new int[5];
    arr[0] = 1;
    arr[1] = 1;
    arr[2] = 1;
    arr[3] = 1;
    arr[4] = 1;
    // arr[5] = 1; // java.lang.ArrayIndexOutOfBoundsException

    int idx = 0;
    if (idx >= 0 && idx < arr.length) {
      arr[idx] = 2;
    }

    try {
      arr[5] = 1;
    } catch (ArrayIndexOutOfBoundsException e) {
      // handling ...
    }

    String str = "hello";
    // Should not happen ...
    // str.charAt(str.length()); // java.lang.StringIndexOutOfBoundsException
    // str.substring(-1); // java.lang.StringIndexOutOfBoundsException

    int i = Integer.parseInt("1");
    System.out.println(i); // 1

    int i2;
    try {
      i2 = Integer.parseInt("a"); // java.lang.NumberFormatException
    } catch (NumberFormatException e) {
      i2 = -1;
      System.out.println(e.getMessage()); // For input string: "a"
    }
    System.out.println(i2); // -1

    int age = -1;
    try {
      DemoArrayException.getDescription(age);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage()); // Age should not be < 0
    }

    List<String> strings = new ArrayList<>(); // arr[0]
    // strings.get(0); // java.lang.IndexOutOfBoundsException

    List<String> strings2 = new LinkedList<>();
    // strings2.get(0); // java.lang.IndexOutOfBoundsException
  }
}
