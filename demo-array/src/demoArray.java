import java.util.Arrays;

public class demoArray {
  public static void main(String[] args) {
    // when you create an array object, you have to define the length of it
    int[] arr = new int[3]; // store int value only, and the length = 3
    // arr[index]
    arr[0] = 10;
    arr[1] = 20;
    arr[2] = -3;

    // Complie-time Exception
    // arr [0] = "hello"; // java complier knows that "arr" is an int array
    System.out.println(arr[0]); // 10
    System.out.println(arr[1]); // 20
    System.out.println(arr[2]); // -3

    arr[1] = 100; // replace
    System.out.println(arr[1]); // 100

    // Run-time Exception
    // arr[3] = 200; // java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3

    int[] arr2 = new int[] {10, 20, -3};
    System.out.println(arr2[0]); // 10
    System.out.println(arr2[1]); // 20
    System.out.println(arr2[2]); // -3

    // String array -> "hello", "abc", "ijk"
    String[] str = new String[] {"hello", "abc", "ijk"};
    System.out.println(str[0]);
    System.out.println(str[1]);
    System.out.println(str[2]);

    // upgrade?
    long[] l = new long[] {1, 2, 3};

    // Method: Arrays.
    // Choose and enter to "import java.util.Arrays;"" after typed Arrays
    System.out.println(Arrays.toString(str)); // ["hello", "abc", "ijk"]
    System.out.println(Arrays.toString(arr2)); // [10, 20, -3]

    // 9, -3, -100, 90, 66, -4
    // for loop, print out all
    int[] arr3 = new int[] {9, -3, -100, 90, 66, -4};
    for (int i = 0; i < arr3.length; i++) {
      System.out.println(arr3[i]);
    }
    // for loop
    // find the max value from arr3
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < arr3.length; i++) {
      if (arr3[i] > max) {
        max = arr3[i];
      }
    }
    System.out.println("max = " + max);

    int min = Integer.MAX_VALUE;
    for (int i = 0; i < arr3.length; i++) {
      if (arr3[i] < min) {
        min = arr3[i];
      }
    }
    System.out.println("min = " + min);

    // Exercise
    char[] arr4 = new char[] {'l', 'e', 'e', 'r', 'q'};
    // 1. count number of 'e'
    int count = 0;
    char target = 'e';
    for (int i = 0; i < arr4.length; i++) {
      if (arr4[i] == target) {
        count++;
      }
    }
    System.out.println("Number of '" + target + "' = " + count);

    // 2. boolean result to store if 'r' exist
    boolean isR = false;
    for (int i = 0; i < arr4.length; i++) {
      if (arr4[i] == 'r') {
        isR = true;
        break;
      }
    }
    System.out.println("Does 'r' exist? Ans = " + isR);

    // 3. String result to store "qreel"
    String reversed = "";
    // arr4.length = 5 // java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
    for (int i = arr4.length - 1; i >= 0; i--) {
      reversed += arr4[i];
    }
    System.out.println("reversed = " + reversed);

    // 4. Given two char[] -> append all characters to a String value
    char[] c1 = new char[] {'a', 'b', 'c', 'd'};
    char[] c2 = new char[] {'1', '2', '3', '4'};

    // 4a. result -> "abcd1234"
    String fourA = "";
    for (int i = 0; i < c1.length; i++) {
      fourA += c1[i]; // String value + char -> String
    }
    for (int i = 0; i < c2.length; i++) {
      fourA += c2[i];
    }
    System.out.println("fourA = " + fourA);

    // 4b. result -> when even index, get value from c1, when odd index, get from c2 -> "a2c4"
    // Approach 1:
    String fourB = "";
    int length = c1.length > c2.length ? c1.length : c2.length;
    /*
     * if (c1.length > c2.length) {
     *  length = c1.length;
     * } else {
     *  length = c2.length;
     * }
     */
    for (int i = 0; i < length; i++) {
      if (i % 2 == 0) {
        fourB += c1[i];
      } else {
        fourB += c2[i];
      }
    }
    System.out.println("fourB = " + fourB);
    
    // 4b (challenge). result -> "a2c4a"
    char[] c3 = new char[] {'a', 'b', 'c', 'd', 'a', 'b'};
    char[] c4 = new char[] {'1', '2', '3', '4'};
    String fourC = "";
    int length2 = c3.length > c4.length ? c3.length : c4.length;
    for (int i = 0; i < length2; i++) {
      if (i % 2 == 0 && i < c3.length) {
        fourC += c3[i];
      } else if (i % 2 == 1 && i < c4.length) {
        fourC += c4[i];
      }
    }
    System.out.println("fourB = " + fourC);
  }
}
