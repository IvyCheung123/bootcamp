public class demoMethod {
  public static void main(String[] args) {
    // Method: you put something into the box, and then it return something to you
    // Calling method
    System.out.println("hello");

    // Call method (sum)
    System.out.println("\nint sum() method: ");
    int result = sum(10, 3);
    System.out.println("int method result = " + result); // 10 + 3 = 13

    // Call method (sum2)
    System.out.println("\ndouble sum2() method: ");
    double result2 = sum2(10, 3);
    System.out.println("double method result = " + result2); // 10.0 + 3.0 = 13.0

    // Call method (lastChar)
    System.out.println("\nchar lastChar() method: ");
    System.out.println(lastChar("hello")); // o

    // Call method (toString)
    System.out.println("\nString toString() method: ");
    System.out.println(toString(new char[] {'a', 'b', 'c'})); // "abc"

    // Call method (max)
    System.out.println("\nint max() method: ");
    System.out.println("max = " + max(new int[] {100, 10, -100})); // max = 100

    // Call method (isSubstring)
    System.out.println("\nboolean isSubstring() method: ");
    System.out.println("hello contains ll = " + isSubstring("hello", "ll")); // true
    System.out.println("hello contains lll = " + isSubstring("hello", "lll")); // false
    System.out.println("hello contains lo = " + isSubstring("hello", "lo")); // true

    // Call method (circleArea)
    System.out.println("\ndouble circleArea() method: ");
    System.out.println(circleArea(5)); // 3.14 * (5 * 5) = 78.53981633974483

    // double * double -> is a problem
    // BigDecimal -> solution
    System.out.println(0.2 * 0.1); // 0.020000000000000004
  }

  public static int sum(int x, int y) {
    // if your method is with a return type
    // the method shoud contain a key word "return"
    return x + y; // int + int -> int
  }

  public static double sum2(int x, int y) {
    return x + y; // int + int -> double + double
  }

  public static char lastChar(String s) {
    char c1 = s.charAt(s.length() - 1);
    return c1;
  }

  public static String toString(char[] arr) {
    // Approach 1:
    /*
    String s2 = "";
    for (int i = 0; i < arr.length; i++) {
      s2 += arr[i];
    }
    return s2;
    */

    // Approach 2:
    return String.valueOf(arr);
  }

  public static int max(int[] arr) {
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
    }
    return max;
  }

  public static boolean isElderly(int age) {
    // > 65
    // Approach 1:
    // if (age > 65) {
    //  return true;
    // }
    // return false;
    return age > 65;
  }

  public static boolean isSubstring(String str, String substr) {
    // check if substr is a substring of str
    // Approach 1:
    // return str.contains(substr);

    // Approach 2:
    // indexOf() method returns an int index, which is index position substring
    // if it returns 
    // return str.indexOf(substr) != -1;

    // Approach 3:
    // "hello"
    boolean isSubstring = false;
    for (int i = 0; i < str.length(); i++) { // h e l l o
      for (int j = 0; j < substr.length(); j++) { // h e l l o
        if (str.charAt(i + j) != substr.charAt(j)) {
          break;
        }
        if (j == substr.length() - 1) {
          isSubstring = true;
          return isSubstring;
        }
      }
    }
    return isSubstring;
  }

  public static double circleArea(int radius) {
    /*
    double pi = 3.14;
    double area = pi * (radius * radius);
    return area;
     */
    return (radius * radius) * Math.PI; // int * int * double -> double
  }
}
